package com.example.mediaplayer.repositoryImp

import android.content.Context
import android.provider.MediaStore
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import com.example.domain.entity.Album
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumRepositoryImpTest {
    @Rule
    @JvmField
    var mGrantPermissionRule = GrantPermissionRule.grant(
        "android.permission.READ_EXTERNAL_STORAGE"
    )

    @Test
    fun getAlbum() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val albumList = ArrayList<Album>()
        val contentResolver = context.contentResolver
        val uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        val cursor = contentResolver.query(uri, null, null, null, null)

        try {
            cursor?.let {
                it.moveToFirst()
                while (!it.isAfterLast) {
                    val albumArt =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART))
                    val name =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums.ALBUM))
                    val albumId =
                        it.getString(it.getColumnIndex(MediaStore.Audio.Albums._ID))
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
    }

}