package com.dob.desafioapp.data.request

import com.dob.desafioapp.domain.RespostaCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ICardApi {

    @Headers(
        "x-rapidapi-host:omgvamp-hearthstone-v1.p.rapidapi.com",
        "x-rapidapi-key:c39d3e2b17msh2363b2659b59d55p1e4a0djsnbdb88c7e5cb3"
    )
    @GET("cards")
    suspend fun getList(
        @Query("locale") locale: String = "ptBR",
        @Query("collectible") collectible: Int = 1
    ): Response<RespostaCard>
}