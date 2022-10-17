package com.dob.desafioapp.domain

import com.dob.desafioapp.domain.entity.Card
import com.google.gson.annotations.SerializedName

data class RespostaCard(
    @SerializedName("Classic")
    val cards: List<Card>
)
