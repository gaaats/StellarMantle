package com.artifexmundi.bal.fffragg

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artifexmundi.bal.R
import com.artifexmundi.bal.vieevmod.ViModgtgtgtgt
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class MaiiinnniFragment : Fragment() {
    private lateinit var hyhyhyhyhy: Context

    val bhnujuujuj by activityViewModel<ViModgtgtgtgt>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maiiinnni, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hyhyhyhyhy=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bhnujuujuj.gtgtgtgtgt(hyhyhyhyhy)

        fuggfrugyrf()

    }

    private fun fuggfrugyrf() {
        findNavController().navigate(R.id.action_maiiinnniFragment_to_cityFragment)
    }
}