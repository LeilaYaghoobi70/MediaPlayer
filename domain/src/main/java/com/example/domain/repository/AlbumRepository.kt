package com.example.domain.repository

import com.example.domain.entity.Album

interface AlbumRepository {

    fun getAlbumList(): List<Album>

}