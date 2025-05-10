package com.example.wisata_indonesia_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.wisata_indonesia_2.MainActivity
import com.example.wisata_indonesia_2.R
import com.example.wisata_indonesia_2.databinding.FragmentCreateBinding
import com.example.wisata_indonesia_2.model.Wisata

class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        setupSaveButton()

        return binding.root
    }

    private fun setupSaveButton() {
        binding.buttonSimpan.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val location = binding.editTextLocation.text.toString().trim()
            val description = binding.editTextDeskripsi.text.toString().trim()

            // Validasi input
            if (name.isBlank() || location.isBlank() || description.isBlank()) {
                showToast("Semua field wajib diisi")
                return@setOnClickListener
            }

            // Tambah data wisata
            val wisataBaru = Wisata(name, location, description)
            viewModel.addNewWisata(wisataBaru)

            // Bersihkan input dan tampilkan feedback
            clearForm()
            showToast("Wisata berhasil ditambahkan")

            // Navigasi kembali ke HomeFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()

            // Update bottom navigation ke Home
            (requireActivity() as MainActivity).binding.navView.selectedItemId = R.id.navigation_home
        }
    }

    private fun clearForm() {
        binding.editTextName.text?.clear()
        binding.editTextLocation.text?.clear()
        binding.editTextDeskripsi.text?.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
