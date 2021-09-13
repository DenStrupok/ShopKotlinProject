package com.example.shopkotlinproject.presentation.confirmOrder

interface ValidationClient {
    fun validateClientData(nameClient: String, familyClient: String, phoneNumber: String)
}