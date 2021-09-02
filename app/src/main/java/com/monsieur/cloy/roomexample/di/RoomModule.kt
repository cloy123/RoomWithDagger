package com.monsieur.cloy.roomexample.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.monsieur.cloy.roomexample.base.ProductRoomDatabase
import com.monsieur.cloy.roomexample.model.room.ProductRepository
import com.monsieur.cloy.roomexample.model.room.dao.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {

    val productRoomDatabase: ProductRoomDatabase = Room.databaseBuilder(application, ProductRoomDatabase::class.java, "fbgfdd").build()

    val application: Application = application


    @Singleton
    @Provides
    fun provideAppDatabase(): ProductRoomDatabase {
        return productRoomDatabase
    }

    @Singleton
    @Provides
    fun providesProductDao(productRoomDatabase: ProductRoomDatabase): ProductDao{
        return productRoomDatabase.productDao()
    }

    @Singleton
    @Provides
    fun providesProductRepository(productDao: ProductDao): ProductRepository{
        return ProductRepository(productDao)
    }

}