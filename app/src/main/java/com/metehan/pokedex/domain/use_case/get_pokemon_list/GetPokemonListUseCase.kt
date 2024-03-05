package com.metehan.pokedex.domain.use_case.get_pokemon_list

import com.metehan.pokedex.data.remote.responses.PokemonList
import com.metehan.pokedex.domain.repository.PokemonRepository
import com.metehan.pokedex.util.Constants.PAGE_SIZE
import com.metehan.pokedex.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val repository: PokemonRepository) {

    fun executePokemonPaginated(limit: Int, offSet: Int): Flow<Resource<PokemonList>> = flow{
        try {
            emit(Resource.Loading())
            val response = repository.getPokemonList(limit = limit, offset = offSet)
            emit(Resource.Success(response))
        }catch (e: Exception){
            emit(Resource.Error(message = "An error occurred."))
        }
    }
}