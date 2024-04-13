package com.example.myapplication.domain.use_case.get_pokemon_detail

import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.domain.repository.AppRepository
import com.example.myapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class getPokemonDetailUseCase @Inject constructor(private val repository:AppRepository) {
    fun executeGetPokemonDetail(name:String):Flow<Resource<List<PokemonDetialList>>> = flow {
     try {
         emit(Resource.Loading())
         val pokeDetail = repository.getPokemonDetail(name)
         emit(Resource.Success(listOf(pokeDetail)))
     }catch (e:IOError){
         emit(Resource.Error("İnternet bağlantısı sağlanamadı!"))

     }
    }
}