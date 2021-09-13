package com.example.shopkotlinproject.presentation.chooseBook

import com.example.shopkotlinproject.pojo.Book

interface CreateListBooks {
    fun createdListBooks(listBooks: MutableList<Book>)
}