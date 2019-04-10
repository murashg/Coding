fun main(args:Array<String>){
    println("Your fortune is: ${getFortuneCookie(getBirthday())}")
}
fun getFortuneCookie(birthday:Int):String{
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
    return when(birthday){
        in 0..7 -> fortunes[3]
        28, 31 -> fortunes[0]
        else -> fortunes[birthday % fortunes.size]
    }
}
fun getBirthday():Int{
    print("Enter your birthday:")
    return readLine()?.toIntOrNull() ?: 1
}