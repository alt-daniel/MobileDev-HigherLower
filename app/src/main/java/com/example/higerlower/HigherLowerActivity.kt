package com.example.higerlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    /**
     * Sets up the first state of User Interface and adds listeners.
     */
    private fun initViews() {
        btnHigher.setOnClickListener { onHigherClick() }
        btnEqual.setOnClickListener { onEqualClick() }
        btnLower.setOnClickListener { onLowerClick() }
        updateUI()
    }


    /**
     * Updates image based on the last throw
     */
    private fun updateUI() {
        txtLastThrow.text = getString(R.string.txtLastThrow, lastThrow)

        when (currentThrow) {
            1 -> imgDice.setImageResource(R.drawable.dice1)
            2 -> imgDice.setImageResource(R.drawable.dice2)
            3 -> imgDice.setImageResource(R.drawable.dice3)
            4 -> imgDice.setImageResource(R.drawable.dice4)
            5 -> imgDice.setImageResource(R.drawable.dice5)
            6 -> imgDice.setImageResource(R.drawable.dice6)
        }

    }

    /**
     * Returns a number between 1 and 6.
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls rollDice() and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls rollDice() and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls rollDice() and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }


    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }


}
