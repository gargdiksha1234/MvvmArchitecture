package com.example.baseproject.ui.onBoarding.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.databinding.FragmentSignupBinding
import com.example.baseproject.db.EmployeeDatabase
import com.example.baseproject.repository.EmployeeRepository
import com.example.baseproject.ui.onBoarding.forgotPassword.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment() {


    private lateinit var binding:FragmentSignupBinding
    private lateinit var signUpViewModel:SignUpViewModel
     private lateinit var employeeRepository: EmployeeRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentSignupBinding.inflate(inflater,container,false)
     //   employeeRepository = EmployeeRepository(
       //     EmployeeDatabase.getDatabase(requireActivity().applicationContext))


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpViewModel= ViewModelProvider(this)[SignUpViewModel::class.java]
        binding.signupViewModel=signUpViewModel
        binding.lifecycleOwner=this
        binding.tvHaveaccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }
}