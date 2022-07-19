package com.example.baseproject.ui.Splash

import android.content.Intent
import android.os.Bundle
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.ui.onBoarding.onBoardingActivity.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

       CoroutineScope(Dispatchers.IO).launch {
           delay(3000)
           val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
           startActivity(intent)
           finish()
       }
    }

}