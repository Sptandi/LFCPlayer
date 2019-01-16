package com.example.app.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.app.myapplication.api.ClientInstance
import com.example.app.myapplication.api.PlayerService
import com.example.app.myapplication.model.Player
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun playerAPI(){
       val player = ClientInstance.retrofit.create(PlayerService::class.java)
        player.getAllPlayer().enqueue(object : Callback<List<Player>> {
            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                Log.e("Player", "Tidak memunculkan pemain")
            }

            override fun onResponse(call: Call<List<Player>>, response: Response<List<Player>>) {
                val player = response.body()
                if (player != null) {
                    displayPlayer(player)
                }
            }
        })
    }

    private fun displayPlayer(player: List<Player>) {
        val adapter = PlayerAdapter(player)
        val recyclerPlayer = rcPlayer
        val layoutManager = GridLayoutManager(this@MainActivity, 2)
        recyclerPlayer.layoutManager = layoutManager
        recyclerPlayer.adapter = adapter
    }
}
