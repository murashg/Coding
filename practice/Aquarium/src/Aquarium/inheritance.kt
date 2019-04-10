//package Aquarium

fun main(args: Array<String>){
    delegate()
}
fun delegate(){
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
    val redPleco = Plecostomus(RedColor)
    println("RedPleco has color ${redPleco.color}")
    redPleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus(fishColor: FishColor = GoldColor):
        FishColor by fishColor,
        FishAction by PrintingFishAction(food = "a lot of algae")

//create a single instance of a class "Singleton"
object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}