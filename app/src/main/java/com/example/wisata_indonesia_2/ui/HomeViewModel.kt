package com.example.wisata_indonesia_2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wisata_indonesia_2.model.Wisata

class HomeViewModel : ViewModel() {

    private val _wisataItems = MutableLiveData<List<Wisata>>()
    val wisataItems: LiveData<List<Wisata>> get() = _wisataItems

    private val wisataListInternal = mutableListOf(
        Wisata("Garuda Wisnu Kencana (GWK)", "Bali, Indonesia", "Taman budaya megah menampilkan patung Dewa Wisnu menunggangi Garuda raksasa, menawarkan pemandangan spektakuler dan pertunjukan seni tradisional."),
        Wisata("Taman Hutan Raya Ir. H. Djuanda", "Bandung, Indonesia", "Ruang terbuka hijau dan taman rekreasi sederhana di pusat kota Bandung, cocok untuk bersantai dan aktivitas ringan."),
        Wisata("Taman Mini Indonesia Indah", "Jakarta, Indonesia", "Taman budaya yang menampilkan keragaman Indonesia.")
    )

    init {
        _wisataItems.value = wisataListInternal
    }

    fun addNewWisata(wisata: Wisata) {
        wisataListInternal.add(wisata)
        _wisataItems.value = wisataListInternal.toList() // trigger perubahan LiveData
    }
}
