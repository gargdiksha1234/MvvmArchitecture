package com.example.baseproject.ui.onBoarding.signup

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.baseproject.R
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.databinding.FragmentSignupBinding
import com.example.baseproject.db.EmployeeDatabase
import com.example.baseproject.repository.EmployeeRepository
import com.example.baseproject.ui.onBoarding.forgotPassword.ForgotPasswordViewModel
import com.example.baseproject.utils.ImageExtension
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.camera_gallery.view.*

@AndroidEntryPoint
class SignupFragment : BaseFragment() {
    private var imageUri: Uri?=null

    private lateinit var binding:FragmentSignupBinding
    private lateinit var signUpViewModel:SignUpViewModel


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
        binding.ivUserimage.setOnClickListener {
            uploadImage()
        }
    }
    private fun uploadImage() {
        val view = View.inflate(requireContext(), R.layout.camera_gallery, null)
            val builder = AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            view.bt_camera.setOnClickListener {
                dialog.dismiss()
                camera()
            }
            view.bt_gallery.setOnClickListener {
                dialog.dismiss()
                gallery()
            }
        }
    private fun camera() {
        if (ImageExtension.checkPermissionGivenOrNot(
                requireContext(),
                Manifest.permission.CAMERA
            )
        ) {
            openCamera()
        } else {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 10)
            Log.d("camera","Camera Permission denied")
        }
    }
    private fun gallery() {
        if (ImageExtension.checkPermissionGivenOrNot(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {
            openGallery()
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 12)
            Log.d("gallery","Gallery Permission denied")
        }
    }
    private fun openCamera() {
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLaunch.launch(camera)
    }
    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        resultLauncher.launch(gallery)
    }

    // set image in imageview from camera
    private var resultLaunch =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val bmp: Bitmap = data?.extras?.get("data") as Bitmap
                val a = ImageExtension.getImageUri(
                    bmp,
                    Bitmap.CompressFormat.JPEG,
                    25,
                    activity?.contentResolver!!
                )
                imageUri = a!!
                binding.ivUserimage.setImageBitmap(bmp)
               // addImageToFirebase()
            }
        }
    // set image in imageview from gallery
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                imageUri = data!!.data!!
                binding.ivUserimage.setImageURI(imageUri)
               // addImageToFirebase()
            }
        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        requireActivity().onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 10) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
                Log.d("camera","Camera Permission Given")
            } else {

                Log.d("camera","Camera Permission denied")
            }
        } else {
            if (requestCode == 12) {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openGallery()
                    Log.d("Gallery","Gallery Permission Given")
                } else {
                    Log.d("Gallery","Gallery Permission denied")                }
            }

        }

    }
}
