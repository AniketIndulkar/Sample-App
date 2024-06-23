package com.novanest.sample_app.data.remote

import com.squareup.moshi.Json

data class DisneyCharacterModel(
    val allies: List<String>,
    val createdAt: String,
    val enemies: List<String>,
    val films: List<String>,
    val imageUrl: String,
    val name: String,
    val parkAttractions: List<String>,
    val shortFilms: List<String>,
    val sourceUrl: String,
    val tvShows: List<String>,
    val updatedAt: String,
    val url: String,
    val videoGames: List<String>,
    @field:Json(name="_id")
    val id: Int? = null
)
