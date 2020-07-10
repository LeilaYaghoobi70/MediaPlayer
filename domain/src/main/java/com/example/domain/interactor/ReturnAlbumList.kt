package com.example.domain.interactor

import com.example.domain.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReturnAlbumList @Inject constructor(private val albumRepository: AlbumRepository) {

    suspend fun getAlbumList() = withContext(Dispatchers.IO) {
        return@withContext albumRepository.getAlbumList()
    }

}