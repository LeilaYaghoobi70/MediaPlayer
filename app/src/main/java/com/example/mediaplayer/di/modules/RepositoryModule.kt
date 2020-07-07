package com.example.mediaplayer.di.modules

import com.example.data.repositoryImp.AlbumRepositoryImp
import com.example.data.repositoryImp.ArtistRepositoryImp
import com.example.data.repositoryImp.TrackRepositoryImp
import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.ArtistRepository
import com.example.domain.repository.TrackRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepositoryAlbum(albumRepositoryImp: AlbumRepositoryImp): AlbumRepository =
        albumRepositoryImp

    @Provides
    fun provideRepositoryTrack(trackRepositoryImp: TrackRepositoryImp): TrackRepository =
        trackRepositoryImp

    @Provides
    fun provideRepositoryArtist(artistRepositoryImp: ArtistRepositoryImp): ArtistRepository =
        artistRepositoryImp

}