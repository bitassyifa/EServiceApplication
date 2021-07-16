package com.projectassyifa.eserviceapplication.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.projectassyifa.eserviceapplication.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var  navController: NavController
    private var backpressedTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navController = (nav_main_host_fragment_container as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavView,navController)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.home -> {
                    navController.navigate(R.id.action_global_to_homeFragment)
                    true
                }
                R.id.profil -> {
                    navController.navigate(R.id.action_homeFragment_to_profilUser)
                    true
                }else -> {
                true
            }
            }
        }
    }
    override fun onBackPressed() {
        if (backpressedTime + 2000 > System.currentTimeMillis()) {
            finishAffinity()

        } else {
            Toast.makeText(
                applicationContext,
                "Tekan kembali sekali lagi untuk keluar",
                Toast.LENGTH_SHORT
            ).show()
        }
        backpressedTime = System.currentTimeMillis()

    }
}