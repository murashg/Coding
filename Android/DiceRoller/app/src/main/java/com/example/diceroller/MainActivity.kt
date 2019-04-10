package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    //views should be singleton for efficiency
    private lateinit var diceImage: ImageView
    private lateinit var rollListView: TextView
    private lateinit var rollSumView: TextView
    private val rollList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init buttons and views
        val rollButton: Button = findViewById(R.id.roll_button)
        val resetButton: Button = findViewById(R.id.clear_button)
        diceImage = findViewById(R.id.dice_image)
        rollListView = findViewById(R.id.roll_list)
        rollSumView = findViewById(R.id.roll_sum)

        //onClickListeners
        rollButton.setOnClickListener {
            rollDice()
        }
        //implement reset button functionality
        resetButton.setOnClickListener {
            rollList.clear()
            rollListView.text = getString(R.string.roll_list)
            rollSumView.text = getString(R.string.sum_text)
        }
    }

    private fun rollDice() {
        //roll dice and add to list
        val roll = Random().nextInt(6) + 1
        rollList.add(roll)
        //choose image to display
        val drawableResource = when(roll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //refresh views
        diceImage.setImageResource(drawableResource)
        rollListView.text = rollList.toString()
        rollSumView.text = rollList.sum().toString()
    }
}
