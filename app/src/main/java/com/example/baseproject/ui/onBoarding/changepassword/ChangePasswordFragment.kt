package com.example.baseproject.ui.onBoarding.changepassword

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.baseproject.R
import com.example.baseproject.databinding.FragmentChangePasswordBinding
import com.example.baseproject.databinding.FragmentForgetPasswordBinding
import com.example.baseproject.ui.onBoarding.forgotPassword.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment : Fragment() {
    private lateinit var binding: FragmentChangePasswordBinding
    private lateinit var changePasswordViewModel : ChangePasswordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentChangePasswordBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changePasswordViewModel= ViewModelProvider(this)[ChangePasswordViewModel::class.java]

        binding.changeViewModel=changePasswordViewModel
        binding.lifecycleOwner=this



    }



}