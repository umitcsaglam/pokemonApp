package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.AppAPI
import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.data.remote.dto.PokemonList
import com.example.myapplication.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val api:AppAPI):AppRepository{
    override suspend fun getPokemon(limit: Int, offset: Int): PokemonList {
        return api.getPokemon(limit,offset)
    }
    override suspend fun getPokemonDetail(name: String): PokemonDetialList {
       return api.getPokemonDetail(name)
    }
}