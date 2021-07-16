package com.projectassyifa.eserviceapplication.container


import com.projectassyifa.eserviceapplication.data.assesmentCovid19.adapter.QuestionCovidAdapter
import com.projectassyifa.eserviceapplication.screen.covid.AssesmentCovidActivity
import com.projectassyifa.eserviceapplication.screen.hrd.FormIzinActivity
import com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti.StatusIzinPage
import com.projectassyifa.eserviceapplication.screen.login.LoginFragment
import dagger.Component

@Component(modules = [NetworkModul::class])
interface ApplicationComponent {

fun inject(loginFragment: LoginFragment)
fun inject(assesmentCovidActivity: AssesmentCovidActivity)
fun inject(questionCovidAdapter: QuestionCovidAdapter)
fun inject(formIzinActivity: FormIzinActivity)
fun inject(statusIzinPage: StatusIzinPage)
}