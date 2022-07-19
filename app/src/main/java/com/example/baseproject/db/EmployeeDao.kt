package com.example.baseproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: Employee)
}