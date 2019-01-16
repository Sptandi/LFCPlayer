package com.example.app.myapplication.api

import com.example.app.myapplication.model.ListPlayer
import com.example.app.myapplication.model.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("searchplayers.php")
    fun getAllPlayer(@Query("t") query: String) : Call<ListPlayer>
}