package com.example.data.repositoryImp

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.example.domain.entity.Album
import com.example.domain.entity.Track
import com.example.domain.trackListSort.TracksSort
import com.example.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImp @Inject constructor(val context: Context) : TrackRepository {

    override suspend fun getTrackList(tracksSort: TracksSort): List<Track> {
        val trackList = ArrayList<Track>()
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        try {
            cursor?.let {
                cursor.moveToFirst()
                while (!cursor!!.isAfterLast) {
                    val trackId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Media._ID))
                    val trackName =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
                    val artistId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID))
                    val albumId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))
                    val trackLength =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    trackList.add(
                        Track(
                            trackId,
                            trackName,
                            artistId,
                            albumId,
                            trackLength.toLong()
                        )
                    )
                    it.moveToNext()
                }
            }
        } finally {
            cursor?.close()
        }
        return trackList
    }
}