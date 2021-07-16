package com.projectassyifa.eserviceapplication.data.assesmentCovid19.viewmodel

import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.AnswerCovidModel
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.repository.AnswerCovidRepo
import javax.inject.Inject

class AnswerCovidVM @Inject constructor( var answerCovidRepo: AnswerCovidRepo){

    fun answer(answerCovidModel: AnswerCovidModel){
        answerCovidRepo.answer(answerCovidModel)
    }
}