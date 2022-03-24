package com.coder.challengechapter3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.coder.challengechapter3binar.databinding.FragmentScreenThreeBinding

class FragmentScreenThree : Fragment() {
    private var _binding: FragmentScreenThreeBinding? = null
    private val binding get() = _binding!!

    val args: FragmentScreenThreeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScreenThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = args.nama
        binding.tvNama.text = nama

        val biayalistrik = args.parcelableBiayaListrik

        if (biayalistrik != null) {
            val peralatan = biayalistrik.peralatanElektronik
            val watt = biayalistrik.watt
            val jam = biayalistrik.jam
            val biaya = biayalistrik.biaya

            //            Rumus Perhitungan
            val biayaPerHari = ((watt * jam) / 1000) * biaya
            val biayaPerBulan = biayaPerHari * 30
            val biayaPerTahun = biayaPerHari * 365

            binding.tvNama.text = "Nama : $nama"
            binding.tvDetail.text = "Peralatan elektronik $peralatan dengan daya $watt watt dan pemakaian selama $jam jam/hari untuk tarif listrik Rp$biaya/kWh."
            binding.tvBiayaPerHari.text = "Biaya Listrik Per Hari Sebesar Rp${biayaPerHari.toInt()}"
            binding.tvBiayaPerBulan.text = "Biaya Listrik Per Bulan Sebesar Rp${biayaPerBulan.toInt()}"
            binding.tvBiayaPerTahun.text = "Biaya Listrik Per Tahun Sebesar Rp${biayaPerTahun.toInt()}"
            binding.btnScreenThree.visibility = View.GONE

        } else {
            binding.tvNama.text = "Hai, $nama"
            binding.tvDetail.visibility = View.GONE
            binding.tvBiayaListrik.visibility  = View.GONE
            binding.tvBiayaPerHari.visibility  = View.GONE
            binding.tvBiayaPerBulan.visibility  = View.GONE
            binding.tvBiayaPerTahun.visibility  = View.GONE
        }

        binding.btnScreenThree.setOnClickListener {
            val actionToScreen4 = FragmentScreenThreeDirections.actionFragmentScreenThreeToFragmentScreenFour(nama)

            it.findNavController().navigate(actionToScreen4)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}