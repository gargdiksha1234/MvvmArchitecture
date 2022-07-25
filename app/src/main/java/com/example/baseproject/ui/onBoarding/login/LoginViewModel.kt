package com.example.baseproject.ui.onBoarding.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseproject.base.BaseViewModel
import com.example.baseproject.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val employeeRepository: EmployeeRepository): BaseViewModel() {

    var loginEmail= MutableLiveData<String>()
    var loginPassword= MutableLiveData<String>()
    fun setEmail():String
    {
        var emails=loginEmail.value
        Log.d("Checking",emails.toString())
        Log.d("cccc",loginEmail.value.toString())
        return emails?:""
    }

   fun loginPasswordChecking(loginEmail:String)
   {
       viewModelScope.launch(Dispatchers.IO) {
           val tag=employeeRepository.loginPasswordChecking(loginEmail).toString()
           Log.d("pass",tag)

       }
   }

}
