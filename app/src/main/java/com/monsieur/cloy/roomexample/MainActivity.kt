package com.monsieur.cloy.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monsieur.cloy.roomexample.di.AppModule
import com.monsieur.cloy.roomexample.di.DaggerAppComponent
import com.monsieur.cloy.roomexample.di.RoomModule
import com.monsieur.cloy.roomexample.utils.APP_ACTIVITY
import com.monsieur.cloy.roomexample.utils.replaceFragment
import dagger.internal.DaggerCollections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this
        replaceFragment(MainFragment())
    }
}