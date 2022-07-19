package com.example.baseproject.ui.onBoarding.onBoardingActivity

import android.os.Bundle
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
    }
}