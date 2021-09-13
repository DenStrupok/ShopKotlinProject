package com.example.shopkotlinproject.data

import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import java.util.ArrayList

class ResultOrderModel(private val listener: ResultOrder ) {

    fun sendOrder(order: Order?, list: ArrayList<Book>?) {
        if (order!=null && list!=null){
            listener.getResultOrder(order, list)
        }
    }
}