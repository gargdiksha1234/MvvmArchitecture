package com.example.baseproject.ui.onBoarding.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseproject.base.BaseViewModel
import com.example.baseproject.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val employeeRepository: EmployeeRepository): BaseViewModel() {

    var loginEmail= MutableLiveData<String>()
    var loginPassword= MutableLiveData<String>()
    var tag:String=""

    fun setEmail():String
    {
        var emails=loginEmail.value
        Log.d("Checking",emails.toString())
        Log.d("cccc",loginEmail.value.toString())
        return emails?:""
    }

   fun loginPasswordChecking(loginEmail:String)
   {
       Log.d("Checking",loginEmail.toString())
       viewModelScope.launch(Dispatchers.IO) {
           tag=employeeRepository.loginPasswordChecking(loginEmail).toString().trim()
           Log.d("pass",tag)
           Log.d("ddd",loginPassword.value.toString())
       }
       CoroutineScope(Dispatchers.Main).launch {
           delay(5000)
           if (loginPassword.value.toString() == tag) {
               Log.d("Login", "Login Done")
           } else Log.d("Login", "Login Not Done")
       }
   }

}
