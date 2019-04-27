// Given a string, find the first character that doesn’t repeat elsewhere in the given string.
// runtime and space O(n)
fun main() {
    println(findFirstUniqueChar("abcda")) //b
    println(findFirstUniqueChar("")) //No Unique Chars
    println(findFirstUniqueChar("aabbccdeeffghoisdf")) //g
    println(findFirstUniqueChar("aabbcc")) //No Unique Chars
}

private fun findFirstUniqueChar(input: String): String{
    if (input.isEmpty()) return "No Unique Chars"
    val map = mutableMapOf<Char, Int>() //linkedHashMap maintains insertion order
    for (c in input) map[c] = map[c]?.plus(1) ?: 1
    return map.entries.find { (_, v) -> v < 2 }?.key?.toString() ?: "No Unique Chars"
}
