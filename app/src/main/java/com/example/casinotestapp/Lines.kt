package com.example.casinotestapp

import com.example.casinotestapp.databinding.ActivityGameBinding

class Lines(private val binding: ActivityGameBinding) {
    private var lines = 1
    private val textLines = binding.textLines
    private val linesList = listOf(
        binding.line1,
        binding.line2,
        binding.line3,
        binding.line4,
        binding.line5,
    )

    fun showLine() {
        when (lines) {
            1 -> Animator().animateShowLine(binding.line1)
            2 -> Animator().animateShowLine(binding.line2)
            3 -> Animator().animateShowLine(binding.line3)
            4 -> Animator().animateShowLine(binding.line4)
            5 -> Animator().animateShowLine(binding.line5)
        }
    }

    fun hideLine(lines: Int) {
        when (lines) {
            1 -> Animator().animateHideLine(binding.line2)
            2 -> Animator().animateHideLine(binding.line3)
            3 -> Animator().animateHideLine(binding.line4)
            4 -> Animator().animateHideLine(binding.line5)
        }
    }

    fun hideLines() {
        Animator().animateHideLines(linesList)
    }

    fun showLines() {
        Animator().animateShowLines(linesList, lines)
    }

    fun changeLines(num: Int) {
        lines += num
    }

    fun getLines() = lines

    fun changeLinesText() {
        textLines.text = lines.toString()
    }
}