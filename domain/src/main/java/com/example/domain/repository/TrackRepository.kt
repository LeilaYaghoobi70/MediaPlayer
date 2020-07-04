package com.example.domain.repository

import com.example.domain.enumOder.Order
import com.example.domain.entity.Track

interface TrackRepository {

    fun getTrackList(order: Order): List<Track>

}