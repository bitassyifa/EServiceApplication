package com.projectassyifa.eserviceapplication.screen.hrd

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.BerkasVM
import kotlinx.android.synthetic.main.activity_berkas_pegawai.*
import javax.inject.Inject


class BerkasPegawaiActivity : AppCompatActivity() {
    var dataLogin : SharedPreferences? = null

    @Inject
    lateinit var berkasVM : BerkasVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berkas_pegawai)
        (applicationContext as MyApplication).applicationComponent.inject(this)
        dataLogin = this.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )

        //refresh
        refreshApp()

        val foto = dataLogin?.getString(
            getString(R.string.foto),
            getString(R.string.default_value)
        )
        val nama = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )
        val username = dataLogin?.getString(
            getString(R.string.username),
            getString(R.string.default_value)
        )
        val id_pegawai = dataLogin?.getString(
            getString(R.string.id_pegawai),
            getString(R.string.default_value)
        )

        nama_pegawai.text=nama
        var linkFoto= "http://202.62.9.138:1234/hrd/php/foto/$foto"
        Glide
            .with(this)
            .load(linkFoto)
            .placeholder(R.drawable.laod)
            .into(img_pp);




        berkasVM.get_berkas?.observe(this,Observer{

//            var ijazahS1= it[0].nama_doc


          it.forEach {
              println("NAMA DOC ${it.kode_doc}")
              val kode = it.kode_doc

              if (kode == "KTP") {

                  var linkFotoKTP =
                      "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  println("LINK FOTO KTP $linkFoto")
                  Glide
                      .with(this)
                      .load(linkFotoKTP)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ktp)
              }
              if (kode == "IJAZAH_D1") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_d1)
              }

              if (kode == "TRANSKIP_D1") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_d1)
              }
              if (kode == "IJAZAH_D2") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_d2)
              }

              if (kode == "TRANSKIP_D2") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_d2)
              }

              if (kode == "IJAZAH_D3") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_d3)
              }

              if (kode == "TRANSKIP_D3") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_d3)
              }


              if (kode == "IJAZAH_S1") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_s1)
              }

              if (kode == "TRANSKIP_S1") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_s1)
              }

              if (kode == "IJAZAH_S2") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_s2)
              }

              if (kode == "TRANSKIP_S2") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_s2)
              }
              if (kode == "IJAZAH_S3") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_ijazah_s3)
              }

              if (kode == "TRANSKIP_S3") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_transkip_s3)
              }
              if (kode == "KK") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_kk)
              }

              if (kode == "NPWP") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_npwp)
              }
              if (kode == "NUPTK") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_nuptk)
              }

              if (kode == "SERTIFIKAT_PENDIDIK") {

                  var linkFoto = "http://202.62.9.138/dashboard_android_fresh/berkas/${it.nama_doc}"
                  Glide
                      .with(this)
                      .load(linkFoto)
                      .placeholder(R.drawable.laod)
                      .error(R.drawable.no_image)
                      .into(img_sert_pendidik)
              }
          }
        })
        berkasVM.berkas(id_pegawai.toString(),"IJAZAH_S1")

        //upload

        uploadKtp.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "KTP")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload KTP")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadIjazah_d1.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_D1")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah D1")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_d1.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_D1")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip D1")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadIjazah_d2.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_D2")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah D2")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_d2.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_D2")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip D2")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadIjazah_d3.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_D3")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah D3")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_d3.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_D3")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip D3")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadIjazah_s1.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_S1")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah S1")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_s1.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_S1")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip S1")

            dialog.show(supportFragmentManager, "customDialog")
        }


        btn_uploadIjazah_s2.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_S2")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah S2")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_s2.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_S2")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip S2")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadIjazah_s3.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "IJAZAH_S3")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Ijazah S3")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadTranskip_s3.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "TRANSKIP_S3")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Transkip S3")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_uploadKK.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "KK")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Kartu Keluarga")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_npwp.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "NPWP")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload NPWP")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_nuptk.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "NUPTK")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload NUPTK")

            dialog.show(supportFragmentManager, "customDialog")
        }

        btn_sertif_pendidik.setOnClickListener {

            var dialog = UploadBerkas()
            val bundle= Bundle()
            dialog.arguments = bundle
            bundle.putString("id_pegawai", id_pegawai.toString())
            bundle.putString("kode_doc", "SERTIFIKAT_PENDIDIK")
            bundle.putString("created_by", username)
            bundle.putString("title","Upload Sertifikat Pendidik")

            dialog.show(supportFragmentManager, "customDialog")
        }
    }

    private fun refreshApp() {
        refreshLayout.setOnRefreshListener {
            Toast.makeText(this,"Refresh", Toast.LENGTH_SHORT).show()
            finish();
            startActivity(getIntent());

        }
    }

}

