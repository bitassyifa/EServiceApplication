package com.projectassyifa.eserviceapplication.container


import com.projectassyifa.eserviceapplication.config.Connect
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.api.QuestionCovidAPI
import com.projectassyifa.eserviceapplication.data.hrd.api.*
import com.projectassyifa.eserviceapplication.data.login.api.UserLoginAPI
import com.projectassyifa.eserviceapplication.data.pegawai.api.EmployeeAPI
import com.projectassyifa.eserviceapplication.data.ruangrapat.api.ListRoomAPI
import com.projectassyifa.eserviceapplication.data.ruangrapat.api.MeetingRoomAPI
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
    fun provideAlasanIzinAPI(): AlasanIzinAPI {
        return Connect.urlGlobal().create(AlasanIzinAPI::class.java)
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
    fun provideFormCutiAPI(): FormCutiHrdAPI {
        return Connect.urlGlobal().create(FormCutiHrdAPI::class.java)
    }
    @Provides
    fun provideStatusIzinAPI(): StatusIzinAPI {
        return Connect.urlGlobal().create(StatusIzinAPI::class.java)
    }
    @Provides
    fun provideStatusCutiAPI(): StatusCutiAPI {
        return Connect.urlGlobal().create(StatusCutiAPI::class.java)
    }
    @Provides
    fun provideBerkasAPI(): BerkasAPI{
        return Connect.urlGlobal().create(BerkasAPI::class.java)
    }
    @Provides
    fun provideUploadBerkasAPI1(): UploadBerkasAPI1{
        return Connect.urlGlobal().create(UploadBerkasAPI1::class.java)
    }
    @Provides
    fun provideMeetingRoomAPI(): MeetingRoomAPI {
        return Connect.urlGlobal().create(MeetingRoomAPI::class.java)
    }
    @Provides
    fun provideListRoomAPI(): ListRoomAPI {
        return Connect.urlGlobal().create(ListRoomAPI::class.java)
    }
    @Provides
    fun provideEmployeeAPI(): EmployeeAPI {
        return Connect.url_pegawai().create(EmployeeAPI::class.java)
    }
}