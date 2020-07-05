package com.example.mediaplayer.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(context: Context) = context

}