package com.example.baseproject.api

import com.example.baseproject.model.request.UserSignUpRequest
import com.example.baseproject.model.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface Api {
    @PUT("users/forgot-password")
    suspend fun hitForgotPassword(
        @Body userSignUpRequest: UserSignUpRequest
    ): Response<BaseResponse<Any?>>
}