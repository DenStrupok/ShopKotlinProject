package com.example.shopkotlinproject.presentation.chooseBook

import com.example.shopkotlinproject.pojo.Book

interface ItemClickRecyclerView {
    fun itemRecyclerClicked(selectedBook: Book)
}