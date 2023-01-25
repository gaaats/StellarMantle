package com.artifexmundi.bal.vieevmod

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.artifexmundi.bal.apppi.CountryCodeJSOIJJIJ
import com.artifexmundi.bal.apppi.CountryRepo
import com.artifexmundi.bal.apppi.DevRepo
import com.artifexmundi.bal.apppi.GeoDev
import com.artifexmundi.bal.otther.Utilgtgtgt.appsKegttgy
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import io.branch.referral.util.BRANCH_STANDARD_EVENT
import io.branch.referral.util.BranchEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViModgtgtgtgt(
    private val hyhyhy: CountryRepo,
    private val devRepohyhyhy: DevRepo,
    private val shPhyyhhy: SharedPreferences,
    val hyhyhyhy: Application
) : ViewModel() {



    private val gttggtgtgt = MutableLiveData<CountryCodeJSOIJJIJ>()
    val hy2yh26hy62hy: LiveData<CountryCodeJSOIJJIJ>
        get() = gttggtgtgt

    private val _geogt2gt2gt = MutableLiveData<GeoDev>()
    val geogtgtgt: LiveData<GeoDev>
        get() = _geogt2gt2gt

    private val _appsDatatggtgt3 = MutableLiveData<String>()
    val gtgtgt: LiveData<String>
        get() = _appsDatatggtgt3

    init {
        viewModelScope.launch(Dispatchers.IO) {
            gthy5hy5hyyh56hy()
        }
        viewModelScope.launch(Dispatchers.Main) {
            gt62tgt()
        }
    }

    private val _mainIdtgtgtgt = MutableLiveData<String?>()
    val mainIdgttggt2: LiveData<String?>
        get() = _mainIdtgtgtgt


    suspend fun gt62tgt() {
        gttggtgtgt.postValue(hyhyhy.getDathyhyhy().body())
        gttggtgtgt()
    }



    fun gt2gttgtg2(cont: Context) {
        AppsFlyerLib.getInstance()
            .init(appsKegttgy, gt2gt26gt65tg, hyhyhyhy)
        AppsFlyerLib.getInstance().start(cont)
    }

    fun gtgtgtgtgt(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
                shPhyyhhy.edit().putString("deepSt", deepData).apply()
            }
        }
    }

    suspend fun gttggtgtgt() {
        val res = devRepohyhyhy.hyyhhyyhhy().body()!!
        _geogt2gt2gt.postValue(res)
        Log.d("lolo", "getDevData ${res}")
    }

    private val gt2gt26gt65tg = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val gt662gt = data?.get("campaign").toString()
            _appsDatatggtgt3.postValue(gt662gt)

            when (data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()) {
                "ACI_Search" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL).setDescription("ACI_Search")
                        .logEvent(hyhyhyhy.applicationContext)

                }
                "ACI_Youtube" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.SHARE).setDescription("ACI_Youtube")
                        .logEvent(hyhyhyhy.applicationContext)


                }
                "ACI_Display" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.RATE).setDescription("ACI_Display")
                        .logEvent(hyhyhyhy.applicationContext)

                }

                else -> {

                    BranchEvent(BRANCH_STANDARD_EVENT.VIEW_AD).setDescription("NoChannel")
                        .logEvent(hyhyhyhy.applicationContext)
                    Log.d("Branch Check", "I'm here, branch bitch! No source though")
                }

            }

        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(error: String?) {
        }
    }


    fun gthy5hy5hyyh56hy() {
        val gttgmgtjoigtoijgt = AdvertisingIdClient(hyhyhyhy)
        gttgmgtjoigtoijgt.start()
        val tjogtjigtjgt = gttgmgtjoigtoijgt.info.id.toString()
        _mainIdtgtgtgt.postValue(tjogtjigtjgt)
    }

}