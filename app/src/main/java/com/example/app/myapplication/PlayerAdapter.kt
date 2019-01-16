package com.example.app.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.myapplication.model.Player
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
            view.tvPlayerName.text = player.strPlayer
            view.tvPlayerNationality.text = player.strNationality
            view.playerPosition.text = player.strPosition
        }
    }
}
