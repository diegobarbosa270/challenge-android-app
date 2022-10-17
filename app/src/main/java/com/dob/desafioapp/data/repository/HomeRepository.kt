package com.dob.desafioapp.data.repository

import com.dob.desafioapp.data.database.ICardDAO
import com.dob.desafioapp.data.request.ICardApi
import com.dob.desafioapp.domain.entity.Card

class HomeRepository(private val cardApi: ICardApi, private val cardDAO: ICardDAO) :
    IHomeRepository {

    override suspend fun getCardList(): List<Card> {
        val cache = cardDAO.getAllCards()

        if (cache.isNotEmpty()) {
            return cache
        }
        return requestCardList()
    }

    override suspend fun requestCardList(): List<Card> {
        val resultApi = cardApi.getList().body()?.cards

        resultApi?.let {
            cardDAO.insert(it)
            return it
        }

        return emptyList()
    }

}