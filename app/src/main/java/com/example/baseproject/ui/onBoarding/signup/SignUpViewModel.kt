package com.example.baseproject.ui.onBoarding.signup

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
    fun addPlayer(employee: Employee)
    {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.addPlayer(employee)
        }
    }
    fun add1(){
        addPlayer(
            Employee(
            1,
            name.toString(),
            email.toString(),
            phone.toString(),
            password.toString()
                ))
    }

}