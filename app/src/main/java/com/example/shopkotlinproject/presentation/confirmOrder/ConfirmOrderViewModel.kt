package com.example.shopkotlinproject.presentation.confirmOrder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopkotlinproject.domain.OrderInteractor
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.presentation.validation.UserValidation

class ConfirmOrderViewModel : ViewModel() {
    private val orderInteractor = OrderInteractor()
    private val mSummaryOrder = MutableLiveData<Int>()
    private val userValidation = UserValidation()
    private var isValidate = false
    private val mClientValidation = MutableLiveData<Boolean>()

    fun summaryOrder(listBooks: MutableList<Book>?) {
        listBooks?.let {
            mSummaryOrder.value = orderInteractor.totalSummaryOrder(it)
        }
    }
    fun getClientValidation(): LiveData<Boolean>{
        return mClientValidation
    }

    fun validationClientData(nameClient: String, familyClient: String, phoneClient: String) {
        isValidate = userValidation.validationClientData(nameClient, familyClient, phoneClient)
        mClientValidation.value = isValidate
    }

    fun getSummaryBooksOrder(): LiveData<Int> {
        return mSummaryOrder
    }
}