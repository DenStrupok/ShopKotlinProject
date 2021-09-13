package com.example.shopkotlinproject.presentation.resultOrder

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.data.ResultOrder
import com.example.shopkotlinproject.data.ResultOrderModel
import com.example.shopkotlinproject.domain.OrderInteractor
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.dialog.ResultDialogFragment
import java.util.ArrayList

class ResultOrderViewModel : ViewModel(), ResultOrder {
    private val resultOrderModel = ResultOrderModel(this)
    private val orderIntIterator = OrderInteractor()
    private val mResultOrder = MutableLiveData<Order>()
    fun sendOrder(order: Order?, list: ArrayList<Book>?) {
        resultOrderModel.sendOrder(order, list)
    }

    fun receivedResultOrder(): LiveData<Order> {
        return mResultOrder
    }

    override fun getResultOrder(order: Order, list: ArrayList<Book>) {
        mResultOrder.value = order
    }

    fun getOrderID(order: Order): Int {
        return orderIntIterator.orderID(order)
    }

}