package com.example.baseproject.ui.onBoarding.signup

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baseproject.base.BaseViewModel
import com.example.baseproject.db.Employee
import com.example.baseproject.repository.EmployeeRepository
import com.example.baseproject.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignUpViewModel@Inject constructor(private val employeeRepository: EmployeeRepository): BaseViewModel() {
    var name= MutableLiveData<String>()
    var email= MutableLiveData<String>()
    var phone= MutableLiveData<String>()
    var password= MutableLiveData<String>()

    val nameError = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val phoneError = MutableLiveData<String>()
    val passError = MutableLiveData<String>()


    init {
        emailError.value="Invalid Email Address"
    }

    fun addPlayer(employee: Employee)
    {
        Log.d("tag","function")
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.addPlayer(employee)
        }
    }
    fun add1(){
        addPlayer(
            Employee(
            null,
            name.value.toString(),
            email.value.toString(),
            phone.value.toString(),
            password.value.toString()
                ))

    }

    fun validation(){
        emailError.value="Invalid Email Address"
        Log.e("emailvalid","emailvalid")
        Log.e("emailvalid",emailError.value.toString())
//        if(!Patterns.EMAIL_ADDRESS.matcher(email.value.toString()).matches())
//        {
//            Log.e("emailvalid","emailvalid")
//            emailError.value="Invalid Email Address"
//        }
//        else add1()
    }

}
