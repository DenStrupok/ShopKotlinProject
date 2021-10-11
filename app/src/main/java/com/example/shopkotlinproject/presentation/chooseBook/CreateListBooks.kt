package com.example.shopkotlinproject.presentation.chooseBook

import com.example.shopkotlinproject.pojo.BookUI

interface CreateListBooks {
    fun createdListBooks(listBooks: MutableList<BookUI>)
}