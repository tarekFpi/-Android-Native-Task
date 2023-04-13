package com.example.myproductlist.model.ProductListRespone

data class Warehouse(
    val AverageCosting: Double,
    val CostCalculatedId: Int,
    val CostingValue: Double,
    val CurrentStock: Double,
    val SalesValue: Double,
    val WhShortName: String
)