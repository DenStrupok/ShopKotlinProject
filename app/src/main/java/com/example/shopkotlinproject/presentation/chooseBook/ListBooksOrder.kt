package com.example.shopkotlinproject.presentation.chooseBook

import com.example.shopkotlinproject.pojo.Book

interface ListBooksOrder {
    fun listBooksOrder(listBooksOrder: MutableList<Book>)
}