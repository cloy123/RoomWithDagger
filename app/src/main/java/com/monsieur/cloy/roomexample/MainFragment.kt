package com.monsieur.cloy.roomexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monsieur.cloy.roomexample.databinding.FragmentMainBinding
import com.monsieur.cloy.roomexample.model.Product
import java.util.*

class MainFragment : Fragment() {

    private var adapter: ProductRecyclerAdapter? = null
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun recyclerSetup() {
        adapter = ProductRecyclerAdapter()
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(this, Observer { products ->
            products?.let{
                adapter?.setProductList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { products ->
            products?.let{
                if(it.isNotEmpty()){
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(String.format(Locale.US, "%d", it[0].quantity))
                }else{
                    binding.productID.text = "No Match"
                }
            }
        })
    }

    private fun listenerSetup(){
        binding.addButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()

            if(name != "" && quantity != ""){
                val product = Product(name, Integer.parseInt(quantity))
                viewModel.insertProduct(product)
                clearFields()
            }else{
                binding.productID.text = "Incomplete information"
            }
        }

        binding.findButton.setOnClickListener {
            viewModel.findProduct(binding.productName.text.toString())
        }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteProduct(binding.productName.text.toString())
            clearFields()
        }

        binding.updateButton.setOnClickListener {
            viewModel.update()
        }
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }

}