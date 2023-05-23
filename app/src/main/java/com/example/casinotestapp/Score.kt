package com.example.casinotestapp

import com.example.casinotestapp.databinding.ActivityGameBinding

class Score(binding: ActivityGameBinding) {

    private var score = 1_000_00
    private val textScore = binding.textScore

    fun changeScore(bet: Int, lines: Int) {
        score -= bet * lines
        textScore.text = score.toString()
    }
}