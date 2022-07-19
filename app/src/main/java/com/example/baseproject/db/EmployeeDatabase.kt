package com.example.baseproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase :RoomDatabase(){
    abstract fun employeeDao():EmployeeDao
    companion object {

    }
}