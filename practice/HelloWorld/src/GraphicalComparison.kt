import java.io.BufferedWriter
import java.io.File

/*  Greg Murashige

    This is comprehensive research experiment to explore the graphical comparisons of different common resolutions.
 */

fun test720p(out: BufferedWriter): () -> Unit = { for (i in 1..720){out.write("p"); if (i % 100 == 0) out.write("\n")}}

fun test1080p(out: BufferedWriter): () -> Unit = { for (i in 1..1080){out.write("p"); if (i % 100 == 0) out.write("\n")}}

fun test1080i(out: BufferedWriter): () -> Unit = { for (i in 1..1080){out.write("i"); if (i % 100 == 0) out.write("\n")}}

fun test4k(out: BufferedWriter) = repeat(4){out.write("K")}
fun main(){
    val fileName = "src/resources/graphicalComparison.txt"
    val myfile = File(fileName)

    myfile.bufferedWriter().use { out ->

        out.write("720p - ")
        test1080p(out)
        out.write("\n\n1080p - ")
        test1080p(out)
        out.write("\n\n1080i - ")
        test1080i(out)
        out.write("\n\n4K - ")
        test4k(out)
    }
}