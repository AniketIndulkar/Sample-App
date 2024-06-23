package com.novanest.sample_app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface DisneyCharacterApi {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page : Int = 1,
        @Query("pageSize") pageSize :Int = 20
    ): DisneyCharacterDto

    companion object{
        const val BASE_URL="https://api.disneyapi.dev/"
    }
}