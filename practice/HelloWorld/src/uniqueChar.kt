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
    val uniqueChars = mutableSetOf<Char>() //linkedHashSet maintains insertion order
    val duplicateChars = hashSetOf<Char>()
    for (c in input){
        if (!duplicateChars.contains(c)){
            uniqueChars += c // "+=" == .plusAssign() == .add()
            duplicateChars += c
        }else{
            uniqueChars -= c
        }
    }
    //return minimum index entry key or if map is empty "No Unique Chars"
    return if (uniqueChars.isNotEmpty()) uniqueChars.first().toString() else "No Unique Chars"
}
