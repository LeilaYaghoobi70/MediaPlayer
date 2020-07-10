package com.example.mediaplayer.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Track
import com.example.mediaplayer.R

class TrackAdapter(context: Context, list: ArrayList<Track>) :
    RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    lateinit var context: Context
    lateinit var trackList: ArrayList<Track>

    init {
        this.context = context
        this.trackList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.track_layout_item, parent,false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.textViewNameArtist.text = trackList.get(position).let { it.displayName }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textViewNameArtist: TextView

        init {
            textViewNameArtist = itemView.findViewById(R.id.txt_track)
        }

    }

}