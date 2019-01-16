package com.example.app.myapplication

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.app.myapplication.model.Player
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recyclerview_player_one.view.*

class PlayerAdapter(val player: List<Player>) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_player_one, parent, false))
    }

    override fun getItemCount(): Int {
       return player.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPlayer(player[position])
    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
        fun bindPlayer(player: Player){
            view.tvPlayerName.text = "Nama : ${player.strPlayer}"
            view.tvPlayerNationality.text = "Kebangsaan : ${player.strNationality}"
            view.playerPosition.text = "Posisi : ${player.strPosition}"
            Picasso.with(view.context).load(player.strThumb).resize(300, 300).centerCrop().into(view.ivPhoto)
            view.setOnClickListener() {
                Toast.makeText(view.context, view.tvPlayerName.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
