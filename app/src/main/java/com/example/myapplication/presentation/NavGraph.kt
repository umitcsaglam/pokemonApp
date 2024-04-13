package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.presentation.pokemonList.views.PokemonListScreen
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
        ){
        composable(Screen.HomeScreen.route){
            PokemonListScreen(navController = navController)
        }
        composable(
          route="detail_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument("dominantColor"){
                type= NavType.IntType
                },
                navArgument("pokemonName"){
                type= NavType.StringType
                }
            )
        ){
            val dominantColor= remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let{ Color(it) }?:Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString("pokemonName")
            }
            //Detail Screen
        }
    }
}
