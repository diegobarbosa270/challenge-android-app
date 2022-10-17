package com.dob.desafioapp.data.repository

import com.dob.desafioapp.domain.entity.Card

interface IHomeRepository {

    suspend fun getCardList(): List<Card>

    suspend fun requestCardList(): List<Card>

}