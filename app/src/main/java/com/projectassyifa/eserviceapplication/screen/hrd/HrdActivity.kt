package com.projectassyifa.eserviceapplication.screen.hrd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti.StatusMainActivity
import kotlinx.android.synthetic.main.activity_hrd.*

class HrdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hrd)

        form_izin_menu.setOnClickListener {
            var move = Intent(this,FormIzinActivity::class.java)
            startActivity(move)
        }
        form_cuti_menu.setOnClickListener {
            var move = Intent(this,FormCutiActivity::class.java)
            startActivity(move)
        }
        statusMain.setOnClickListener {
            var move = Intent(this,StatusMainActivity::class.java)
            startActivity(move)
        }
        berkas.setOnClickListener {
            var move = Intent(this,BerkasPegawaiActivity::class.java)
            startActivity(move)
        }
    }
}