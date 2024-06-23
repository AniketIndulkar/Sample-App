package com.novanest.sample_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisneyCharacterEntity(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val imageUrl : String,
    val allies: List<String>,
    val createdAt: String,
    val enemies: List<String>,
    val films: List<String>,
    val parkAttractions: List<String>,
    val shortFilms: List<String>,
    val sourceUrl: String,
    val tvShows: List<String>,
    val updatedAt: String,
    val url: String,
    val videoGames: List<String>
)
