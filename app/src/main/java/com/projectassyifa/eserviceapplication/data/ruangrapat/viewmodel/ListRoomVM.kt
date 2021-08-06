package com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.ListRoomModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.repository.ListRoomRepo
import javax.inject.Inject

class ListRoomVM @Inject constructor(var listRoomRepo: ListRoomRepo){
    var listroom : MutableLiveData<List<ListRoomModel>>? = listRoomRepo.listRoom

    fun room(){
        listRoomRepo.room()
    }
}