package com.example.myapplication.data.remote.dto


import com.example.myapplication.domain.model.PokemonDetail
import com.google.gson.annotations.SerializedName

data class PokemonDetialList(
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val cries: Cries,
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameİndices: List<Gameİndice>,
    val height: Int,
    @SerializedName("held_items")
    val heldİtems: List<Any>,
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerializedName("past_abilities")
    val pastAbilities: List<Any>,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

