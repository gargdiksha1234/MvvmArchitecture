package com.example.baseproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

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

    @Query("UPDATE employee SET password = :password WHERE email=:email")
    suspend fun update(password: String, email: String)
}