package com.example.domain.repository

import com.example.domain.entity.Artist

interface ArtistRepository {

    fun getArtistList(): List<Artist>

}