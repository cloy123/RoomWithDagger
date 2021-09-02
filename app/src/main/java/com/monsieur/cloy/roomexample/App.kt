package com.monsieur.cloy.roomexample

import android.app.Application
import android.content.Context
import com.monsieur.cloy.roomexample.di.AppComponent
import com.monsieur.cloy.roomexample.di.AppModule
import com.monsieur.cloy.roomexample.di.DaggerAppComponent
import com.monsieur.cloy.roomexample.di.RoomModule

class App: Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(this))
            .build()
//            DaggerAppComponent.builder()
//            .appModule(AppModule(application))
//            .roomModule(RoomModule(application))
//            .build()
//            .inject(this)
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }