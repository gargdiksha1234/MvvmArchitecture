package com.example.baseproject.model.response

import com.example.baseproject.model.ApiError
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {

    @SerializedName("statusCode")
    @Expose
    var statusCode: Int = 0

    @SerializedName("type")
    @Expose
    var type: String = ""

    @SerializedName("message")
    @Expose
    var message: String = ""

    @SerializedName("data")
    @Expose
    var data: T? = null
}