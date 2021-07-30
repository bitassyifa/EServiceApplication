package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.ViewModel
import com.projectassyifa.eserviceapplication.data.hrd.model.BerkasModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.UploadBerkasRepo
import java.io.File
import javax.inject.Inject

class UploadBerkasVM @Inject constructor(var uploadBerkasRepo: UploadBerkasRepo):ViewModel(){
    fun uploadBerkas(id_pegawai : String ,data : BerkasModel,file: File){

        uploadBerkasRepo.uploadBerkas(id_pegawai,data, file)
        println("DATA VM$data,$file")
    }
}