import java.io.*
import java.util.*

fun runQueries(q: MutableList<Pair<Int,Int>>){
    val stack = Stack<Int>()
    for (p in q){
        when(p.first){
            1 -> stack.push(p.second)
            2 -> stack.pop()
            else -> {
                println(stack.toSet().maxBy{it})
            }
        }
    }
}

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    val scan = Scanner(System.`in`)
    val itr = scan.nextInt()
    val q = mutableListOf<Pair<Int, Int>>()
    var t: Int
    for (i in 0 until itr){
        t = scan.nextInt()
        if (t == 1){
            q += t to scan.nextInt()
        }else{
            q += t to 0
        }
    }
}
