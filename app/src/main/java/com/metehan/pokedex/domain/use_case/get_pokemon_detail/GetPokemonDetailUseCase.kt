package com.metehan.pokedex.domain.use_case.get_pokemon_detail

import com.metehan.pokedex.data.remote.responses.Pokemon
import com.metehan.pokedex.domain.repository.PokemonRepository
import com.metehan.pokedex.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val repository: PokemonRepository){
    fun executePokemonInfo(pokemonName: String): Flow<Resource<Pokemon>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getPokemonDetail(pokemonName= pokemonName)
            emit(Resource.Success(data = response))
        }catch (e: Exception){
            emit(Resource.Error("An error occurred."))
        }
    }
}