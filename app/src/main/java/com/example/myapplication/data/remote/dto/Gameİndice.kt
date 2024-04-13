package com.example.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Gameİndice(
    @SerializedName("game_index")
    val gameİndex: Int,
    val version: Version
)