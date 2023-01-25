package com.artifexmundi.bal.appclaasaa

import android.app.Application
import android.content.Context
import com.artifexmundi.bal.depinj.tggtuihgtuhtghgt
import com.artifexmundi.bal.depinj.hyjubcehbedbeed
import com.artifexmundi.bal.otther.Utilgtgtgt.ONESIGNAL_APP_IDhhy
import com.artifexmundi.bal.otther.Utilgtgtgt.instIdgtgtg
import com.artifexmundi.bal.otther.Utilgtgtgt.mtKeygttg
import com.artifexmundi.bal.otther.Utilgtgtgt.hyhyhyhy
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
        OneSignal.setAppId(ONESIGNAL_APP_IDhhy)
        gtkpktgktgjojtjigt()
        Branch.getAutoInstance(this)

        val hujujujik = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val jujuujujuj = getSharedPreferences("PREFS_NAME", 0)

        val ujikikiikik = MyTracker.getTrackerParams()
        val hyjuikikikik = MyTracker.getTrackerConfig()
        val instIDhy2hyhy = MyTracker.getInstanceId(this)
        hyjuikikikik.isTrackingLaunchEnabled = true
        val IDINhy = UUID.randomUUID().toString()

        if (jujuujujuj.getBoolean("my_first_time", true)) {
            ujikikiikik.setCustomUserId(IDINhy)
            hujujujik.edit().putString(hyhyhyhy, IDINhy).apply()
            hujujujik.edit().putString(instIdgtgtg, instIDhy2hyhy).apply()
            jujuujujuj.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDIN = hujujujik.getString(hyhyhyhy, IDINhy)
            ujikikiikik.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker(mtKeygttg, this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SuperClassa)
            modules(
                listOf(
                    hyjubcehbedbeed, tggtuihgtuhtghgt
                )
            )
        }
    }

    private fun gtkpktgktgjojtjigt() {
        Branch.enableTestMode()
    }
}