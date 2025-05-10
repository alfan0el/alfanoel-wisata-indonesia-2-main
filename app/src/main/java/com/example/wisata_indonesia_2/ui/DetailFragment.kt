package com.example.wisata_indonesia_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wisata_indonesia_2.databinding.FragmentDetailBinding
import com.example.wisata_indonesia_2.model.Wisata

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private var wisataData: Wisata? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wisataData = arguments?.getParcelable(ARG_WISATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        displayWisataDetails()
        setupBackButton()

        return binding.root
    }

    private fun displayWisataDetails() {
        wisataData?.let { data ->
            binding.tvName.text = data.name
            binding.tvLocation.text = data.location
            binding.tvDescription.text = data.description
        }
    }

    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_WISATA = "arg_wisata"

        fun newInstance(wisata: Wisata): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_WISATA, wisata)
                }
            }
        }
    }
}
