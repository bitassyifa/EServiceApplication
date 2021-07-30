package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.BerkasModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.BerkasRepo
import javax.inject.Inject

class BerkasVM @Inject constructor(var berkasRepo: BerkasRepo) {
    var get_berkas : MutableLiveData<List<BerkasModel>>? = berkasRepo.get_berkas
    fun berkas(id_pegawai : String , kode_doc : String){
        berkasRepo.berkas(id_pegawai,kode_doc)
        println("BERKAS VM $id_pegawai,$kode_doc")
    }
}