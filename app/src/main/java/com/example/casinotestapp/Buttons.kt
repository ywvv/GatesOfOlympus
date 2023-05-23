package com.example.casinotestapp

import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import com.example.casinotestapp.databinding.ActivityGameBinding

class Buttons(
    private val activity: GameActivity,
    private val binding: ActivityGameBinding
) {
    private val buttons = listOf(
        binding.btnLinesPlus,
        binding.btnLinesMinus,
        binding.btnBetPlus,
        binding.btnBetMinus,
        binding.btnSpin
    )

    private val lines = Lines(binding)
    private val bet = Bet(binding)
    private val score = Score(binding)
    private val animator = Animator()


    @RequiresApi(Build.VERSION_CODES.Q)
    fun setListeners(imageList: ImageList, holders: Holders) = with(binding) {
        val vibrator = activity.getSystemService(Vibrator::class.java)

        buttons.forEach { button ->
            button.setOnClickListener {
                if (it !== btnSpin) {
                    animator.animateButton(button)
                }
                vibrate(vibrator)

                when (button) {
                    btnLinesPlus -> {
                        if (lines.getLines() < 5) {
                            lines.changeLines(1)
                            lines.changeLinesText()
                        }
                        lines.showLine()
                    }

                    btnLinesMinus -> {
                        if (lines.getLines() > 1) {
                            lines.changeLines(-1)
                            lines.changeLinesText()
                        }
                        lines.hideLine(lines.getLines())
                    }

                    btnBetPlus -> {
                        if (bet.getBet() < 100) {
                            bet.changeBet(10)
                            bet.changeBetText()
                        }
                    }

                    btnBetMinus -> {
                        if (bet.getBet() > 10) {
                            bet.changeBet(-10)
                            bet.changeBetText()
                        }
                    }

                    btnSpin -> {
                        lines.hideLines()
                        animator.animateButtonsOnSpinStart(buttons)
                        disableButtons()

                        imageList.clearImageList()

                        holders.scrollHolders(imageList, lines, this@Buttons)

                        score.changeScore(bet.getBet(), lines.getLines())
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun vibrate(vibrator: Vibrator) {
        vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_TICK))
    }

    private fun disableButtons() {
        buttons.forEach { it.isEnabled = false }
    }

    fun enableButtons() {
        buttons.forEach { it.isEnabled = true }
    }

    fun getButtons() = buttons
}