package com.artifexmundi.bal.fffragg

import com.artifexmundi.bal.R
import com.artifexmundi.bal.otther.Utilgtgtgt.geoCoggt
import com.artifexmundi.bal.vieevmod.ViModgtgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class CityFragment : Fragment() {
    private lateinit var hyujujujuj: Context


    val hyyhhyhyhy: SharedPreferences by inject(named("SharedPreferences"))
    val vfbgbgbbg by activityViewModel<ViModgtgtgtgt>(named("MainModel"))

    lateinit var country: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        hyujujujuj = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vfbgbgbbg.hy2yh26hy62hy.observe(viewLifecycleOwner) {
            if (it!=null) {
                country = it.hyjuujujuj
                hyyhhyhyhy.edit().putString(geoCoggt, country).apply()
                gthgthiugtugt()
            }
        }
    }

    private fun gthgthiugtugt() {
        findNavController().navigate(R.id.action_cityFragment_to_secMaiiinFragment)
    }
}