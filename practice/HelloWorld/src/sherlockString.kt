// fun isValid
//
// @params: String
// @return: String ("YES" if input matches sherlock string, else "NO")
//
// input: aabbc
// 1) create map of character frequencies. {a=2, b=2, c=1}
// 2) create map of frequencies of character frequencies. {2=2, 1=1}
// 3) use that to find most common frequency. 2
// 4) filter out chars that don't have most common frequency. {c=1}
// 5) check if input is valid.
//
//     -there are no characters that do not match the common frequency
//     -there is exactly 1 character that does not match the common frequency
//       -that character has a frequency is 1 greater than common frequency
//       -that character has a frequency of 1
fun isValid(s: String): String {
    if (s.isEmpty()) return "YES"
    val charFreq = s.groupingBy{it}.eachCount()
    val charFreqFreq = charFreq.values.groupingBy{it}.eachCount()
    val mostCommonCharFreq = charFreqFreq.maxBy{it.value}!!.key
    val remainingChars = charFreq.filter{it.value != mostCommonCharFreq}
    return when(remainingChars.size){
        0 -> "YES"
        1 -> {
            val remChar = remainingChars.values.first()
            if(remChar == 1 || remChar == mostCommonCharFreq+1) "YES" else "NO"
        }
        else -> "NO"
    }
}

fun main() {
    println(isValid(readLine()!!))
}
