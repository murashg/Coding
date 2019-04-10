open class Book(val title: String, val author: String, val year: Int = 1994){
    private var currentPage: Int = 1
    open fun readPage() {currentPage++}
    open fun whatPage(){println(currentPage)}
    fun get():Pair<String,String>{
        return title to author
    }
    fun getAll() = Triple(title,author,year)
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
    println("Dr Suess: ${drseuse.get()}")
    println("Dr Suess triple as list: ${drseuse.getAll().toList()}")
    val (title: String, author: String, year: Int) = drseuse.getAll()
    println("Here is book $title written by $author in $year")
    val triple = drseuse.getAll()
    println("first element ${triple.first} second element ${triple.second} third element ${triple.third}")

    val allBooks = setOf("MacBeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any {it.value.contains("Hamlet")})
    val moreBooks = mutableMapOf<String, String>("William Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book"){"Kipling"}
    moreBooks.getOrPut("Hamlet"){"Shakespeare"}
    println(moreBooks)
}