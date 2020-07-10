package com.example.mediaplayer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Track
import com.example.mediaplayer.R

class TrackAdapter(
    private val context: Context,
    private val trackList: ArrayList<Track>
) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.track_layout_item, parent,false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.textViewNameArtist.text = trackList[position].displayName
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNameArtist: TextView = itemView.findViewById(R.id.txt_track)
    }

}