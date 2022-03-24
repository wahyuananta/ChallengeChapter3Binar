package com.coder.challengechapter3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.coder.challengechapter3binar.databinding.FragmentScreenTwoBinding

class FragmentScreenTwo : Fragment() {
    private var _binding: FragmentScreenTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreenTwo.setOnClickListener {
            val nama = binding.etNama.text.toString()

            if (nama.isEmpty()) {
                Toast.makeText(requireContext(), "Kolom Nama Masih Kosong", Toast.LENGTH_SHORT).show()
            } else {
                val actionToFragmentScreen3 = FragmentScreenTwoDirections.actionFragmentScreenTwoToFragmentScreenThree(nama, null)
                it.findNavController().navigate(actionToFragmentScreen3)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}