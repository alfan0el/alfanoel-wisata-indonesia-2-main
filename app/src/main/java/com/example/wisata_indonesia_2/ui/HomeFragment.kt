package com.example.wisata_indonesia_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisata_indonesia_2.R
import com.example.wisata_indonesia_2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var wisataAdapter: WisataAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        observeWisataList()

        return binding.root
    }

    private fun setupRecyclerView() {
        wisataAdapter = WisataAdapter(emptyList()) { selectedWisata ->
            val detailFragment = DetailFragment.newInstance(selectedWisata)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = wisataAdapter
        }
    }

    private fun observeWisataList() {
        homeViewModel.wisataItems.observe(viewLifecycleOwner) { wisataList ->
            wisataAdapter.updateList(wisataList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
