fun main(args:Array<String>){
    whatShouldIDoToday("happy")
    whatShouldIDoToday("sad", temperature = 72)
}
fun whatShouldIDoToday(
    mood : String,
    weather : String = "sunny",
    temperature : Int = 24
):String{
    return when{
        walkTime(mood,weather, temperature) -> "Go for a walk."
        mittens(temperature) -> "Bundle up and play in the snow."
        beachDay(temperature) -> "Goto the beach!"
        else -> "Stay home and read."
    }
}
fun walkTime(mood : String, weather : String, temperature : Int) = mood == "happy" && weather == "sunny" && temperature > 60
fun mittens(temperature: Int) = temperature <= 32
fun beachDay(temperature: Int) = temperature > 75