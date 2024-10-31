package com.example.mascotas

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InstagramApiService {
    @GET("users/self/media/recent")
    fun getRecentMedia(
        @Query("access_token") accessToken: String
    ): Call<InstagramResponse>
}

