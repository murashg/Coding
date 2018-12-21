import java.*
import java.io.*
import java.util.*

object Solution {

    @JvmStatic
    fun main(args: Array<String>) {

        val ab = Scanner(System.`in`)
        val n = ab.nextInt()
        val k = ab.nextInt()
        var count = 0
        val arr = LongArray(n)
        for (i in 0 until n)
            arr[i] = ab.nextLong()
        Arrays.sort(arr)
        var i = 0
        var j = 1

        while (j < n) {
            val diff = arr[j] - arr[i]

            if (diff == k.toLong()) {
                count++
                j++
            } else if (diff > k) {
                i++
            } else if (diff < k) {
                j++
            }
        }
        println(count)
    }
}