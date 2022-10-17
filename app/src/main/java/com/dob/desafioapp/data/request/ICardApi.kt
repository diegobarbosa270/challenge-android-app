package com.dob.desafioapp.data.request

import com.dob.desafioapp.domain.RespostaCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ICardApi {

    @Headers(
        "",
        ""
    )
    @GET("cards")
    suspend fun getList(
        @Query("locale") locale: String = "ptBR",
        @Query("collectible") collectible: Int = 1
    ): Response<RespostaCard>
}