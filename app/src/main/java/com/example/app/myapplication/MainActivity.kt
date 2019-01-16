package com.example.app.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.app.myapplication.api.ClientInstance
import com.example.app.myapplication.api.PlayerService
import com.example.app.myapplication.model.ListPlayer
import com.example.app.myapplication.model.Player
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val player = listOf<Player>()
        displayPlayer(player)
        playerAPI()
    }

    private fun playerAPI(){
        val playerService = ClientInstance.retrofit.create(PlayerService::class.java)
        playerService.getAllPlayer("Liverpool").enqueue(object : Callback<ListPlayer> {
            override fun onFailure(call: Call<ListPlayer>, t: Throwable) {
                Log.e("Player", t.message)
            }

            override fun onResponse(call: Call<ListPlayer>, response: Response<ListPlayer>?) {
                val player = response?.body()?.player
                Log.d("player", player?.get(0)?.strPosition)
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
