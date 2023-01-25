package com.artifexmundi.bal.depinj

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.artifexmundi.bal.apppi.ApiInterface
import com.artifexmundi.bal.apppi.CountryRepo
import com.artifexmundi.bal.apppi.DevRepo
import com.artifexmundi.bal.apppi.HostInterface
import com.artifexmundi.bal.vieevmod.BeamModelgtgttg
import com.artifexmundi.bal.vieevmod.ViModgtgtgtgt
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





fun hyjuujujju(): Gson {
    return GsonBuilder().create()
}

val hyjubcehbedbeed = module {
    viewModel (named("MainModel")){
        ViModgtgtgtgt((get(named("CountryRep"))), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
    viewModel(named("BeamModel")) {
        BeamModelgtgttg(get())
    }
}

fun hujuujujujuj(app: Application): SharedPreferences {
    return app.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}

val tggtuihgtuhtghgt = module {

    single  <HostInterface> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(HostInterface::class.java)
    }

    single <ApiInterface> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(ApiInterface::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://stellarmantle.fun/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        CountryRepo(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        DevRepo(get(named("HostInter")))
    }
    single{
        hyjuujujju()
    }
    single (named("SharedPreferences")) {
        hujuujujujuj(androidApplication())
    }
}