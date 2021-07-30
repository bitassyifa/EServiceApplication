package com.projectassyifa.eserviceapplication.data.hrd.api


import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BerkasAPI {
    @GET ("berkasPegawai/{id_pegawai}/{kode_doc}")
    fun berkas(@Path("id_pegawai")id_pegawai : String ,
    @Path("kode_doc")kode_doc : String) : Call<ResponseAPI>
}