package com.dob.desafioapp.domain.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Card(
    @PrimaryKey
    val cardId: String,
    val name: String?,
    val type: String?,
    val text: String?,
    val rarity: String?,
    val img: String?
) : Parcelable
