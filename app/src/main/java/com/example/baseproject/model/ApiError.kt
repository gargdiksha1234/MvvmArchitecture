package com.example.baseproject.model

data class ApiError (
    var status: Boolean = false,
    var message: String? = null,
    var result: Any? = null,
    var statusCode:Int?=null,
)