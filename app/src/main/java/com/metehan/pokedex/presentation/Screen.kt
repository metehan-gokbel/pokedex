package com.metehan.pokedex.presentation

sealed class Screen (val route: String){
    object PokemonListScreen: Screen("pokemon_list_screen")
    object PokemonDetailScreen: Screen("pokemon_detail_screen")
}
