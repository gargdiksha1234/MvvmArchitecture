package com.example.baseproject.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.baseproject.R
import com.example.baseproject.utils.NetworkUtils
import com.example.baseproject.utils.ProjectConstants


abstract class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NetworkUtils.isInternetAvailable(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(NetworkUtils.isInternetAvailable(requireActivity()))
        Toast.makeText(requireActivity(),ProjectConstants.PERMISSION_GRANTED, Toast.LENGTH_LONG)
        else
        Toast.makeText(requireActivity(),ProjectConstants.PERMISSION_NOT_GRANTED, Toast.LENGTH_LONG)
    }

}