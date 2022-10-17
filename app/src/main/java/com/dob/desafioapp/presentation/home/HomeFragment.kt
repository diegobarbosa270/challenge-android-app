package com.dob.desafioapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dob.desafioapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()
    private val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }
    private val adapterCards = AdapterCards {
        navController.navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                it
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
        initRequest()
        setupRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun initRequest() {
        binding.progressBar.visibility = View.VISIBLE
        homeViewModel.getCardList()
    }

    private fun initObserver() {
        homeViewModel.resultList.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            adapterCards.submitList(it.subList(0, 50))
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerviewCards) {
            adapter = adapterCards
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}