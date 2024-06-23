package com.novanest.sample_app.data.mapper

import com.novanest.sample_app.data.local.entity.DisneyCharacterEntity
import com.novanest.sample_app.data.remote.DisneyCharacterModel
import com.novanest.sample_app.domain.model.DisneyCharacter

// Function to map DisneyCharacterEntity to DisneyCharacter
fun DisneyCharacterEntity.toDomainModel(): DisneyCharacter {
    return DisneyCharacter(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl,
        allies = this.allies,
        createdAt = this.createdAt,
        enemies = this.enemies,
        films = this.films,
        parkAttractions = this.parkAttractions,
        shortFilms = this.shortFilms,
        sourceUrl = this.sourceUrl,
        tvShows = this.tvShows,
        updatedAt = this.updatedAt,
        url = this.url,
        videoGames = this.videoGames
    )
}

// Function to map DisneyCharacter to DisneyCharacterEntity
fun DisneyCharacter.toEntityModel(): DisneyCharacterEntity {
    return DisneyCharacterEntity(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl,
        allies = this.allies,
        createdAt = this.createdAt,
        enemies = this.enemies,
        films = this.films,
        parkAttractions = this.parkAttractions,
        shortFilms = this.shortFilms,
        sourceUrl = this.sourceUrl,
        tvShows = this.tvShows,
        updatedAt = this.updatedAt,
        url = this.url,
        videoGames = this.videoGames
    )
}

fun DisneyCharacterModel.toDomainModel(): DisneyCharacter {
    return DisneyCharacter(
        allies = this.allies,
        createdAt = this.createdAt,
        enemies = this.enemies,
        films = this.films,
        imageUrl = this.imageUrl ?: "",
        name = this.name,
        parkAttractions = this.parkAttractions,
        shortFilms = this.shortFilms,
        sourceUrl = this.sourceUrl,
        tvShows = this.tvShows,
        updatedAt = this.updatedAt,
        url = this.url,
        videoGames = this.videoGames,
        id = this.id
    )
}

fun DisneyCharacter.toModel(): DisneyCharacterModel {
    return DisneyCharacterModel(
        allies = this.allies,
        createdAt = this.createdAt,
        enemies = this.enemies,
        films = this.films,
        imageUrl = this.imageUrl,
        name = this.name,
        parkAttractions = this.parkAttractions,
        shortFilms = this.shortFilms,
        sourceUrl = this.sourceUrl,
        tvShows = this.tvShows,
        updatedAt = this.updatedAt,
        url = this.url,
        videoGames = this.videoGames,
        id = this.id
    )
}


