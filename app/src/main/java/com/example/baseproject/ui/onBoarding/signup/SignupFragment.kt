package com.example.baseproject.ui.onBoarding.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.databinding.FragmentSignupBinding
import com.example.baseproject.db.EmployeeDatabase
import com.example.baseproject.repository.EmployeeRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment() {


    private lateinit var binding:FragmentSignupBinding
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
        binding.tvHaveaccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }
}