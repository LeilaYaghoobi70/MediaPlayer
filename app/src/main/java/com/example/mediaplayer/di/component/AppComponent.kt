package com.example.mediaplayer.di.component

import android.app.Application
import com.example.mediaplayer.App
import com.example.mediaplayer.di.modules.AppModule
import com.example.mediaplayer.di.modules.BindingModule
import com.example.mediaplayer.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class, BindingModule::class, AppModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Create {
        fun create(@BindsInstance application: Application): AppComponent
    }
}