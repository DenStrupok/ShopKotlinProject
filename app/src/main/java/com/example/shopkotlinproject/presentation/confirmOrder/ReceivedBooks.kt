package com.example.shopkotlinproject.presentation.confirmOrder

import com.example.shopkotlinproject.pojo.Book

interface ReceivedBooks {
    fun receivedListBooks(listBooks: MutableList<Book>?)
}