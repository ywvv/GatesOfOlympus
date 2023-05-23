package com.example.casinotestapp

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.casinotestapp.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var lines: Lines
    private lateinit var bet: Bet
    private lateinit var score: Score
    private lateinit var holders: Holders
    private lateinit var buttons: Buttons
    private val imageList = ImageList()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lines = Lines(binding)
        bet = Bet(binding)
        score = Score(binding)
        holders = Holders(this, binding)
        buttons = Buttons(this, binding)


        lines.showLine()
        imageList.fillImageList()
        holders.setupHolders(imageList)
        buttons.setListeners(imageList, holders)
    }
}