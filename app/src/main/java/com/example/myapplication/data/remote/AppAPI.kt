package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.data.remote.dto.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppAPI {
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ):PokemonList
    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name : String
    ):PokemonDetialList
}