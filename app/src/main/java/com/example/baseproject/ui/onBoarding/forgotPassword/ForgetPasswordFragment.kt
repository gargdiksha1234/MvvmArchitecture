package com.example.baseproject.ui.onBoarding.forgotPassword

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.baseproject.model.request.NetworkResult
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.databinding.FragmentForgetPasswordBinding
import com.example.baseproject.utils.ProjectConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgetPasswordFragment : BaseFragment(){
private lateinit var binding: FragmentForgetPasswordBinding
private lateinit var forgotPasswordViewModel : ForgotPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentForgetPasswordBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forgotPasswordViewModel= ViewModelProvider(this)[ForgotPasswordViewModel::class.java]
        binding.forgotPasswordViewModel=forgotPasswordViewModel
        forgotPasswordResponse(view)

    }

    private fun forgotPasswordResponse(view: View) {
        forgotPasswordViewModel.userResponseForgotPassword.observe(viewLifecycleOwner) {
            it?:return@observe
            when (it) {
                is NetworkResult.Success -> {
                    Toast.makeText(requireActivity(),ProjectConstants.SUCCEES,Toast.LENGTH_LONG)
                    Log.d(ProjectConstants.TAG,ProjectConstants.SUCCEES)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireActivity(),ProjectConstants.ERROR,Toast.LENGTH_LONG)
                    Log.d(ProjectConstants.TAG,ProjectConstants.ERROR)

                }
                is NetworkResult.Loading -> {
                    Toast.makeText(requireActivity(),ProjectConstants.LOADING,Toast.LENGTH_LONG)
                    Log.d(ProjectConstants.TAG,ProjectConstants.LOADING)
                }
            }
        }
    }

}