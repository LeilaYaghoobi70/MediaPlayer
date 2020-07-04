package com.example.domain.interactor

import com.example.domain.repository.TrackRepository
import com.example.domain.enumOder.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReturnTrackList @Inject constructor(private val trackRepository: TrackRepository) {

    suspend fun getTrackList(order: Order) = withContext(Dispatchers.IO) {
        return@withContext trackRepository.getTrackList(order)
    }
}