package com.example.mediaplayer.repositoryImp

import android.content.Context
import android.provider.MediaStore
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import com.example.domain.entity.Artist
import com.example.domain.entity.Track
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TrackRepositoryImpTest {

    @get:Rule
    val mGrantPermissionRule = GrantPermissionRule.grant("android.permission.READ_EXTERNAL_STORAGE")

    @Test
    fun getTrack() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val trackList = ArrayList<Track>()
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        val cursor = context.contentResolver.query(uri, null, null, null, null)

        try {
            cursor?.let {
                while (cursor!!.isAfterLast) {
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
    }
}


