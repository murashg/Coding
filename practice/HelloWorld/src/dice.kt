import java.util.*

fun main(args:Array<String>){
    println(rollDice(null))
    gamePlay(rollDice(4))
}
val rollDice = {sides : Int? ->
    if (sides == 0) 0
    else Random().nextInt(sides?:12) + 1
}

fun gamePlay(diceRoll : Int){
    println(diceRoll)
}