package com.example.domain.repository

import com.example.domain.entity.Album

interface AlbumRepository {

    suspend fun getAlbumList(): List<Album>

}