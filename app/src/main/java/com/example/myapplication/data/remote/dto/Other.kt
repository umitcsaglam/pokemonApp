package com.example.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,
    val home: Home,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)