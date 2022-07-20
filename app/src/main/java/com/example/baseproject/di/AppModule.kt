package com.example.baseproject.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.baseproject.api.Api
import com.example.baseproject.api.RetroHelper
import com.example.baseproject.db.EmployeeDao
import com.example.baseproject.db.EmployeeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun getInstance(): Retrofit {
        val clientSetup = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout
            .build()
        return Retrofit.Builder()
            .baseUrl(RetroHelper.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun providesRetrofit(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    @Singleton
     @Provides
    fun getDatabase(context:Application) : EmployeeDatabase {
        return EmployeeDatabase.getDatabase(context)
    }
    @Singleton
    @Provides
    fun employeeDao(employeeDatabase: EmployeeDatabase) : EmployeeDao {
        return employeeDatabase.employeeDao()
    }
}