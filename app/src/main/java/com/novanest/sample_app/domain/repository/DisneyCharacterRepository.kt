package com.novanest.sample_app.domain.repository

import com.novanest.sample_app.domain.model.DisneyCharacter

interface DisneyCharacterRepository {

    suspend fun getCharacters(): Result<List<DisneyCharacter>>

    suspend fun getCharacterByName(query : String) : Result<DisneyCharacter>

    suspend fun getCharacterById(query : String) : Result<DisneyCharacter>

    suspend fun insertCharacters(disneyCharacters : List<DisneyCharacter>)
}