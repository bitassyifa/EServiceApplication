package com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.projectassyifa.eserviceapplication.R

class StatusMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_main)
        var viewPager = findViewById(R.id.viewPager) as ViewPager
        var tablayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = AdapterScreen(supportFragmentManager)
        fragmentAdapter.addFragment(StatusIzinPage(),"Status izin")
        fragmentAdapter.addFragment(StatusCutiPage(),"Status Cuti")


        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
    }
}