package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/** This activity allows users to roll a dice and view the result on the screen */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Set on click listener to trigger the rollDice() function
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /** Roll the dice and get the updated number on the screen */
    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
    //Create a second new dice with 6 sides and roll it.
        val dice2 = Dice(6)

        //Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = dice.roll().toString()
    //Added second textview for second dice roll.
        val resultTextView3: TextView = findViewById(R.id.textView3)
        resultTextView3.text = dice2.roll().toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}