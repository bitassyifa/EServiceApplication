package com.projectassyifa.eserviceapplication.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.screen.alert.Loading
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var  navController: NavController
    private var backpressedTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val loading = Loading(this)
        loading.startLoading()
        val handler = Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                loading.isDismiss()
            }

        },3000)
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