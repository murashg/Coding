class Spice(val name : String, val spiciness : String = "mild"){
    val heat: Int
        get() = when (spiciness){
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "extreme" -> 7
            else -> 0
        }
}

class SimpleSpice{
    val name = "curry"
    val spiciness = "mild"
    val heat : Int
        get() = 5
}
fun makeSalt() = Spice("Salt")
fun main(args: Array<String>){
    val spices = listOf(
        Spice("curry"),
        Spice("pepper","medium"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extreme"),
        makeSalt()
    )
    val curry = SimpleSpice()
    println("name: ${curry.name} spiciness: ${curry.spiciness} heat: ${curry.heat}")
    println("${spices.filter { it.heat > 2 }.forEach{print("${it.name}, ")}}")
}