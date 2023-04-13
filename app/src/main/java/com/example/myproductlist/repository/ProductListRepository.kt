package com.example.myproductlist.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproductlist.model.ProductListRespone.Product
import com.example.myproductlist.retrofit.Api
import com.example.mytmv.di.TokenManager
import com.example.mytmv.utils.NetworkResult
import javax.inject.Inject

class ProductListRepository @Inject constructor(private val api: Api){

    private var _productListResponseMutableData = MutableLiveData<NetworkResult<List<Product>>>()
    val  productListResponseLiveData : LiveData<NetworkResult<List<Product>>>
        get() =_productListResponseMutableData

    suspend  fun ProductList(){
        _productListResponseMutableData.postValue(NetworkResult.Loading())

        val  response =  api.getProduct()

        try {

            if(response.isSuccessful && response.body() != null){

          _productListResponseMutableData.postValue(NetworkResult.Success(response.body()!!.ProductList))

                }else{

         _productListResponseMutableData.postValue(NetworkResult.Error(response.body()?.toString()))

            }

        } catch(e: Exception) {

            _productListResponseMutableData.postValue(NetworkResult.Error(e.message!!))

        }

    }
}