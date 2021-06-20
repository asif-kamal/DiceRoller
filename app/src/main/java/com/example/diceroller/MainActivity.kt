package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rollDice()
    }

    /** Roll the dice and get the updated number on the screen */
    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        //Created second instance of 6 sided dice.
        val dice2Roll = dice2.roll()
        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Find the Imageview for the second dice.
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        /** Determine which drawable resource ID to use based on the dice roll
        Built a second drawable resource for second dice imageview. */
        val drawableResource2 = when (dice2Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        diceImage2.setImageResource(drawableResource2)
        //Update content description.
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = dice2Roll.toString()
       }
    }


class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}