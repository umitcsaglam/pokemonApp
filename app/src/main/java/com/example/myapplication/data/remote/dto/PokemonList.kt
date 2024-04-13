package com.example.myapplication.data.remote.dto


import androidx.compose.ui.text.capitalize
import com.example.myapplication.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)
fun PokemonList.toPokemon():List<Pokemon> {
    return results.mapIndexed { index, entry ->
        val number = if (entry.url.endsWith("/")) {
            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            entry.url.takeLastWhile { it.isDigit() }
        }
        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
        Pokemon(entry.name,url,number.toInt())
    }
}