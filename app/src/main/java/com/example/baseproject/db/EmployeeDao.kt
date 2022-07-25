package com.example.baseproject.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: Employee)
//    @Query("select password from employee where email=:email")
//    fun getAll(email:String) :String
    @Query("select * from employee ")
    fun getAll() : List<Employee>
    @Query("select password from employee where email=:email")
    fun loginPasswordChecking(email:String) : String
}