import java.util.*

const val MAX_NUMBER_BOOKS = 20

open class Book(val title: String, val author: String, val year: Int = 1994, var pages: Int = 100){

    companion object {
        const val BASE_URL = "https://shigtech.com"
    }

    private var currentPage: Int = 1
    open fun readPage() {currentPage++}
    open fun whatPage(){println(currentPage)}
    fun get():Pair<String,String>{
        return title to author
    }
    fun getAll() = Triple(title,author,year)
    fun canBorrow(hasBooks: Int) = hasBooks < MAX_NUMBER_BOOKS
    fun printUrl(){println(BASE_URL+title+".html")}

}

fun Book.weight() = pages * 1.5 //grams
fun Book.tornPages(num: Int){pages -= num}

class Puppy(val name: String, var age: Int, val color: String, val breed: String){
    fun playWithBook(book: Book){
        book.tornPages(Random().nextInt(10))
    }
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

    extensionsExample()

    nullableExample()

    val winfred = Puppy("Winfred",1,"black","lab")
    val hamlet = Book("Hamlet","Shakespear",1567,400)
    while(hamlet.pages > 0) {
        winfred.playWithBook(hamlet)
        println("${winfred.name} is tearing out pages from ${hamlet.title}, there are ${hamlet.pages} pages left")
    }
}

//extension function
fun String.hasSpaces() = find{it == ' '} != null


fun extensionsExample() {
    val spaces = "Does it have spaces?".hasSpaces() //true
    println(spaces)
}

//object which calls function can be null
class Skateboard(val wheels: String, val trucks: String, private val cost: Double)

fun Skateboard?.kickFlip(){
    this?.apply { println("Did a kickflip") } ?: println("No Skateboard")
}

fun nullableExample() {
    var skateboard: Skateboard? = Skateboard(wheels = "Big Ones",trucks = "Monster", cost = 50.00)
    skateboard.kickFlip()
    skateboard = null
    skateboard.kickFlip()
}