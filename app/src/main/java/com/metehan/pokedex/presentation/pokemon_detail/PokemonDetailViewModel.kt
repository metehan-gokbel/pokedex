package com.metehan.pokedex.presentation.pokemon_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehan.pokedex.domain.use_case.get_pokemon_detail.GetPokemonDetailUseCase
import com.metehan.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val useCase: GetPokemonDetailUseCase): ViewModel() {

    private var job: Job? = null

    fun getPokemonDetail(pokemonName: String) {
        job?.cancel()
        job = useCase.executePokemonInfo(pokemonName).onEach {
            when(it){
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

}