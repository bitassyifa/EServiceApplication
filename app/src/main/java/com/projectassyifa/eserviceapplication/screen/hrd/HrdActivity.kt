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
//            var move = Intent(this,FormIzinActivity::class.java)
//            startActivity(move)
            var dialog = DialogIsiForm()
            val bundle= Bundle()
            dialog.arguments = bundle

            bundle.putString("title","Ketentuan Izin")
            bundle.putString("point_1","1. Permohonan IZIN selambat-lambat diajukan ke Bidang HRD 1 hari sebelum tanggal IZIN")
            bundle.putString("point_2","2. Atasan Langsung dan atau Kepala Bidang/ unit berhak menunda/ menolak IZIN")
            bundle.putString("point_3","3. Formulir IZIN ini hanya berlaku bila sudah approved Kabag HRD Yayasan")
            dialog.show(supportFragmentManager, "customDialog")
        }
        form_cuti_menu.setOnClickListener {
//            var move = Intent(this,FormCutiActivity::class.java)
//            startActivity(move)
            var dialog = DialogIsiForm()
            val bundle= Bundle()
            dialog.arguments = bundle

            bundle.putString("title","Ketentuan Cuti")
            bundle.putString("point_1","1. Permohonan Cuti selambat-lambat diajukan ke Bidang HRD 7 hari sebelum tanggal cuti, Untuk Cuti hamil/ melahirkan, pengajuan selambat-lambatnya 30 hari sebelum tgl cuti")
            bundle.putString("point_2","2. Atasan Langsung dan Kepala Bidang/ unit berhak menunda/ menolak cuti")
            bundle.putString("point_3","3. Cuti ini hanya berlaku bila sudah di Approved Oleh Kabid HRD Yayasan")
            dialog.show(supportFragmentManager, "customDialog")
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