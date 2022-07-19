package com.example.baseproject.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.baseproject.R
import com.example.baseproject.utils.NetworkUtils
import com.example.baseproject.utils.ProjectConstants

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
       if(NetworkUtils.isInternetAvailable(this))
           Toast.makeText(this,ProjectConstants.PERMISSION_GRANTED,Toast.LENGTH_LONG)
        else
           Toast.makeText(this,ProjectConstants.PERMISSION_NOT_GRANTED,Toast.LENGTH_LONG)
    }
}