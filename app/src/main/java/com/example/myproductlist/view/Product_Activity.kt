package com.example.myproductlist.view

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproductlist.R
import com.example.myproductlist.adapter.ProductListAdapter
import com.example.myproductlist.model.ProductListRespone.Product
import com.example.myproductlist.viewmodel.ProductListViewModel
import com.example.mytmv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Product_Activity : AppCompatActivity() {

    lateinit var productListViewModel: ProductListViewModel

    private lateinit var productListAdapter: ProductListAdapter

    private lateinit var recyclerView_product: RecyclerView

    private var productList:  MutableList<Product> = mutableListOf()

    private lateinit var  progressBar: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        progressBar = ProgressDialog(this)
        progressBar.setMessage("please wait...")


        recyclerView_product =findViewById<RecyclerView>(R.id.recyclerview_productList)

        productListAdapter = ProductListAdapter(this,productList)

        recyclerView_product.apply {

            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = productListAdapter

        }

        productListViewModel = ViewModelProvider(this)[ProductListViewModel::class.java];

        productListViewModel._productListResponseLiveData.observe(this, Observer { it->

            when (it) {
                is NetworkResult.Success -> {

                    it.data?.let { it1 ->

                        productList.addAll(it1)

                        productListAdapter.setTerminalList(productList)

                        progressBar.dismiss()

                    }
                    progressBar.dismiss()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(applicationContext,"Error ${it.message}", Toast.LENGTH_SHORT).show()
                    progressBar.dismiss()
                }
                is NetworkResult.Loading ->{
                    progressBar.show()
                }
            }

        })

    }
}