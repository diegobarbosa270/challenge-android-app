package com.dob.desafioapp.domain.usecase

import com.dob.desafioapp.data.repository.IHomeRepository
import com.dob.desafioapp.domain.entity.Card

class HomeUseCase(private val homeRepository: IHomeRepository) {

    suspend fun getCardList(): List<Card> {
        val result = homeRepository.getCardList()

        if (result.isNotEmpty()) {
            return result
        }
        return emptyList()
    }

}