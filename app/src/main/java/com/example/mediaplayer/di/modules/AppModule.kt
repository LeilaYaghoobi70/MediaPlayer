package com.example.mediaplayer.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

   @Provides
    fun provideContext(application: Application) =application.applicationContext

}