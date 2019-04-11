package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.Random
import android.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //views should be singleton for efficiency
    private lateinit var binding: ActivityMainBinding
    private val rollHistory = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //onClickListeners
        binding.apply {
            rollButton.setOnClickListener {
                rollDice()
            }
            //implement clear button functionality
            resetButton.setOnClickListener {
                rollHistory.clear()
                rollList.text = getString(R.string.roll_list)
                rollSum.text = getString(R.string.sum_text)
            }
        }
    }

    private fun rollDice() {
        //roll dice and add to list
        val roll = Random().nextInt(6) + 1
        rollHistory.add(roll)
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
        binding.apply {
            diceImage.setImageResource(drawableResource)
            rollList.text = rollHistory.toString()
            rollSum.text = rollHistory.sum().toString()
        }
    }
}
