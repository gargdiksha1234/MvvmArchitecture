package com.example.baseproject.ui.onBoarding.changepassword

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
class ChangePasswordViewModel@Inject constructor(private val  employeeRepository: EmployeeRepository): BaseViewModel() {
    var changeEmail=MutableLiveData<String>()
    var changePassword=MutableLiveData<String>()
    fun setEmail():String
    {
        var emails=changeEmail.value.toString()
        var password=changePassword.value.toString()

        return emails!!
    }
    fun update(changePassword:String,changeEmail:String)
    {
        viewModelScope.launch {
            employeeRepository.update(changePassword,changeEmail)
        }
    }

}