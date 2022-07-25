package com.example.baseproject.repository

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
}