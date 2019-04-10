package Spice

abstract class Spice(val name : String, val spiciness : String = "mild", color: SpiceColor): SpiceColor by color{
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "extreme" -> 7
            else -> 0
        }
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String,
    color: SpiceColor = YellowSpiceColor) :
        Spice(name, spiciness, color),
        Grinder by MakePowder(ingredient = "Curry Herbs"){
    override fun prepareSpice() {
        println("preparing spice...")
        grind()
        println("spice prepared")
    }
}

class MakePowder(val ingredient: String) : Grinder{
    override fun grind() {
        println("Grinding spice: $ingredient")
    }
}

object RedSpiceColor: SpiceColor{
    override val color = "red"
}

object GreenSpiceColor : SpiceColor{
    override val color = "green"
}
object YellowSpiceColor : SpiceColor{
    override val color = "yellow"
}

interface SpiceColor{
    val color: String
}
interface Grinder{
    fun grind()
}

data class SpiceContainer(val spice: Spice, val label: String = spice.name)

fun main(){
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium", RedSpiceColor)),
        SpiceContainer(Curry("Green Curry", "spicy", GreenSpiceColor)))
    println("***Spices in the Spice Cabinet***\n${spiceCabinet.forEach { println(it.label) }}")
}