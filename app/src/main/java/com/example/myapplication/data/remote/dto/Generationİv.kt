package com.example.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Generationİv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)