package com.example.diceroll

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rollButtonMA: Button = findViewById(R.id.button_AM)
        rollButtonMA.setOnClickListener{
            rollDiceMA()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun rollDiceMA() {
        val diceMA = DiceMA(6)
        val dice2 = DiceMA(6)
        val cubeRoll = diceMA.rollMA()
        val cubeRoll2 = dice2.rollMA()

        val diceImage = findViewById<ImageView>(R.id.imageView)
        val diceImage2 = findViewById<ImageView>(R.id.imageView2)
        val dice1ResultText = findViewById<TextView>(R.id.dice1Result)
        val dice2ResultText = findViewById<TextView>(R.id.dice2Result)

        when (cubeRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            6 -> diceImage.setImageResource(R.drawable.dice6)
        }
        when (cubeRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice1)
            2 -> diceImage2.setImageResource(R.drawable.dice2)
            3 -> diceImage2.setImageResource(R.drawable.dice3)
            4 -> diceImage2.setImageResource(R.drawable.dice4)
            5 -> diceImage2.setImageResource(R.drawable.dice5)
            6 -> diceImage2.setImageResource(R.drawable.dice6)

        }

    dice1ResultText.text = cubeRoll.toString()
    dice2ResultText.text = cubeRoll2.toString()
    }
    class DiceMA (val numSidesMA: Int){
        fun rollMA(): Int {
            return (1..numSidesMA).random()
        }
    }
}

