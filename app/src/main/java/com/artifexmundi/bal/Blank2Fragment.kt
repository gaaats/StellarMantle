package com.artifexmundi.bal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.artifexmundi.bal.databinding.FragmentBlank2Binding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class Blank2Fragment : Fragment() {


    private var _binding: FragmentBlank2Binding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentBlank2Binding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {

            rfrgtyhyyju538()
            dfeghjk()
            binding.btnGoSpin.setOnClickListener {
                if (!hyjuujuj) {
                    frghj()
                    hyjuujuj = true
                }
            }

        } catch (e: Exception) {
            fgthyhy555()
        }

        super.onViewCreated(view, savedInstanceState)
    }


    var hyyjuuj = 0.05f
    var huikikikik = 0.05f

    var frgtgttgtt = false

    private val hyyhjuujuj = arrayOf(256, 255, 278, 125, 869)
    private val hujuujujuj = hyyhjuujuj.clone()
    private val hyyhjuujju = 360 / hyyhjuujuj.size
    private var hyjuujuj = false

    private fun frghj() {
        val winnerNumber = Random.nextInt(hyyhjuujuj.size - 1)

        val yhyhyhyhy = (360 - winnerNumber * hyyhjuujju).toFloat()
        val hyhyjiohyjhy = RotateAnimation(
            0f,
            (360f * hyyhjuujuj.size) + yhyhyhyhy,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        hyhyjiohyjhy.apply {
            duration = 1000
            fillAfter = true
            interpolator = DecelerateInterpolator()
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    val edfrgthjk = hyyhjuujuj[winnerNumber]
                    Toast.makeText(
                        requireContext(),
                        "You winn $edfrgthjk$ points",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    hyjuujuj = false
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            binding.imgWheelElementMain.startAnimation(hyhyjiohyjhy)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun dfeghjk() {
        for (i in hyyhjuujuj.indices) {
            hujuujujuj[i] = (i + 1) * hyyhjuujju
        }
    }

    private fun rfrgtyhyyju538() {
        if (!frgtgttgtt){
            lifecycleScope.launch {
                frgtgttgtt = !frgtgttgtt
                while (true) {
                    binding.btnGoSpin.alpha = hyyjuuj
                    if (hyyjuuj >= 1f) {
                        huikikikik = -0.05f
                    }
                    if (hyyjuuj <= 0.1f) {
                        huikikikik = 0.05f
                    }
                    delay(20)
                    hyyjuuj += huikikikik
                }
            }

        }

    }

    private fun fgthyhy555() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}