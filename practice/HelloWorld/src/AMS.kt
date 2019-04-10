import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()
}

fun fitMoreFish(
    tankSize : Double,
    currentFish : List<Int>,
    fishSize : Int = 2,
    hasDecorations : Boolean = true
) : Boolean {
    return (tankSize * if(hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun swim(){
    //swim!
}

//lambda
var dirty = 20
val waterFilter: (Int) -> Int = {dirty -> dirty/2}
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty : Int, operation : (Int) -> Int) : Int {
    return operation(dirty)
}

fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) {dirty -> dirty + 50}
}


fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = getDirtySensorReading()
) : Boolean{
    val isTooHot = temperature > 30
    val isSunday = day == "Sunday"
    return when {
        isTooHot -> true
        isDirty(dirty) -> true
        isSunday -> true
        else -> false
    }
}

fun isDirty(dirty : Int) = dirty > 30

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    if (shouldChangeWater(day)){
        println("Please change the water today.")
    }
    dirtyProcessor()
}

fun randomDay() : String{
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day:String):String{
    return when (day){
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}