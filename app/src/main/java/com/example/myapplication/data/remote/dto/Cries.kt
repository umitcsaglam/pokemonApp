package com.example.myapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Cries(
    val latest: String,
    val legacy: String
)