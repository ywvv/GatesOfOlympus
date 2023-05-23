package com.example.casinotestapp

import com.example.casinotestapp.databinding.ActivityGameBinding

class Bet(binding: ActivityGameBinding) {

    private var bet = 10
    private val textBet = binding.textBet

    fun changeBet(num: Int) {
        bet += num
    }

    fun changeBetText() {
        textBet.text = bet.toString()
    }

    fun getBet() = bet
}