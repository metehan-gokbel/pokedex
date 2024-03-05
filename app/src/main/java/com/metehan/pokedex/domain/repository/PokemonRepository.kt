package com.metehan.pokedex.domain.repository

import com.metehan.pokedex.data.remote.responses.Pokemon
import com.metehan.pokedex.data.remote.responses.PokemonList

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList
    suspend fun getPokemonDetail(pokemonName: String): Pokemon
}