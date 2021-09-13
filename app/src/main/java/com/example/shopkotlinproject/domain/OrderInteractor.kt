package com.example.shopkotlinproject.domain

import android.util.Log
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import kotlin.random.Random

class OrderInteractor {
    private var bookName: String? = null
    private var summary = 0
    private var index = 0
    private val min = 1
    private val max = 100
    private val random = Random
    fun totalSummaryOrder(list: MutableList<Book>): Int  {
        index = 0
        summary = 0
        while (index < list.size) {
            summary += list[index].number * list[index].price
            index++
        }
        return summary
    }
    fun orderID(order: Order): Int{
        val size = order.familyClient.length + order.phoneNumber.length
        return size * 100/order.familyClient.length
    }
}