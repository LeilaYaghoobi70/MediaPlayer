package com.example.mediaplayer.repositoryImp

import android.content.Context
import android.provider.MediaStore
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import com.example.domain.entity.Album
import com.example.domain.entity.Artist
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ArtistRepositoryImpTest {
    @Rule
    @JvmField
    var mGrantPermissionRule = GrantPermissionRule.grant(
        "android.permission.READ_EXTERNAL_STORAGE"
    )

    @Test
    fun getArtist() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val albumList = ArrayList<Artist>()
        val contentResolver = context.contentResolver
        val uri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
        val cursor = contentResolver.query(uri, null, null, null, null)
        val artistList = ArrayList<Artist>()

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
    }
}