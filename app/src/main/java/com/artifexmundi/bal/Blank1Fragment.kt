package com.artifexmundi.bal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artifexmundi.bal.databinding.FragmentBlank1Binding
import com.google.android.material.snackbar.Snackbar


class Blank1Fragment : Fragment() {

    private var fragmentBlank1Binding: FragmentBlank1Binding? = null
    private val binding get() = fragmentBlank1Binding ?: throw RuntimeException("FragmentBlank1Binding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBlank1Binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            binding.root.background.alpha = 230

            binding.btnVhel.setOnClickListener {
                findNavController().navigate(R.id.action_blank1Fragment_to_blank2Fragment)
            }
            binding.btnDice.setOnClickListener {
                findNavController().navigate(R.id.action_blank1Fragment_to_blank3Fragment)
            }

        } catch (e: Exception) {
            edfrgtysnackBarError()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        fragmentBlank1Binding = null
        super.onDestroyView()
    }

    private fun edfrgtysnackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}