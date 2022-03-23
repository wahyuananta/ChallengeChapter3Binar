package com.coder.challengechapter3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coder.challengechapter3binar.databinding.FragmentScreen3Binding

class FragmentScreen3 : Fragment() {
    private var _binding: FragmentScreen3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScreen3Binding.inflate(inflater, container, false)
        return binding.root
    }

}