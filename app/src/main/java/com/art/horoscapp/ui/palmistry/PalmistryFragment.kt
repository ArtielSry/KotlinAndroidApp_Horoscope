package com.art.horoscapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.art.horoscapp.Manifest
import com.art.horoscapp.R
import com.art.horoscapp.databinding.FragmentLuckBinding
import com.art.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startCamera()
        } else {
            Toast.makeText(
                requireContext(),
                "Accept permissions for enjoy this experience!",
                Toast.LENGTH_LONG
            ).show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()) {

        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            android.Manifest.permission.CAMERA
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}