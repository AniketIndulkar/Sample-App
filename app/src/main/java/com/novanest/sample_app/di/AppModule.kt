package com.novanest.sample_app.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.novanest.sample_app.data.local.DisneyCharacterDatabase
import com.novanest.sample_app.data.remote.DisneyCharacterApi
import com.novanest.sample_app.data.repository.DisneyCharacterRepositoryImpl
import com.novanest.sample_app.domain.repository.DisneyCharacterRepository
import com.novanest.sample_app.domain.use_case.GetDisneyCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }).build()
    }


    @Provides
    @Singleton
    fun provideDisneyCharacterApi(client : OkHttpClient) : DisneyCharacterApi{
        return Retrofit.Builder()
            .baseUrl(DisneyCharacterApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(DisneyCharacterApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCharacterDatabase(app : Application) : DisneyCharacterDatabase{
        return Room.databaseBuilder(
            app,
            DisneyCharacterDatabase::class.java,
            "disney_characters_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(
        api: DisneyCharacterApi,
        db : DisneyCharacterDatabase
    ) : DisneyCharacterRepository{
        return  DisneyCharacterRepositoryImpl(api,db.dao)
    }


    @Provides
    @Singleton
    fun provideGetDisneyCharactersUseCase(repository: DisneyCharacterRepository) : GetDisneyCharacters{
        return GetDisneyCharacters(repository)
    }
}