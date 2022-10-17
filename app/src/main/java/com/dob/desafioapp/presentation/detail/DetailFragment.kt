package com.dob.desafioapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.dob.desafioapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val detailArgs: DetailFragmentArgs by lazy {
        DetailFragmentArgs.fromBundle(requireArguments())
    }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.name.text = detailArgs.card.name
        binding.description.text = detailArgs.card.text
        Glide.with(requireContext())
            .load(detailArgs.card.img)
            .into(binding.imageViewCard)
        val description = "${detailArgs.card.type} / ${detailArgs.card.rarity}"
        binding.cardInfo.text = description
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}