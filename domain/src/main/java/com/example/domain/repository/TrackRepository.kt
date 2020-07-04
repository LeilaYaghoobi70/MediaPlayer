package com.example.domain.repository

import com.example.domain.trackListSort.TracksSort
import com.example.domain.entity.Track

interface TrackRepository {

    suspend fun getTrackList(tracksSort: TracksSort): List<Track>

}