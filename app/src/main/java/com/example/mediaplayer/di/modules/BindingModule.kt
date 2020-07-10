package com.example.mediaplayer.di.modules

import androidx.lifecycle.ViewModel
import com.example.mediaplayer.ui.fragment.TrackFragment
import com.example.mediaplayer.ui.viewModel.TracksViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BindingModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun tracksFragment(): TrackFragment

    @Binds
    @IntoMap
    @ViewModelKey(TracksViewModel::class)
    abstract fun bindTracksViewModel(tracksViewModel: TracksViewModel): ViewModel

}