package com.example.domain.interactor

import com.example.domain.repository.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReturnArtistList @Inject constructor(private val artistRepository: ArtistRepository) {
    suspend fun getArtistList() = withContext(Dispatchers.IO) {
       return@withContext artistRepository.getArtistList()
    }
}