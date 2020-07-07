package com.example.data.repositoryImp

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.example.domain.entity.Album
import com.example.domain.repository.AlbumRepository
import javax.inject.Inject


class AlbumRepositoryImp @Inject constructor(private val context: Context) :
    AlbumRepository {
    
    override suspend fun getAlbumList(): List<Album> {
        val albumList: ArrayList<Album> = ArrayList()

         val cursor = context.contentResolver.query(
            MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
            arrayOf(
                MediaStore.Audio.Albums.ALBUM_ID,
                MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.Albums.ARTIST_ID,
                MediaStore.Audio.Albums.ALBUM_ART,
                MediaStore.Audio.Albums.ALBUM
            )
            ,
            null,
            null,
            null
        )
        
        try {
            cursor?.let {
                it.moveToFirst()
                while (!it.isAfterLast) {
                    val albumArt =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART))
                    val name =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ALBUM))
                    val albumId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ID))
                    val artistId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ARTIST_ID))
                    val artistName =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ARTIST))
                    albumList.add(Album(albumId, name, artistName, artistId, albumArt))
                    it.moveToNext()
                }
            }
        } finally {
            cursor?.close()
        }
        return albumList
    }
}




