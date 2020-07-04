package com.example.data.repositoryImp

import android.content.Context
import com.example.domain.entity.Artist
import com.example.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImp @Inject constructor(val artist: Artist, val context: Context) :
    ArtistRepository {

    override suspend fun getArtistList(): List<Artist> {
        TODO("Not yet implemented")
    }
}