package com.example.thecoralconche.Objects

import java.util.*

object Dice {
    fun roll(d: Int, num: Int) {
        var sum = 0
        repeat(num){Random().nextInt(d)+1}
    }
}

enum class Dices{
    d2, d3, d4, d6, d8, d12, d20, d100
}
