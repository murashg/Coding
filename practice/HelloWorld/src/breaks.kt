
fun labels(){

    //labeled break
    loop@ for(i in 1..10){
        for(j in 1..10){
            if (i > 5) break@loop
            println("$i $j")
        }
    }
}

fun main(){
    labels()
}