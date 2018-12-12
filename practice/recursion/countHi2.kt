/* Greg Murashige
Given a string, compute recursively the number of times lowercase
"hi" appears in the string, however do not count "hi" that have an
'x' immedately before them.


countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0
*/

fun countHi2(str: String): Int {
    return when {
        str.length <= 1 -> 0
        str.length == 2 -> if (str.take(2) == "hi") 1 else 0
        str.length == 3 -> if (str.take(3) matches "hi.|([^x]hi)".toRegex()) 1 else 0
        //iterate through from back to front
        else -> {
            var c = 0
            if (str.substring(str.length - 3, str.length) matches "[^x]hi".toRegex()) c++
            c + countHi2(str.take(str.length - 1))
        }
    }
}
