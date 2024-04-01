package com.example.myapplication.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.presentation.Screen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
        ){

        composable(Screen.HomeScreen.route){

            //Home Screen
        }
        composable(Screen.DetailScreen.route){

            //Detail Screen

        }
    }
}
