import java.io.BufferedWriter
import java.io.File

/*  Greg Murashige

    This is comprehensive research experiment to explore the graphical comparisons of different common resolutions.
 */

fun test720p(out: BufferedWriter){ for (i in 1..720){out.write("p"); if (i % 90 == 0) out.write("\n")}}

fun test1080p(out: BufferedWriter){ for (i in 1..1080){out.write("p"); if (i % 120 == 0) out.write("\n")}}

fun test1080i(out: BufferedWriter){ for (i in 1..1080){out.write("i"); if (i % 120 == 0) out.write("\n")}}

fun test4k(out: BufferedWriter) = repeat(4){out.write("K")}
fun main(){
    val fileName = "src/resources/graphicalComparison.txt"
    val myfile = File(fileName)

    myfile.bufferedWriter().use { out ->

        out.write("720p\n")
        test720p(out)
        out.write("\n\n1080p\n")
        test1080p(out)
        out.write("\n\n1080i\n")
        test1080i(out)
        out.write("\n\n4K\n")
        test4k(out)
    }
}