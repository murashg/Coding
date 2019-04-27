import java.io.*
import java.util.*

// Given a string, find the first character that doesn’t repeat elsewhere in the given string.
// runtime and space O(n)
fun main(args: Array<String>) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        
        println(findFirstUniqueChar("abcda")) //b
        println(findFirstUniqueChar("")) //No Unique Chars
        println(findFirstUniqueChar("aabbccdeeffghoisdf")) //g
        println(findFirstUniqueChar("aabbcc")) //No Unique Chars
}

private fun findFirstUniqueChar(string: String): String{
    if (string.length == 0) return "No Unique Chars"
    val map = mutableMapOf<Char,Int>()
    val set = mutableSetOf<Char>()
    for ((index,char) in s.withIndex()){
        if (!set.contains(char)){
            map[char] = index
            set += char
        }else{
            map -= char
        }
    }
    //return minimum index entry key or if map is empty "No Unique Chars"
    return map?.minBy{(_,v) -> v}?.key?.toString() ?: "No Unique Chars"
}
