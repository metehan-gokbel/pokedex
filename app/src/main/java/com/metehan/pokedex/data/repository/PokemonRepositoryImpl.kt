package com.metehan.pokedex.data.repository

import com.metehan.pokedex.data.remote.PokeAPI
import com.metehan.pokedex.data.remote.responses.Pokemon
import com.metehan.pokedex.data.remote.responses.PokemonList
import com.metehan.pokedex.domain.repository.PokemonRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(private val api: PokeAPI): PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList {
        return api.getPokemonList(limit = limit, offset =  offset)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Pokemon {
        return api.getPokemonInfo(pokemonName = pokemonName)
    }

}