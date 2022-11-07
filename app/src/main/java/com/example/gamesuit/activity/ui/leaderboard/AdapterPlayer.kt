package com.example.gamesuit.activity.ui.leaderboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesuit.activity.ui.leaderboard.AdapterPlayer.DataLeaderboardViewHolder
import com.example.gamesuit.activity.data.db.user.User
import com.example.gamesuit.databinding.ActivityItemTopscoreBinding

class AdapterPlayer(
    private val dataPlayer: List<User>
) : RecyclerView.Adapter<DataLeaderboardViewHolder>() {
    var rangking: Int = 0


    inner class DataLeaderboardViewHolder(private val itemBinding: ActivityItemTopscoreBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(dataPlayer: User) {
            itemBinding.tvRank.text = rangking.toString()
            itemBinding.namaPlayer.text = dataPlayer.username
            itemBinding.AvatarPlayer.setImageResource(dataPlayer.avatarId)
            itemBinding.angkamenang.text = dataPlayer.wins.toString()
            itemBinding.angkakalah.text = dataPlayer.loses.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataLeaderboardViewHolder {
        val itemBinding =
            ActivityItemTopscoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false  )
        return DataLeaderboardViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DataLeaderboardViewHolder, position: Int) {
        val user: User = dataPlayer[position]
        rangking = position + 1
        holder.bindView(user)
    }

    override fun getItemCount(): Int = dataPlayer.size

}






