package com.monsieur.cloy.roomexample

import android.app.Application
import androidx.lifecycle.*
import com.monsieur.cloy.roomexample.model.Product
import com.monsieur.cloy.roomexample.model.room.ProductRepository
import javax.inject.Inject

class MyViewModel(application: Application): AndroidViewModel(application) {


    private val repository: ProductRepository = application.appComponent.productRepository
    private val allProducts: LiveData<List<Product>>? = repository.allProducts
    private val searchResults: MutableLiveData<List<Product>> = repository.searchResult


    fun insertProduct(product: Product){
        repository.insertProduct(product)
    }

    fun findProduct(name: String){
        repository.findProduct(name)
    }

    fun deleteProduct(name: String){
        repository.deleteProduct(name)
    }

    fun getSearchResults(): MutableLiveData<List<Product>>{
        return searchResults
    }

    fun getAllProducts(): LiveData<List<Product>>?{
        return allProducts
    }

    fun update(){
        repository.update()
    }
}