package com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.repository.MeetingRoomRepo
import javax.inject.Inject

class MeetingRoomVM @Inject constructor(var meetingRoomRepo: MeetingRoomRepo){
    var schedule : MutableLiveData<List<MeetingRoomModel>>? = meetingRoomRepo.schedule

    fun now(){
        meetingRoomRepo.now()
    }

    fun add_schedule(meetingRoomModel: MeetingRoomModel){
        meetingRoomRepo.add_schedule(meetingRoomModel)
    }
}