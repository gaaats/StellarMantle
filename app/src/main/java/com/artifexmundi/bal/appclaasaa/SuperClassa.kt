package com.artifexmundi.bal.appclaasaa

import android.app.Application
import android.content.Context
import com.artifexmundi.bal.depinj.appModule
import com.artifexmundi.bal.depinj.viewModelModule
import com.artifexmundi.bal.otther.Util.ONESIGNAL_APP_ID
import com.artifexmundi.bal.otther.Util.instId
import com.artifexmundi.bal.otther.Util.mtKey
import com.artifexmundi.bal.otther.Util.myId
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class SuperClassa:Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        Branch.enableTestMode()
        Branch.getAutoInstance(this)

        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (settings.getBoolean("my_first_time", true)) {
            trackerParams.setCustomUserId(IDIN)
            shP.edit().putString(myId, IDIN).apply()
            shP.edit().putString(instId, instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDIN = shP.getString(myId, IDIN)
            trackerParams.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker(mtKey, this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SuperClassa)
            modules(
                listOf(
                    viewModelModule, appModule
                )
            )
        }
    }
}