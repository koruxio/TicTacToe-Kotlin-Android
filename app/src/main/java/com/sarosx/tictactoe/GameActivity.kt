package com.sarosx.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Trace.isEnabled
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun buttonClick (view: View) {
        val buttonSelected = view as Button
        var selectedCell = 0

        when(buttonSelected.id){
            R.id.button1 -> selectedCell = 1
            R.id.button2 -> selectedCell = 2
            R.id.button3 -> selectedCell = 3
            R.id.button4 -> selectedCell = 4
            R.id.button5 -> selectedCell = 5
            R.id.button6 -> selectedCell = 6
            R.id.button7 -> selectedCell = 7
            R.id.button8 -> selectedCell = 8
            R.id.button9 -> selectedCell = 9
        }
        playGame(selectedCell, buttonSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(selectedCell: Int, buttonSelected: Button) {
        if(activePlayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.parseColor("#F8A901"))
            player1.add(selectedCell)
            activePlayer = 2
        }
        else {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.parseColor("#088CF3"))
            player2.add(selectedCell)
            activePlayer = 1
        }
        buttonSelected.isEnabled = false
        checkWinner()

        play_again.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkWinner() {
        var winner = 0

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (winner != 0) {
            if (winner == 1) {
                Toast.makeText(this, "Player1 Won!", Toast.LENGTH_LONG).show()
                disableButton()
            }
            if (winner == 2){
                Toast.makeText(this, "Player2 Won!", Toast.LENGTH_LONG).show()
                disableButton()
            }
        }
    }

    private fun disableButton() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
}