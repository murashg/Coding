package Aquarium

// a lambda is an anonymous function without a name
// {println("Hello Fish")}()
// can assign a lambda to a name, parameters come before "->"
val waterFilter = {dirty: Int -> dirty / 2}

data class NewFish (var name: String)

val myFish = listOf(
    NewFish("Flipper"),
    NewFish("Moby Dick"),
    NewFish("Dory")
    )
//filter and jointostring take lambdas in this instance
val whatFish = myFish.filter{it.name.contains("i")}.joinToString(" "){ it.name }

fun main(){
    println(whatFish)
    //fishExamples()
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.divisibleBy{it%3}) //extend List with higher order function to return Ints that = 0 after lambda
}

fun fishExamples(){
    val fish = NewFish("splashy")

    println("initial "+fish.name)
    //with is a higher-order function, doesn't edit referenced object
    with(fish.name){
        println("with "+capitalize()) //implicit this
    }
    println("after with "+fish.name)
    //example
    myWith(fish.name){
        println("myWith "+toUpperCase())
    }
    println("run "+fish.run{name}) //returns the result of block fun
    println("apply "+fish.apply{}) //returns the object reference that the block function is applied to

    //ex
    val fish2 = NewFish("splashy").apply{ name = "Sharky"}
    println("fish2 name change "+fish2.name)

    //let returns a copy of the changed object, good for chaining manipulations
    println(fish2.let{it.name.capitalize()}
        .let { it + "fish" }
        .let { it.length }
        .let{it+3})

    singleMyWith(fish.name){println("More efficient use ${capitalize()}")}
}
/*
    @params:
        name: the input string
        block: function name,
            which is type of the class we are extending
            and if there is a "void" return type use Unit
    Locally block is now an extension function of the String object

    note: everytime we call myWith Kotlin will make a new lambda object
 */
fun myWith(name: String, block: String.() -> Unit){
    name.block()
}

inline fun singleMyWith(name: String, block: String.() -> Unit){
    name.block()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int>{
    val list = mutableListOf<Int>()
    forEach { if (block(it)== 0) list.add(it) }
    return list
}