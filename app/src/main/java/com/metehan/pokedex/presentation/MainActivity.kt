package com.metehan.pokedex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.metehan.pokedex.presentation.pokemon_list.views.PokemonListScreen
import com.metehan.pokedex.presentation.ui.theme.PokedexTheme
import com.metehan.pokedex.util.Constants.DOMINANT_COLOR
import com.metehan.pokedex.util.Constants.POKEMON_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.PokemonListScreen.route
                ) {
                    composable(route = Screen.PokemonListScreen.route) {
                        PokemonListScreen(navController = navController)
                    }
                    composable(route = Screen.PokemonDetailScreen.route + "/{${DOMINANT_COLOR}/${POKEMON_NAME}}",
                        arguments = listOf(
                            navArgument(POKEMON_NAME) {
                                type = NavType.IntType
                            },
                            navArgument(DOMINANT_COLOR) {
                                type = NavType.StringType
                            }
                        )) {
                        val cryptoId = remember {
                            val color = it.arguments?.getInt(DOMINANT_COLOR)
                            color?.let { Color(it) }?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString(POKEMON_NAME)
                        }
                    }
                }
            }
        }
    }
}