//Single Abstract Method

class JavaRun { //function that takes runnable interface as a parameter and executes the run method
    fun runNow(runnable: Runnable){
        runnable.run()
    }
}

interface Runnable{
    fun run()
}

interface Callable<T>{
    fun call(): T
}

//standard
fun example() { //calling runNow requires implementing and instantiating a Runnable and run()
    val runnable = object: Runnable {
        override fun run() {
            println("I am runnable")
        }
    }
    JavaRun().runNow(runnable) //a lot of code to implement println
}

fun example2(){
    //JavaRun().runNow{println("I am runnable")}
}