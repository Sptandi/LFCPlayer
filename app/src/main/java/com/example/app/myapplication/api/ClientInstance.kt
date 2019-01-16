package com.example.app.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientInstance {
    companion object {
        private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=Liverpool"

        val retrofit: Retrofit by lazy {
            return@lazy Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
