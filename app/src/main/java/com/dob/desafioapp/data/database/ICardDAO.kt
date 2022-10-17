package com.dob.desafioapp.data.database

import androidx.room.Dao
import androidx.room.Query
import com.dob.desafioapp.data.database.dao.BaseDAO
import com.dob.desafioapp.domain.entity.Card

@Dao
interface ICardDAO : BaseDAO<Card> {

    @Query("SELECT c.* FROM card c WHERE c.cardId=:id")
    suspend fun getCard(id: Int): Card

    @Query("SELECT c.* FROM card c")
    suspend fun getAllCards() : List<Card>

    @Query("DELETE FROM card")
    suspend fun deleteAll()

}