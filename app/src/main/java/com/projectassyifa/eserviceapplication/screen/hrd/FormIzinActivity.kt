package com.projectassyifa.eserviceapplication.screen.hrd

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.Observer
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterAlasanCuti
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterAlasanIzin
import com.projectassyifa.eserviceapplication.data.hrd.model.FormIzinHrdModel
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.*
import com.projectassyifa.eserviceapplication.screen.home.HomeActivity
import kotlinx.android.synthetic.main.activity_berkas_pegawai.*
import kotlinx.android.synthetic.main.activity_form_izin.*
import kotlinx.android.synthetic.main.activity_form_izin.refreshLayout
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class FormIzinActivity : AppCompatActivity() {
    var dataLogin : SharedPreferences? = null
    var calender = Calendar.getInstance()
    var tanggalAwal : String ? = null
    var tanggalAkhir : String ? = null
    var alibi_cuti : String ? = null
    var jarakTgl : String ? = null



    @Inject
    lateinit var statusAktifVM: StatusAktifVM

    @Inject
    lateinit var jenisPegawaiVM: JenisPegawaiVM

    @Inject
    lateinit var fungsionalVM: FungsionalVM
    @Inject
    lateinit var strukturalVM: StrukturalVM

    @Inject
    lateinit var alasanIzinVM: AlasanIzinVM
    lateinit var adapterAlasanIzin: AdapterAlasanIzin

    @Inject
    lateinit var formIzinHrdVM: FormIzinHrdVM





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_izin)
        (applicationContext as MyApplication).applicationComponent.inject(this)
        dataLogin = this.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )
        //refresh
        refreshApp()
        val id_pegawai= dataLogin?.getString(
            getString(R.string.id_pegawai),
            getString(R.string.default_value)
        )

        val nama = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )
        val email = dataLogin?.getString(
            getString(R.string.email),
            getString(R.string.default_value)
        )
        val nip= dataLogin?.getString(
            getString(R.string.nip),
            getString(R.string.default_value)
        )

        val tmt= dataLogin?.getString(
            getString(R.string.tanggal_mulai_tugas),
            getString(R.string.default_value)
        )

        val bidang= dataLogin?.getString(
            getString(R.string.bidang),
            getString(R.string.default_value)
        )

        val unit= dataLogin?.getString(
            getString(R.string.unit),
            getString(R.string.default_value)
        )

        val sa= dataLogin?.getString(
            getString(R.string.status_aktif),
            getString(R.string.default_value)
        )

        val sp= dataLogin?.getString(
            getString(R.string.status_pegawai),
            getString(R.string.default_value)
        )
        val jf= dataLogin?.getString(
            getString(R.string.fungsional_01),
            getString(R.string.default_value)
        )
        val js= dataLogin?.getString(
            getString(R.string.struktural),
            getString(R.string.default_value)
        )
        val atasan = dataLogin?.getString(
            getString(R.string.atasan_langsung),
            getString(R.string.default_value)
        )


        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        tgl_ajuan.text = currentDate
        nama_pemohon.text = nama
        nip1.text = nip
        tmt1.text= tmt
        bidang1.text= bidang
        unit1.text = unit

        var stsPegawai : String ? = null
        var jnsPegawai : String ? = null
        var jbtFungsional : String ? = null
        var jbtStruktural : String ? = null

        //status
        statusAktifVM.sts_pegawai?.observe(this,Observer{

            stsPegawai =it[0].status_aktif
            println("Aktif? $stsPegawai")
        })

        statusAktifVM.statusPegawai(sa.toString())

        //jenis
        jenisPegawaiVM.jns_pegawai?.observe(this,Observer{

            jnsPegawai = it[0].jenis_pegawai
            println("Jenis pegawai? $jnsPegawai")

        })
        jenisPegawaiVM.jenisPegawai(sp.toString())
        println("Jenis pegawai1? $jnsPegawai")
        println("Aktif1? $stsPegawai")

        //fungsional
       fungsionalVM.type_fungsi?.observe(this, Observer {
           jbtFungsional = it[0].fungsional
           println("ini fungsional $jbtFungsional")

       })
        fungsionalVM.fungsional(jf.toString())

        //struktural
        strukturalVM.type_struktural?.observe(this, Observer {
            jbtStruktural = it[0].struktural
            println("ini struktural $jbtStruktural")
            jbt_amanah.text = "$jbtStruktural/$jbtFungsional"
            status_kepegawaian.text = "$jnsPegawai/$stsPegawai"
        })
        strukturalVM.struktur(js.toString())

        println("ini js $js")
        println("ini jf $jf")
        //spinner alesan
        alasanIzinVM.alibi_izin?.observe(this,Observer{
            adapterAlasanIzin = AdapterAlasanIzin(this,it)
            spinnerCuti.adapter = adapterAlasanIzin


            //select
            spinnerCuti.onItemSelectedListener = object : AdapterView.OnItemSelectedListener  {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    println("ALASAN ${it[position].nama}")
                    alibi_cuti =it[position].kode
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                   println("no item select")
                }

            }
        })
        alasanIzinVM.izin()

        //tgl awal
        val dateStart = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                calender.set(Calendar.YEAR,year)
                calender.set(Calendar.MONTH,month)
                calender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                updateTglAwal()
            }
        }

        tgl_mulai.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                DatePickerDialog(this@FormIzinActivity,
                    dateStart,
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

        //tgl akhir
        val dateEnd = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                calender.set(Calendar.YEAR,year)
                calender.set(Calendar.MONTH,month)
                calender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                updateTglAkhir()
            }
        }
        tgl_akhir.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                DatePickerDialog(this@FormIzinActivity,
                    dateEnd,
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

            tombol_simpan.setOnClickListener {
                var contentForm = FormIzinHrdModel(
                    nama_pemohon = nama_pemohon.text.toString(),
                    id_pegawai = id_pegawai.toString(),
                    tmt = tmt.toString(),
                    status_kepegawaian = "$jnsPegawai/$stsPegawai",
                    jabatan_amanah = "$jbtStruktural/$jbtFungsional",
                    bidang = bidang.toString(),
                    unit = unit.toString(),
                    alasan_cuti = alibi_cuti.toString(),
                    cuti_mulai_tanggal = tanggalAwal.toString(),
                    cuti_sampai_tanggal = tanggalAkhir.toString(),
                    total_hari_cuti = "0",
                    alamat_selama_cuti = alamat_cuti.text.toString(),
                    no_hp_darurat = no_tlp.text.toString(),
                    atasan_langsung = atasan.toString(),
                    alasan_ijin_lainnya = "-",
                    created_by = email.toString()
                )

//                println("nama pemohon ${contentForm.nama_pemohon}")
//                println("id_pegawai ${contentForm.id_pegawai}")
//                println("tmt ${contentForm.tmt}")
//                println("status Kepegawaian ${contentForm.status_kepegawaian}")
//                println("jabatan amanah ${contentForm.jabatan_amanah}")
//                println("bidang ${contentForm.bidang}")
//                println("unit ${contentForm.unit}")
//                println("alasan ${contentForm.alasan_cuti}")
//                println("cuti mulai${contentForm.cuti_mulai_tanggal}")
//                println("cuti akhir${contentForm.cuti_sampai_tanggal}")
//                println("total hari ${contentForm.total_hari_cuti}")
//                println("alamat cuti ${contentForm.alamat_selama_cuti}")
//                println("no hp${contentForm.no_hp_darurat}")
//                println("atasan id${contentForm.atasan_langsung}")
//                println("alasan izin lainya${contentForm.alasan_ijin_lainnya}")
//                println("created by ${contentForm.created_by}")

                formIzinHrdVM.formIzin(contentForm)
                Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                var move = Intent(this,HomeActivity::class.java)
                startActivity(move)
            }



    }

    private fun refreshApp() {
        refreshLayout.setOnRefreshListener {
            Toast.makeText(this,"Refresh", Toast.LENGTH_SHORT).show()
            finish();
            startActivity(getIntent());

        }
    }


    private fun updateTglAkhir() {
       val formatTgl = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(formatTgl,Locale.US)
        tgl_akhir.text = sdf.format(calender.time)
        tanggalAkhir = sdf.format(calender.time)
        println("TANGGAL1 $tanggalAwal")
        println("TANGGAL1 $tanggalAkhir")

    }

    private fun updateTglAwal() {
        val formatTgl = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(formatTgl,Locale.US)
        tgl_mulai.text = sdf.format(calender.time)
        tanggalAwal = sdf.format(calender.time)

    }
}