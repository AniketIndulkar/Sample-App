package com.novanest.sample_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.novanest.sample_app.data.local.entity.DisneyCharacterEntity
import com.novanest.sample_app.data.local.utils.Converters

@Database(
    entities = [DisneyCharacterEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DisneyCharacterDatabase :RoomDatabase(){

    abstract val dao:DisneyCharacterDao
}