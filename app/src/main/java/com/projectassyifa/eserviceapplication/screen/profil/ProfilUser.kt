package com.projectassyifa.eserviceapplication.screen.profil

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.number.NumberFormatter.with
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.AnswerCovidModel
import com.projectassyifa.eserviceapplication.screen.login.LoginActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profil_user.*

class ProfilUser : Fragment(),View.OnClickListener {

    var dataLogin: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataLogin = activity?.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_user, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_logout.setOnClickListener(this)

        val unit = dataLogin?.getString(
            getString(R.string.unit),
            getString(R.string.default_value)
        )
        val id = dataLogin?.getString(
            getString(R.string.id_pegawai),
            getString(R.string.default_value)
        )
        val nama = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )
        val bidang = dataLogin?.getString(
            getString(R.string.bidang),
            getString(R.string.default_value)
        )
        val divisi = dataLogin?.getString(
            getString(R.string.divisi),
            getString(R.string.default_value)
        )
        val notlp = dataLogin?.getString(
            getString(R.string.no_tlp),
            getString(R.string.default_value)
        )
        val alamat = dataLogin?.getString(
            getString(R.string.alamat_tinggal),
            getString(R.string.default_value)
        )
        val tgl = dataLogin?.getString(
            getString(R.string.tgl_lahir),
            getString(R.string.default_value)
        )

        data_nama.text = nama
        data_id.text =": $id"
        data_unit.text = ": $unit"
        data_bidang.text = ": $bidang"
        data_divisi.text = ": $divisi"
        data_notlp.text = ": $notlp"
        data_alamat.text=": $alamat"
        data_tgl.text = ": $tgl"

        val foto = dataLogin?.getString(
            getString(R.string.foto),
            getString(R.string.default_value)
        )
        var linkFoto= "http://202.62.9.138:1234/hrd/php/foto/$foto"
        Glide
            .with(this)
            .load(linkFoto)
            .fitCenter()
            .placeholder(R.drawable.ic_profil)
            .into(profil_image);
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_logout -> {

            // Initialize a new instance of
                            val builder = AlertDialog.Builder(activity)

            // Set the alert dialog title
                            builder.setTitle("Konfirmasi Logout")

            // Display a message on alert dialog
                            builder.setMessage("Apakah anda yakin, Anda ingin Keluar Akun sekarang?")

            // Set a positive button and its click listener on alert dialog
                builder.setPositiveButton("Ya") { dialog, which ->
                    // Do something when user press the positive button
                    with(dataLogin?.edit()) {
                        this?.clear()
                        this?.apply()
                        Intent(getContext(), LoginActivity::class.java).apply {
                            addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.also { startActivity(it) }
                    }
                }


// Display a negative button on alert dialog
                builder.setNegativeButton("Tidak"){dialog,which ->
//                    Toast.makeText(activity,"Anda tidak yakin.", Toast.LENGTH_SHORT).show()
                }


// Display a neutral button on alert dialog
//                        builder.setNeutralButton("Cancel"){_,_ ->
//                            Toast.makeText(activity,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
//                        }

// Finally, make the alert dialog using builder
                val dialog: AlertDialog = builder.create()

// Display the alert dialog on app interface
                dialog.show()

            }
        }
    }


}

