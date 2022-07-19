package com.example.baseproject.ui.onBoarding.login

import com.example.baseproject.base.BaseViewModel
import com.example.baseproject.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoginViewModel@Inject constructor(private val loginRepository: LoginRepository):
    BaseViewModel() {

}