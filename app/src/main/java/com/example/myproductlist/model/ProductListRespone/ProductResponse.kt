package com.example.myproductlist.model.ProductListRespone

data class ProductResponse(
    val PageInfo: PageInfo,
    val ProductList: List<Product>,
    val Success: Int,
    val error: Boolean
)