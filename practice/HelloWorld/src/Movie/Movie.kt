package Movie
/*
    A movie critic likes to review movies by comparing them side-by-side. Given a list of movie comparison pairs,
    in which the first element is better than the second, print out a ranking of movies from best-to-worst.
    Movies in a tie are sorted lexiconically.

*/
class Movie(val title: String, val children: MutableSet<Movie> = mutableSetOf()){
    fun addChild(movie: Movie): Movie{
        children.add(movie)
        return this
    }
    fun removeChild(movie: String){
        children.remove(children.find{ it.title == movie})
    }
}

fun rankMovies(moviePairs: List<List<String>>): List<String>{
    val map = mutableMapOf<String, Movie>()
    val result = mutableListOf<String>()
    for (moviePair in moviePairs){
        map[moviePair[0]] = map.getOrDefault(moviePair[0],Movie(moviePair[0])).addChild(
            map.getOrElse(moviePair[1],
                {
                    map[moviePair[1]] = Movie(moviePair[1])
                    map[moviePair[1]]
                })!!
        )
    }

    while(map.any()){
        val lowestRankMovies = map.filter { (k, v) -> v.children.isEmpty() }.keys.toList().sorted().reversed()
        result.addAll(lowestRankMovies)
        for (movie in lowestRankMovies) {
            map.filter { (k, v) -> v.children.find { it.title == movie } != null }.forEach { (k, v) -> v.removeChild(movie) }
            map.remove(movie)
        }
    }
    return result.toList().reversed()
}

fun main(args: Array<String>) {
    val test = listOf(listOf("aladdin", "batman"), listOf("batman", "iron man"), listOf("jerassic park", "iron man"), listOf("spongebob", "men in black"), listOf("aladdin", "jerassic park"))
    print(rankMovies(test))
}