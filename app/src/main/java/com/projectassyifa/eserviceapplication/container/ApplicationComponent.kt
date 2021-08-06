package com.projectassyifa.eserviceapplication.container


import com.projectassyifa.eserviceapplication.data.assesmentCovid19.adapter.QuestionCovidAdapter
import com.projectassyifa.eserviceapplication.screen.covid.AssesmentCovidActivity
import com.projectassyifa.eserviceapplication.screen.hrd.BerkasPegawaiActivity
import com.projectassyifa.eserviceapplication.screen.hrd.FormCutiActivity
import com.projectassyifa.eserviceapplication.screen.hrd.FormIzinActivity
import com.projectassyifa.eserviceapplication.screen.hrd.UploadBerkas
import com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti.StatusCutiPage
import com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti.StatusIzinPage
import com.projectassyifa.eserviceapplication.screen.login.LoginFragment
import com.projectassyifa.eserviceapplication.screen.ruangrapat.AddSchedule
import com.projectassyifa.eserviceapplication.screen.ruangrapat.MeetingRoom
import dagger.Component

@Component(modules = [NetworkModul::class])
interface ApplicationComponent {

fun inject(loginFragment: LoginFragment)
fun inject(assesmentCovidActivity: AssesmentCovidActivity)
fun inject(questionCovidAdapter: QuestionCovidAdapter)
fun inject(formIzinActivity: FormIzinActivity)
fun inject(formCutiActivity: FormCutiActivity)
fun inject(statusIzinPage: StatusIzinPage)
fun inject(statusCutiPage: StatusCutiPage)
fun inject(berkasPegawaiActivity: BerkasPegawaiActivity)
fun inject(uploadBerkas: UploadBerkas)
fun inject(meetingRoom: MeetingRoom)
fun inject(addSchedule: AddSchedule)
}