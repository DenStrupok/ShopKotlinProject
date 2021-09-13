package com.example.shopkotlinproject.presentation.validation

class UserValidation {
    var isValidate = false
    fun validationClientData(nameClient: String, familyClient: String, phoneClient: String): Boolean {
        if (nameClient.isNotEmpty() && familyClient.isNotEmpty() && phoneClient.isNotEmpty()){
            isValidate = true
        }
            return isValidate
    }
}