package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.projectassyifa.eserviceapplication.data.hrd.api.UploadBerkasAPI1
import com.projectassyifa.eserviceapplication.data.hrd.model.BerkasModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class UploadBerkasRepo @Inject constructor(val uploadBerkasAPI1: UploadBerkasAPI1){
    var uploadResponse = MutableLiveData<ResponseAPI>()

    fun uploadBerkas(id_pegawai : String, data : BerkasModel , file : File){
//        val id_pegawai = convert(data.id_pegawai)
        val kode_doc = convert(data.kode_doc)
        val nama_pegawai = convert(data.nama_pegawai)
        val created_by = convert(data.created_by)
        val upload_file = convertFile(file)

        println("DATA REPO ${data.id_pegawai},${data.kode_doc},${data.nama_pegawai},${data.created_by},$file")

        uploadBerkasAPI1.uploadBerkas(id_pegawai, kode_doc, nama_pegawai, created_by, upload_file).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val res = response.body()
                val stringResponse = Gson().toJson(res)
                val dataUploadBerkas = Gson().fromJson<ResponseAPI>(stringResponse,ResponseAPI::class.java)
                uploadResponse.value = dataUploadBerkas
                println("MASUK REPO")
                if (res != null) {
                    println("ini res ${res.status}")
                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                t.printStackTrace()
                println("UPLOAD BERKAS GAGAL")
            }

        })

    }

    private fun convert (string :String ) : RequestBody {
        return RequestBody.create("text/plain".toMediaTypeOrNull(),string)
    }

    private fun convertFile(file:File): MultipartBody.Part{
        val reqFile : RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(),file)
        return MultipartBody.Part.createFormData("upload_file",file.name,reqFile)
    }
}