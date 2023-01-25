package com.artifexmundi.bal.vieevmod

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.artifexmundi.bal.databinding.ActivityVebbbbBinding
import com.artifexmundi.bal.otther.Utilgtgtgt.aps_idgtgt
import com.artifexmundi.bal.otther.Utilgtgtgt.linkaagttgtg
import com.artifexmundi.bal.otther.Utilgtgtgt.hyhyhyhy
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class VebbbbActivity : AppCompatActivity() {





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != gtjgtjgtji || gjgtjgtjgt == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var hyjuujuj2ju2: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (gjitjgtjigt != null) {
                    hyjuujuj2ju2 = arrayOf(Uri.parse(gjitjgtjigt))
                }
            } else {
                val hyjuujujuj = data.dataString
                if (hyjuujujuj != null) {
                    hyjuujuj2ju2 = arrayOf(Uri.parse(hyjuujujuj))
                }
            }
        }
        gjgtjgtjgt!!.onReceiveValue(hyjuujuj2ju2)
        gjgtjgtjgt = null
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gtjtgigtji = ActivityVebbbbBinding.inflate(layoutInflater)
        gtjgtgtjigt = WebView(this)
        setContentView(gtjgtgtjigt)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(gtjgtgtjigt, true)
        bnngkjbgng.jujkiik5(gtjgtgtjigt)

        gtjgtgtjigt.webViewClient = CustomView()
        gtjgtgtjigt.webChromeClient = ChromeClientggtgt()
        gtjgtgtjigt.loadUrl(vfbvfbhfvbvf())
    }

    inner class CustomView: WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
            try {
                if (URLUtil.isNetworkUrl(url)) {
                    return false
                }
                if (bnngkjbgng.gtjiogtgtihfryugrf(url)) {

                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                } else {

                    Toast.makeText(
                        applicationContext,
                        "Application is not installed",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                        )
                    )
                }
                return true
            } catch (e: Exception) {
                return false
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            gtjigtjitgogt(url)
        }


        override fun onReceivedError(
            view: WebView?,
            errorCode: Int,
            description: String?,
            failingUrl: String?
        ) {
            Toast.makeText(this@VebbbbActivity, description, Toast.LENGTH_SHORT).show()
        }
    }


    private lateinit var gtjtgigtji: ActivityVebbbbBinding
    lateinit var gtjgtgtjigt: WebView
    private var gjgtjgtjgt: ValueCallback<Array<Uri>>? = null
    private var gjitjgtjigt: String? = null
    private  val gtjgtjgtji = 1

    private val bnngkjbgng by viewModel<BeamModelgtgttg>(
        named("BeamModel")
    )



    inner class ChromeClientggtgt : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            gjgtjgtjgt?.onReceiveValue(null)
            gjgtjgtjgt = filePath
            var gjgthgtiuhgt: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (gjgthgtiuhgt!!.resolveActivity(packageManager) != null) {
                var photoFile: File? = null
                try {
                    photoFile = gthdeededed()
                    gjgthgtiuhgt.putExtra("PhotoPath", gjitjgtjigt)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (photoFile != null) {
                    gjitjgtjigt = "file:" + photoFile.absolutePath
                    gjgthgtiuhgt.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile)
                    )
                } else {
                    gjgthgtiuhgt = null
                }
            }
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            val gtjtgjigt: Array<Intent?> = gjgthgtiuhgt?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val gtjiotgjigt = Intent(Intent.ACTION_CHOOSER)
            gtjiotgjigt.putExtra(Intent.EXTRA_INTENT, intent)
            gtjiotgjigt.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            gtjiotgjigt.putExtra(Intent.EXTRA_INITIAL_INTENTS, gtjtgjigt)
            startActivityForResult(gtjiotgjigt, gtjgtjgtji)
            return true
        }

        fun gthdeededed(): File? {
            val timeStamptggtgt = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileNamegtgt = "JPEG_" + timeStamptggtgt + "_"
            val storageDirgtgtgt = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                imageFileNamegtgt,
                ".jpg",
                storageDirgtgtgt
            )
        }
    }

    private fun vfbvfbhfvbvf(): String {

        val spoongtgt = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)

        val sharPregttggt = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val linkhyhyhy = sharPregttggt.getString(linkaagttgtg, null)
        Log.d("lolo", linkhyhyhy.toString())
        val myTrIdgtgggt = sharPregttggt.getString(hyhyhyhy, null)
        val afIdgttggtgt = sharPregttggt.getString(aps_idgtgt, null)


        when (sharPregttggt.getString("WebInt", null)) {
            "campaign" -> {
                bnngkjbgng.juuj5uj5uj(afIdgttggtgt.toString())
            }
            "deepLink" -> {

                bnngkjbgng.juuj5uj5uj(afIdgttggtgt.toString())
            }
            "deepLinkNOApps" -> {

                bnngkjbgng.juuj5uj5uj(myTrIdgtgggt.toString())
            }
            "geo" -> {
                bnngkjbgng.juuj5uj5uj(myTrIdgtgggt.toString())
            }
        }

        return spoongtgt.getString("SAVED_URL", linkhyhyhy).toString()
    }

    var urlfififif = ""
    fun gtjigtjitgogt(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }
    private var hyhyjuujujf = false
    override fun onBackPressed() {

        if (gtjgtgtjigt.canGoBack()) {
            if (hyhyjuujujf) {
                gtjgtgtjigt.stopLoading()
                gtjgtgtjigt.loadUrl(urlfififif)
            }
            this.hyhyjuujujf = true
            gtjgtgtjigt.goBack()
            Handler(Looper.getMainLooper()).postDelayed({
                hyhyjuujujf = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}

