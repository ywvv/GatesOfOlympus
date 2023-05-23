package com.example.casinotestapp

import android.view.View

class Animator {

    fun animateButtonsOnSpinStart(buttons: List<View>) {
        buttons.forEach {
            it.animate().apply {
                duration = 200
                scaleX(0.95f)
                scaleY(0.95f)
            }
        }
    }

    fun animateButtonsOnSpinEnd(buttons: List<View>) {
        buttons.forEach {
            it.animate().apply {
                duration = 200
                scaleX(1f)
                scaleY(1f)
            }
        }
    }

    fun animateButton(button: View) {
        button.animate().apply {
            duration = 200
            scaleX(0.95f)
            scaleY(0.95f)
        }.withEndAction {
            button.animate().apply {
                duration = 200
                scaleX(1f)
                scaleY(1f)
            }
        }
    }

    fun animateShowLine(line: View) {
        line.animate().alpha(1f).duration = 200
    }

    fun animateHideLine(line: View) {
        line.animate().alpha(0.0f).duration = 100
    }

    fun animateShowLines(linesList: List<View>, lines: Int) {
        linesList.forEachIndexed { i, line ->
            if (i < lines) {
                line.animate().alpha(1f).duration = 200
            }
        }
    }

    fun animateHideLines(linesList: List<View>) {
        linesList.forEach {
            it.animate().alpha(0.0f).duration = 100
        }
    }
}