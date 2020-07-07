package com.example.data.repositoryImp

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.example.domain.entity.Artist
import com.example.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImp @Inject constructor(private val context: Context) :
    ArtistRepository {
    override suspend fun getArtistList(): List<Artist> {
        val artistList: ArrayList<Artist> = ArrayList()
        val cursor: Cursor? = context.contentResolver.query(
            MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
            arrayOf(
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST
            )
            ,
            null,
            null,
            null
        )
        try {
            cursor?.let {
                while (cursor!!.isAfterLast) {
                    val artistId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Artists._ID))
                    val artistName =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Artists.ARTIST))
                    artistList.add(Artist(artistId, artistName))
                    it.moveToNext()
                }
            }
        } finally {
            cursor?.close()
        }
        return artistList
    }
}