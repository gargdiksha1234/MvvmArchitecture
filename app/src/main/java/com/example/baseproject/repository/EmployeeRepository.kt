package com.example.baseproject.repository

import com.example.baseproject.db.Employee
import com.example.baseproject.db.EmployeeDatabase
import javax.inject.Inject
//

class EmployeeRepository @Inject  constructor( val employeeDatabase: EmployeeDatabase) {


    fun addPlayer(employee: Employee)
    {
        employeeDatabase.employeeDao().insertEmployee(employee)
    }
}