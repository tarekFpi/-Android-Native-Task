package com.example.myproductlist.model.ProductListRespone

data class PageInfo(
    val PageCount: Int,
    val PageNo: Int,
    val PageSize: Int,
    val TotalRecordCount: Int
)