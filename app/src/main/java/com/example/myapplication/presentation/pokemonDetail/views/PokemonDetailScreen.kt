package com.example.myapplication.presentation.pokemonDetail.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.remote.dto.PokemonDetialList
import com.example.myapplication.presentation.pokemonDetail.PokemonDetailViewModel
import com.example.myapplication.util.Resource

@Composable
fun PokemonDetailScreen(
    dominantColor:Color,
    pokemonName:String,
    navColor: NavController,
    topPadding:Dp =20.dp,
    pokemonImageSize:Dp = 200.dp,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val pokemonList by remember {viewModel.pokemonDetail}

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(dominantColor)
        .padding(bottom = 16.dp)
    ){
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ){
         



        }

    }



}