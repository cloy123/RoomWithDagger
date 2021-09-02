package com.monsieur.cloy.roomexample.di

import android.app.Application
import com.monsieur.cloy.roomexample.MainActivity
import com.monsieur.cloy.roomexample.base.ProductRoomDatabase
import com.monsieur.cloy.roomexample.model.room.ProductRepository
import com.monsieur.cloy.roomexample.model.room.dao.ProductDao
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [AppModule::class, RoomModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    val productDao: ProductDao

    val productRoomDatabase: ProductRoomDatabase

    val productRepository: ProductRepository

    val application: Application

}