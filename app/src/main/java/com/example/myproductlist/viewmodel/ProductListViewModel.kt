package com.example.myproductlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproductlist.model.ProductListRespone.Product
import com.example.myproductlist.repository.ProductListRepository
import com.example.mytmv.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productListRepository: ProductListRepository): ViewModel(){

    val _productListResponseLiveData : LiveData<NetworkResult<List<Product>>>
        get() = productListRepository.productListResponseLiveData

    init {
        viewModelScope.launch(Dispatchers.Main){

            productListRepository.ProductList()
        }
    }
}