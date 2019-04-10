package Aquarium

fun main(args: Array<String>){
    buildAquarium()
}
fun buildAquarium(){
    val myAquarium = Aquarium()
    println("length: ${myAquarium.length}\n" +
            "width: ${myAquarium.width}\n" +
            "height: ${myAquarium.height}")
    myAquarium.height = 80
    println("new height: ${myAquarium.height}")
    println("volume: ${myAquarium.volume}")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters with ${smallAquarium.water} water.")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Aquarium 2: ${myAquarium2.volume} liters with " +
            "length: ${myAquarium2.length} " +
            "width: ${myAquarium2.width} " +
            "height: ${myAquarium2.height} " +
            "and a maximum of ${myAquarium2.water}l water")
}