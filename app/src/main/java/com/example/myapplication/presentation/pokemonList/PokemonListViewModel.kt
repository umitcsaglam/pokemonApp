package com.example.myapplication.presentation.pokemonList

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.palette.graphics.Palette
import coil.Coil
import coil.request.ImageRequest
import com.example.myapplication.domain.model.Pokemon
import com.example.myapplication.domain.repository.AppRepository
import com.example.myapplication.domain.use_case.get_pokemon.getPokemonUseCase
import com.example.myapplication.presentation.Screen
import com.example.myapplication.presentation.ui.theme.RobotoCondensed
import com.example.myapplication.util.Constants.PAGE_SIZE
import com.example.myapplication.util.Resource
import com.google.accompanist.coil.CoilImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonUseCase: getPokemonUseCase
):ViewModel() {
    
    private var curPage = 1
    private var job: Job? = null

    var pokemonList = mutableStateOf<List<Pokemon>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var isReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<Pokemon>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    fun searchPokemonList(query:String){
        val listToSearch = if(isSearchStarting){
            pokemonList.value
        }else{
            cachedPokemonList
        }
        viewModelScope.launch(Dispatchers.Default){
            if(query.isEmpty()){
                pokemonList.value=cachedPokemonList
                isSearching.value=false
                isSearchStarting=true
                return@launch
            }
            val results = listToSearch.filter {
                it.pokemonName.contains(query.trim(),ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if (isSearchStarting){
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value=results
            isSearching.value=true
        }
    }
    init {
        loadPokemonPaginated()
    }
     fun loadPokemonPaginated(){
         job?.cancel()
         job = getPokemonUseCase.executeGetPokemon(PAGE_SIZE, curPage * PAGE_SIZE).onEach {
             when(it){
                 is Resource.Success -> {
                     pokemonList.value = it.data!!
                     pokemonList.value+it.data
                     curPage++
                 }
                 is Resource.Error -> {
                     loadError.value=it.message?:"Hata!"
                 }
                 is Resource.Loading -> {

                 }
             }
         }.launchIn(viewModelScope)
        }
    fun calcDominantColor(drawable: Drawable,onFinish: (Color)-> Unit ){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888,true)
        Palette.from(bmp).generate{palette->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}

