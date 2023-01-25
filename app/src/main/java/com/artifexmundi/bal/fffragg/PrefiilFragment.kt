package com.artifexmundi.bal.fffragg


import android.view.ViewGroup
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.artifexmundi.bal.R
import com.artifexmundi.bal.otther.Utilgtgtgt.appsfrfrrfrf
import com.artifexmundi.bal.vieevmod.ViModgtgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class PrefiilFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkFly = nkvfbrfbrfggrfy.getString(appsfrfrrfrf, null)
        val appsCamp = nkvfbrfbrfggrfy.getString("appCamp", null)

        if (checkFly=="1" &&appsCamp == null) {
            ttjiojtg.gt2gttgtg2(gnknngnjbg)
            ttjiojtg.gtgtgt.observe(viewLifecycleOwner) {
                if (it != null) {
                    gmtoijhj = it.toString()
                    nkvfbrfbrfggrfy.edit().putString("appCamp", gmtoijhj).apply()
                    findNavController().navigate(R.id.action_prefiilFragment_to_filllFragment)
                }
            }
        } else {
            findNavController().navigate(R.id.action_prefiilFragment_to_filllFragment)
        }
    }


    val ttjiojtg by activityViewModel<ViModgtgtgtgt>(named("MainModel"))
    val nkvfbrfbrfggrfy: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var gmtoijhj: String
    private lateinit var gnknngnjbg: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gnknngnjbg = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prefiil, container, false)
    }



}