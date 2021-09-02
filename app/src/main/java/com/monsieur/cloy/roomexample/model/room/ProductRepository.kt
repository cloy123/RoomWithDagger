package com.monsieur.cloy.roomexample.model.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.monsieur.cloy.roomexample.base.ProductRoomDatabase
import com.monsieur.cloy.roomexample.model.Product
import com.monsieur.cloy.roomexample.model.room.dao.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductRepository @Inject constructor(val productDao : ProductDao) {

    val searchResult = MutableLiveData<List<Product>>()
    val allProducts : LiveData<List<Product>>?

    init {
        allProducts = productDao.getAllProducts()
    }

    private fun asyncFinished(result: List<Product>){
        GlobalScope.launch(Dispatchers.Main) {
            searchResult.value = result
        }
    }

    fun findProduct(name: String){
        GlobalScope.launch {
            productDao?.findProduct(name)?.let { asyncFinished(it) }
        }
    }

    fun insertProduct(newProduct: Product){
        GlobalScope.launch {
            productDao?.insertProduct(newProduct)
        }
    }

    fun deleteProduct(name: String){
        GlobalScope.launch {
            productDao?.deleteProduct(name)
        }
    }

    fun update(){
        GlobalScope.launch {
            if (allProducts != null) {
                allProducts.value?.let { productDao?.update(it) }
            }
        }
    }
}