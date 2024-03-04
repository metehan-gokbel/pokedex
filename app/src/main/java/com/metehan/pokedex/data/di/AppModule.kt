package com.metehan.pokedex.data.di

import com.metehan.pokedex.data.remote.PokeAPI
import com.metehan.pokedex.data.repository.PokemonRepositoryImpl
import com.metehan.pokedex.domain.repository.PokemonRepository
import com.metehan.pokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokeAPI(): PokeAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeAPI::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(pokeAPI: PokeAPI): PokemonRepository {
        return PokemonRepositoryImpl(pokeAPI)
    }
}