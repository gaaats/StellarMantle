package com.artifexmundi.bal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.artifexmundi.bal.databinding.FragmentBlank3Binding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlin.random.Random


class Blank3Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBlank3Binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            binding.btnThovDice.setOnClickListener {
                val numm = Random.nextInt(from = 500, until = 5000)
                lifecycleScope.launchWhenCreated {
                    binding.btnThovDice.isEnabled = false
                    Toast.makeText(requireContext(), "You ear $numm points!", Toast.LENGTH_SHORT).show()
                    delay(2500)
                    binding.btnThovDice.isEnabled = true
                }
            }



        } catch (e: Exception) {
            edfrgtysnackBarError()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        fragmentBlank3Binding = null
        super.onDestroyView()
    }

    private var fragmentBlank3Binding: FragmentBlank3Binding? = null
    private val binding get() = fragmentBlank3Binding ?: throw RuntimeException("FragmentBlank3Binding = null")

    private fun edfrgtysnackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}