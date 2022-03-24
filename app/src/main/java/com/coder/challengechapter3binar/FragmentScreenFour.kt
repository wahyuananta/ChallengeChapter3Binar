package com.coder.challengechapter3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.coder.challengechapter3binar.databinding.FragmentScreenFourBinding

class FragmentScreenFour : Fragment() {
    private var _binding: FragmentScreenFourBinding? = null
    private val binding get() = _binding!!

    private val args: FragmentScreenFourArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScreenFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreenFour.setOnClickListener {
            val nama = args.namaKamu
            val alat = binding.etAlatElektronik.text.toString()
            val watt = binding.etWatt.text.toString()
            val jam = binding.etJam.text.toString()
            val biaya = binding.etBiaya.text.toString()

            when {
                alat.isEmpty() -> {
                    Toast.makeText(requireContext(), "Kolom Nama Peralatan Elektronik Masih Kosong", Toast.LENGTH_SHORT).show()
                }
                watt.isEmpty() -> {
                    Toast.makeText(requireContext(), "Kolom Daya Alat Elektronik Masih Kosong", Toast.LENGTH_SHORT).show()
                }
                jam.isEmpty() -> {
                    Toast.makeText(requireContext(), "Kolom Pemakaian Alat Elektronik Masih Kosong", Toast.LENGTH_SHORT).show()
                }
                biaya.isEmpty() -> {
                    Toast.makeText(requireContext(), "Kolom Biaya Per kWh Masih Kosong", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val dataBiayaListrik = BiayaListrik(alat, watt.toDouble(), jam.toDouble(), biaya.toDouble())

                    val actionToScreen3 = FragmentScreenFourDirections.actionFragmentScreenFourToFragmentScreenThree(nama, dataBiayaListrik)
                    it.findNavController().navigate(actionToScreen3)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}