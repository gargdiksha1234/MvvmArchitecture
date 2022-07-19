package com.example.baseproject.ui.onBoarding.forgotPassword

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseproject.base.BaseViewModel
import com.example.baseproject.model.request.NetworkResult
import com.example.baseproject.model.request.UserSignUpRequest
import com.example.baseproject.model.response.BaseResponse
import com.example.baseproject.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel@Inject constructor(private val loginRepository: LoginRepository): BaseViewModel() {

    var email=MutableLiveData<String>()


    private val _userResponseForgotPassword = MutableLiveData<NetworkResult<BaseResponse<Any?>>>()
    val userResponseForgotPassword = _userResponseForgotPassword
    fun forgotPassword() {
        Log.d("tag","function")
        val request = email.value?.let { UserSignUpRequest(it) }
        viewModelScope.launch {
            loginRepository.forgotPasswordUsingFlow(request!!).collect {
                userResponseForgotPassword.postValue(it)
            }
        }
    }

}