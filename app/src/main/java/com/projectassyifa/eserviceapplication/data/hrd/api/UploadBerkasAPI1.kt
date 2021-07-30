package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface UploadBerkasAPI1 {

    @Multipart
    @POST("uploadBerkas/{id_pegawai}")
    fun uploadBerkas(@Path("id_pegawai")id_pegawai : String,
                     @Part("kode_doc")kode_doc : RequestBody,
                     @Part("nama_pegawai")nama_pegawai : RequestBody,
                     @Part("created_by")created_by : RequestBody,
                     @Part upload_file : MultipartBody.Part? = null
            ):Call<ResponseAPI>

}