package com.example.app.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientInstance {
    companion object {
<<<<<<< HEAD
          private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
=======
        private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=Liverpool"
>>>>>>> 27c436d74cf5ff6e5774cf458ce7ab94dd336433

        val retrofit: Retrofit by lazy {
            return@lazy Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
