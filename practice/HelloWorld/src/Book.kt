open class Book(val title: String, val author: String){
    private var currentPage: Int = 1
    open fun readPage() {currentPage++}
    open fun whatPage(){println(currentPage)}
}

class eBook(title: String, author: String, val format: String = "text") : Book(title,author){
    private var wordsRead: Int = 0
    override fun readPage() {wordsRead += 250}
    override fun whatPage(){println(wordsRead/250)}
}

fun main(){
    val maryPoppins = Book(title = "Marry Poppins",author = "John Douglas")
    repeat(35) {maryPoppins.readPage()}
    maryPoppins.whatPage()
    val drseuse = eBook(title = "lorax",author = "Dr. Suess")
    repeat(35) {drseuse.readPage()}
    drseuse.whatPage()
    println("Dr Suess how many words? you can't know cause its private${drseuse.title}")
}