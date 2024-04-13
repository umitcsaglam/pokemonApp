package com.example.myapplication.presentation.pokemonDetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.domain.model.Pokemon
import com.example.myapplication.domain.use_case.get_pokemon.getPokemonUseCase
import com.example.myapplication.domain.use_case.get_pokemon_detail.getPokemonDetailUseCase
import com.example.myapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository:getPokemonDetailUseCase):ViewModel() {

    private var job: Job? = null
    var pokemonDetail = mutableStateOf<List<PokemonDetialList>>(listOf())

    fun cancan(name:String){
        job?.cancel()
        job = repository.executeGetPokemonDetail(name).onEach {
            when(it){
                is Resource.Success -> {
                    pokemonDetail.value=it.data!!


                }
                is Resource.Loading -> {
                    Resource.Loading(it)

                }
                is Resource.Error -> {

                }
            }
        }.launchIn(viewModelScope)

    }
}