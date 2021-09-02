package com.monsieur.cloy.roomexample.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.monsieur.cloy.roomexample.model.Product
import com.monsieur.cloy.roomexample.model.room.dao.ProductDao

@Database(entities =  [(Product::class)], version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao


//    companion object{
//        private var instance: ProductRoomDatabase? = null
//
//        fun getInstance(context: Context): ProductRoomDatabase{
//            if(instance == null){
//                synchronized(ProductRoomDatabase::class.java){
//                    if(instance == null){
//                        instance = Room.databaseBuilder(context, ProductRoomDatabase::class.java, "myDatabase").build()
//                    }
//                }
//            }
//            return instance!!
//        }
//    }
}