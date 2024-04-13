package com.example.myapplication.domain.use_case.get_pokemon

import com.example.myapplication.data.remote.dto.toPokemon
import com.example.myapplication.domain.model.Pokemon
import com.example.myapplication.domain.repository.AppRepository
import com.example.myapplication.util.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class getPokemonUseCase @Inject constructor(private val repository: AppRepository) {
    fun executeGetPokemon(limit:Int,offset:Int): kotlinx.coroutines.flow.Flow<Resource<List<Pokemon>>> = flow {
        try {
            emit(Resource.Loading())
            val pokemonList = repository.getPokemon(limit,offset)
            if (pokemonList.count.equals("9999")){
                emit(Resource.Error("Bağlantı hatası!!"))
            }else{
                emit(Resource.Success(pokemonList.toPokemon()))
            }
            }catch (e:IOError){
                emit(Resource.Error("İnternet bağlantısı sağlanamadı"))
            }
        }
    }