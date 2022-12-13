package com.example.mangrove.Model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ViewModelProduct: ViewModel() {
    var productList = mutableStateListOf<product>()

    fun add(newProduct: product){
        productList.add(newProduct)
    }
    fun delete(newProduct: product){
        productList.remove(newProduct)
    }
}
