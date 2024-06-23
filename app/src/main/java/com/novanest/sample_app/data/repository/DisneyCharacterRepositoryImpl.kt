package com.novanest.sample_app.data.repository

import com.novanest.sample_app.data.local.DisneyCharacterDao
import com.novanest.sample_app.data.mapper.toDomainModel
import com.novanest.sample_app.data.mapper.toEntityModel
import com.novanest.sample_app.data.remote.DisneyCharacterApi
import com.novanest.sample_app.domain.model.DisneyCharacter
import com.novanest.sample_app.domain.repository.DisneyCharacterRepository

class DisneyCharacterRepositoryImpl(
    private val api : DisneyCharacterApi,
    private val dao: DisneyCharacterDao
) : DisneyCharacterRepository{

    override suspend fun getCharacters(): Result<List<DisneyCharacter>> {
        return try {
            val characterDto = api.getCharacters()
            Result.success(
                characterDto.data.mapNotNull {
                    it.toDomainModel()
                }
            )
        } catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getCharacterByName(query: String): Result<DisneyCharacter> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterById(query: String): Result<DisneyCharacter> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCharacters(disneyCharacters: List<DisneyCharacter>) {
        disneyCharacters.forEach { dao.insertCharacter(it.toEntityModel()) }
    }
}