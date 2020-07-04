package com.example.data.repositoryImp

import android.content.Context
import android.provider.MediaStore
import com.example.domain.entity.Album
import com.example.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImp @Inject constructor(val album: Album, val context: Context) :
    AlbumRepository {

    override fun getAlbumList(): List<Album> {
        TODO()
    }
}