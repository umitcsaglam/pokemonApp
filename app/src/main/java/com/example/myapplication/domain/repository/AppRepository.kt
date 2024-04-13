package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.data.remote.dto.PokemonList
import com.example.myapplication.domain.model.Pokemon

interface AppRepository{
    suspend fun getPokemon(limit:Int,offset:Int):PokemonList
    suspend fun getPokemonDetail(name:String):PokemonDetialList
}