package com.projectassyifa.eserviceapplication.container


import com.projectassyifa.eserviceapplication.config.Connect
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.api.QuestionCovidAPI
import com.projectassyifa.eserviceapplication.data.hrd.api.*
import com.projectassyifa.eserviceapplication.data.login.api.UserLoginAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModul {
    @Provides
    fun provideUserLoginAPI(): UserLoginAPI {
        return Connect.urlLogin().create(UserLoginAPI::class.java)
    }
    @Provides
    fun provideQuestionCovidAPI(): QuestionCovidAPI {
        return Connect.urlGlobal().create(QuestionCovidAPI::class.java)
    }
    @Provides
    fun provideStatusAktifAPI(): StatusAktifAPI {
        return Connect.urlGlobal().create(StatusAktifAPI::class.java)
    }
    @Provides
    fun provideJenisPegawaiAPI(): JenisPegawaiAPI {
        return Connect.urlGlobal().create(JenisPegawaiAPI::class.java)
    }
    @Provides
    fun provideAlasanCutiAPI(): AlasanCutiAPI {
        return Connect.urlGlobal().create(AlasanCutiAPI::class.java)
    }
    @Provides
    fun provideFungsionalAPI(): FungsionalAPI {
        return Connect.urlGlobal().create(FungsionalAPI::class.java)
    }
    @Provides
    fun provideStrukturalAPI(): StrukturalAPI {
        return Connect.urlGlobal().create(StrukturalAPI::class.java)
    }
    @Provides
    fun provideFormIzinAPI(): FormIzinHrdAPI {
        return Connect.urlGlobal().create(FormIzinHrdAPI::class.java)
    }
    @Provides
    fun provideStatusIzinAPI(): StatusIzinAPI {
        return Connect.urlGlobal().create(StatusIzinAPI::class.java)
    }
}