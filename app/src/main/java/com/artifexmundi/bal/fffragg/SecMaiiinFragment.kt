package com.artifexmundi.bal.fffragg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artifexmundi.bal.R
import com.artifexmundi.bal.otther.Utilgtgtgt
import com.artifexmundi.bal.otther.Utilgtgtgt.codeCode
import com.artifexmundi.bal.otther.Utilgtgtgt.urlMainghyyh
import com.artifexmundi.bal.vieevmod.ViModgtgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class SecMaiiinFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        gt3tg2t6gt5gt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sec_maiiin, container, false)
    }

    val hyhyhyhy by activityViewModel<ViModgtgtgtgt>(named("MainModel"))
    lateinit var hyjukiikik2: String
    lateinit var hy2hyhy65yh8: String
    lateinit var hy2yhhyhy: String
    private lateinit var gt3tg2t6gt5gt: Context

    val shareP: SharedPreferences by inject(named("SharedPreferences"))



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hyhyhyhy.mainIdgttggt2.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                shareP.edit().putString("mainId", main).apply()
            }
        }

        hyhyhyhy.geogtgtgt.observe(viewLifecycleOwner) {
            if (it != null) {

                hyjukiikik2 = it.jukiik
                hy2yhhyhy = it.hujukiikoloolol
                hy2hyhy65yh8 = it.hujjiujuj

                shareP.edit().putString(codeCode, hyjukiikik2).apply()
                shareP.edit().putString(Utilgtgtgt.appsfrfrrfrf, hy2yhhyhy).apply()
                shareP.edit().putString(urlMainghyyh, hy2hyhy65yh8).apply()

                gtotghgthigtht()
            }
        }
    }

    private fun gtotghgthigtht() {
        findNavController().navigate(R.id.action_secMaiiinFragment_to_prefiilFragment)
    }
}