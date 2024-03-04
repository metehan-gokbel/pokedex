package com.metehan.pokedex.data.remote.responses


import com.google.gson.annotations.SerializedName

data class İtem(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)