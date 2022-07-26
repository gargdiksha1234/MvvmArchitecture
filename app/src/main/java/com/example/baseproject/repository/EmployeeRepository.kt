package com.example.baseproject.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.baseproject.db.Employee
import com.example.baseproject.db.EmployeeDatabase
import javax.inject.Inject
//

class EmployeeRepository @Inject  constructor( val employeeDatabase: EmployeeDatabase) {


    fun addPlayer(employee: Employee)
    {
        employeeDatabase.employeeDao().insertEmployee(employee)
    }
    fun getAll(email:String) : List<Employee>
    {

       return employeeDatabase.employeeDao().getAll()

    }
    fun loginPasswordChecking(email:String) : String?
    {

        return employeeDatabase.employeeDao().loginPasswordChecking(email)

    }
    suspend fun update(password:String,email: String)
    {
        Log.d("Checking" , password.toString())
        Log.d("Checking" , email.toString())

        employeeDatabase.employeeDao().update( password, email)
    }
}