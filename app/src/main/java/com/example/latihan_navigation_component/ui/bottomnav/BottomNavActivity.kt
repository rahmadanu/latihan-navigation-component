package com.example.latihan_navigation_component.ui.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.latihan_navigation_component.R
import com.example.latihan_navigation_component.databinding.ActivityBottomNavBinding
import com.example.latihan_navigation_component.util.Notifier
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : AppCompatActivity() {

    private var _binding: ActivityBottomNavBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder( //each id has to be same between menu id and navigation graph id
            R.id.homeFragment,
            R.id.chatFragment,
            R.id.moreFragment
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)

        Notifier.init(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}