package com.example.data.repositoryImp

import android.content.Context
import com.example.domain.entity.Track
import com.example.domain.trackListSort.TracksSort
import com.example.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImp @Inject constructor(val track: Track,val context: Context) : TrackRepository {

    override suspend fun getTrackList(tracksSort: TracksSort): List<Track> {
        TODO("Not yet implemented")
    }
}