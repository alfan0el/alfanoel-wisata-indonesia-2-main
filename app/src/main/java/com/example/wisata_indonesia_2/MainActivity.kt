package com.example.wisata_indonesia_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wisata_indonesia_2.databinding.ActivityMainBinding
import com.example.wisata_indonesia_2.ui.CreateFragment
import com.example.wisata_indonesia_2.ui.HomeFragment
import com.example.wisata_indonesia_2.ui.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(HomeFragment())

        binding.navView.setOnItemSelectedListener { menuItem ->
            supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)

            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.navigation_create -> {
                    showFragment(CreateFragment())
                    true
                }
                R.id.navigation_profile -> {
                    showFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
