package com.monsieur.cloy.roomexample.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class Product {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String? = null
    var quantity: Int = 0

    @Ignore
    constructor(){}

    constructor(id: Int, productName: String, quantity: Int){
        this.id = id
        this.productName = productName
        this.quantity = quantity
    }

    @Ignore
    constructor(productName: String, quantity: Int){
        this.productName = productName
        this.quantity = quantity
    }
}