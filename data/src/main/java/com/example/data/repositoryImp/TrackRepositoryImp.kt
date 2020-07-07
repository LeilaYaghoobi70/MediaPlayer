package com.example.data.repositoryImp

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.example.domain.entity.Album
import com.example.domain.entity.Track
import com.example.domain.trackListSort.TracksSort
import com.example.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImp @Inject constructor(val context: Context) : TrackRepository {
    private lateinit var albumList: ArrayList<Track>

    override suspend fun getTrackList(tracksSort: TracksSort): List<Track> {
        TODO("Not yet implemented")
    }
}