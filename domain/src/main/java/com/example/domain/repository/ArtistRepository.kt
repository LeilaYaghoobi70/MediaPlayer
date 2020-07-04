package com.example.domain.repository

import com.example.domain.entity.Artist

interface ArtistRepository {

    suspend fun getArtistList(): List<Artist>

}