package com.artifexmundi.bal.vieevmod

import android.app.Application
import android.content.pm.PackageManager
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.ViewModel
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject

class BeamModelgtgttg(application: Application): ViewModel() {

    fun gtjiogtgtihfryugrf(uri: String): Boolean {
        try {
            hghyhyhyhy.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (_: PackageManager.NameNotFoundException) {

        }
        return false
    }

    val hghyhyhyhy = application.packageManager
    fun jujkiik5(webView: WebView): WebSettings{
       val hy5yh5hy5hy = webView.settings
        hy5yh5hy5hy.javaScriptEnabled = true
        hy5yh5hy5hy.useWideViewPort = true
        hy5yh5hy5hy.loadWithOverviewMode = true
        hy5yh5hy5hy.allowFileAccess = true
        hy5yh5hy5hy.domStorageEnabled = true
        hy5yh5hy5hy.userAgentString = hy5yh5hy5hy.userAgentString.replace("; wv", "")
        hy5yh5hy5hy.javaScriptCanOpenWindowsAutomatically = true
        hy5yh5hy5hy.setSupportMultipleWindows(false)
        hy5yh5hy5hy.displayZoomControls = false
        hy5yh5hy5hy.builtInZoomControls = true
        hy5yh5hy5hy.allowFileAccess = true
        hy5yh5hy5hy.allowContentAccess = true
        hy5yh5hy5hy.setSupportZoom(true)
        hy5yh5hy5hy.pluginState = WebSettings.PluginState.ON
        hy5yh5hy5hy.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        hy5yh5hy5hy.cacheMode = WebSettings.LOAD_DEFAULT
        hy5yh5hy5hy.allowContentAccess = true
        hy5yh5hy5hy.mediaPlaybackRequiresUserGesture = false
        return hy5yh5hy5hy
    }
    fun juuj5uj5uj(hyhyyh: String) {
        OneSignal.setExternalUserId(
            hyhyyh,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val hyjuujkujok = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $hyjuujkujok"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val gtjgiunvtbght =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $gtjgiunvtbght"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val cvdedftye = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $cvdedftye"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }




}