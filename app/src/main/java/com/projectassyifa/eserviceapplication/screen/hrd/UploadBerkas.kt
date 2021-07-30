package com.projectassyifa.eserviceapplication.screen.hrd


import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.hrd.model.BerkasModel
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.UploadBerkasVM
import com.projectassyifa.eserviceapplication.screen.alert.Complete
import com.projectassyifa.eserviceapplication.screen.alert.FileNull
import com.projectassyifa.eserviceapplication.screen.alert.UploadProgress
import com.projectassyifa.eserviceapplication.screen.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_upload_berkas.*
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import java.io.File
import javax.inject.Inject

class UploadBerkas : DialogFragment() {




    @Inject
    lateinit var uploadBerkasVM: UploadBerkasVM


    private val cameraRequestId  = 1222
    var dataLogin : SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
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
        dialog?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        var rootView : View = inflater.inflate(R.layout.fragment_upload_berkas,container,false)

        val judul = rootView.findViewById<TextView>(R.id.title)
        judul.setText(arguments?.getString("title"))
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //permission
        if (getActivity()?.let {
                ContextCompat.checkSelfPermission(
                    it.getApplicationContext(), Manifest.permission.CAMERA
                )
            } == PackageManager.PERMISSION_DENIED)
            this.activity?.let {
                ActivityCompat.requestPermissions(
                    it, arrayOf(Manifest.permission.CAMERA),
                    cameraRequestId
                )
            }
        pilih_file.setOnClickListener {
            val popMenu = PopupMenu(this.context, it)
            popMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.opencamera -> {
                        EasyImage.openCamera(this, 1)
                        true
                    }
                    R.id.opengaleri -> {
                        EasyImage.openGallery(this, 1)
                        true
                    }
                    R.id.openfile -> {
                        EasyImage.openDocuments(this, 1)
                        true
                    }
                    else -> false
                }
            }
            popMenu.inflate(R.menu.upload)
            popMenu.show()

        }

        val username = dataLogin?.getString(
            getString(R.string.username),
            getString(R.string.default_value)
        )

        val nama_pegawai = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )

        btn_batal.setOnClickListener {
            dismiss()
        }
        btn_simpan.setOnClickListener {
            val uploadData = BerkasModel()
//            uploadData.id_pegawai = arguments?.getString("id_pegawai").toString()
            uploadData.kode_doc = arguments?.getString("kode_doc").toString()
            uploadData.nama_pegawai = nama_pegawai.toString()
            uploadData.created_by = username.toString()

            if (fileImage == null) {
                val loading = FileNull(this)
                loading.startLoading()
                val handler = Handler()
                handler.postDelayed(object :Runnable{
                    override fun run() {
                        loading.isDismiss()
                    }

                },4000)
//                Toast.makeText(
//                    this.context,
//                    "Tidak ada file yang di pilih!!",
//                    Toast.LENGTH_SHORT
//                ).show()

            } else {
                uploadBerkasVM.uploadBerkas(arguments?.getString("id_pegawai").toString(),uploadData, fileImage!!)
                println("DATA ${uploadData.id_pegawai},${uploadData.kode_doc},${uploadData.nama_pegawai},${uploadData.created_by},${fileImage!!.name}")
                val loading = Complete(this)
                loading.startLoading()
                val handler = Handler()
                handler.postDelayed(object :Runnable{
                    override fun run() {
                        loading.isDismiss()
                    }

                },4000)


                dismiss()

//                val move = Intent(this.context,HomeActivity::class.java)
//                startActivity(move)
            }


        }
    }

    var fileImage : File? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val loading = UploadProgress(this)
        loading.startLoading()
        val handler = Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                loading.isDismiss()
            }

        },4000)


        EasyImage.handleActivityResult(requestCode,resultCode,data,this.activity,object :
            DefaultCallback(){
            var selectedImage = data?.data
            override fun onImagePicked(
                imageFile: File?,
                source: EasyImage.ImageSource?,
                type: Int
            ) {

                fileImage = imageFile
                var namaImage =imageFile?.name
                println("HASIL IMAGE $fileImage")
                println("NAMA IMAGE $namaImage")
                nama_file.setText(imageFile?.name)
                val requestOptions = RequestOptions().error(R.drawable.upload)
                activity?.let {
                    Glide.with(it)
                        .load(imageFile)
                        .apply(requestOptions)
                        .into(image_upload)
                }
            }

        });
    }



}