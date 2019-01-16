package com.example.app.myapplication.api

import com.example.app.myapplication.model.Player
import retrofit2.Call
import retrofit2.http.GET

interface PlayerService {
    @GET("/player")
    fun getAllPlayer() : Call<List<Player>>
}