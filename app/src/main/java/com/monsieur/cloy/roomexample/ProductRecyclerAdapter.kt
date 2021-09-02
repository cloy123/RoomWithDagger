package com.monsieur.cloy.roomexample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.monsieur.cloy.roomexample.model.Product

class ProductRecyclerAdapter():RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    private var productList: List<Product>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setProductList(products: List<Product>){
        productList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card_view, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.item
        productList.let{
            item.text = it!![position].productName
        }
    }

    override fun getItemCount(): Int {
        return if(productList == null) 0 else productList!!.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var item: TextView = itemView.findViewById(R.id.product_row)
    }
}