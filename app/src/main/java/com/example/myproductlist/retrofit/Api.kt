package com.example.myproductlist.retrofit
import com.example.myproductlist.model.ProductListRespone.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
interface Api {

    @GET("Values/GetProductList")
    suspend fun getProduct():Response<ProductResponse>

}