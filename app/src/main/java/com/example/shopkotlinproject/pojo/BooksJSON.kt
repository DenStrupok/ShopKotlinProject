package com.example.shopkotlinproject.pojo

data class BooksJSON(
    val title: String? = null,
    val author: String? = null,
    val publisher: String? = null,
    val description: String? = null,
    val buy_links: List<LinkBooks>? = null,
    val book_image: String? = null,
    val amazon_product_url: String? = null,
    val price: Int = 0,
    val list: ResultBooks? = null
)
