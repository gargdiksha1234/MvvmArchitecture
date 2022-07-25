package com.example.baseproject.ui.onBoarding.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R
import com.example.baseproject.databinding.FragmentLoginBinding
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.db.EmployeeDatabase
import com.example.baseproject.ui.onBoarding.signup.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loginViewModel= ViewModelProvider(this)[LoginViewModel::class.java]

        binding.tvForgetPassword.setOnClickListener{
            findNavController().navigate(R.id.forgetPasswordFragment)
        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.signupFragment)
        }
        binding.tvChangepassword.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment)
        }
    }
}