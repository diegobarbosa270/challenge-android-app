package com.dob.desafioapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dob.desafioapp.domain.entity.Card
import com.dob.desafioapp.domain.usecase.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val homeUseCase: HomeUseCase) : ViewModel() {

    private val resultListMutable: MutableLiveData<List<Card>> = MutableLiveData()
    val resultList: LiveData<List<Card>>
        get() = resultListMutable

    fun getCardList() {
        viewModelScope.launch {
            resultListMutable.postValue(homeUseCase.getCardList())
        }
    }
}