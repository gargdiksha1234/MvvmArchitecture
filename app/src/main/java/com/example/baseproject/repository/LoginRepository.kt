package com.example.baseproject.repository

import com.example.baseproject.api.Api
import com.example.baseproject.model.request.NetworkResult
import com.example.baseproject.model.request.UserSignUpRequest
import com.example.baseproject.model.response.BaseResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository@Inject constructor(private val apiInterface: Api) {

    suspend fun forgotPasswordUsingFlow(signUpRequest: UserSignUpRequest): Flow<NetworkResult<BaseResponse<Any?>>> {
        return flow {
            emit(NetworkResult.Loading())
            val response = apiInterface.hitForgotPassword(signUpRequest)
            try {
                if (response.isSuccessful) {
                    emit(NetworkResult.Success(response.body()))

                } else {
                    val message = Gson().fromJson(
                        response.errorBody()?.charStream(),
                        BaseResponse::class.java

                    )
                    emit(NetworkResult.Error(message.message))
                }
            } catch (e: Exception) {
                emit(NetworkResult.Error(e.message.toString()))
            }

        }
    }
}