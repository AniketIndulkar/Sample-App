package com.novanest.sample_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.novanest.sample_app.data.local.entity.DisneyCharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DisneyCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(disneyCharacterEntity: DisneyCharacterEntity)

    @Delete
    suspend fun deleteCharacter(disneyCharacterEntity: DisneyCharacterEntity)

    @Query(
        """
        SELECT *
        FROM DisneyCharacterEntity
    """
    )
    fun getCharacters(): Flow<List<DisneyCharacterEntity>>

    @Query(
        """
        SELECT *
        FROM DisneyCharacterEntity
        WHERE id =:id
    """
    )
    fun getCharacterById(id : String): Flow<List<DisneyCharacterEntity>>
}