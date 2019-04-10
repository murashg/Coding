package Game

fun main(args: Array<String>){

    val game = Engine()
    while(game.path.isNotEmpty()){
        println("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }

}

fun findKthElement(n: Int, k: Int): Int = Array(n){it+1}.sortedBy {it.toString()}[k-1]