package com.example.shopkotlinproject.data

import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import java.util.ArrayList

interface ResultOrder {
    fun getResultOrder(order: Order, list: ArrayList<Book>)
}