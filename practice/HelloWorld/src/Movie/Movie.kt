package Movie
/*
    A movie critic likes to review movies by comparing them side-by-side. Given a list of movie comparison pairs,
    in which the first element is better than the second, print out a ranking of movies from best-to-worst.
    Movies in a tie are sorted lexiconically.

*/
class Movie(val title: String, val children: MutableSet<Movie> = mutableSetOf()){
    operator fun plus(movie: Movie): Movie{
        children += movie
        return this
    }
    operator fun minusAssign(movie: String){
        children.remove(children.find{ it.title == movie})
    }
}

fun rankMovies(moviePairs: List<List<String>>): List<String>{
    val map = mutableMapOf<String, Movie>()
    val result = mutableListOf<String>()
    //for each movie, add the first movie to the map with it's child being the second
    for (moviePair in moviePairs) map[moviePair[0]] = map.getOrDefault(moviePair[0],Movie(moviePair[0])) + map.getOrElse(moviePair[1]
    ) {
        map[moviePair[1]] = Movie(moviePair[1])
        map[moviePair[1]]
    }!!

    //add the movies without children to the result list and remove those from map
    while(map.any()){
        val lowestRankMovies = map.filter { (k, v) -> v.children.isEmpty() }.keys.toList().sorted().reversed()
        result.addAll(lowestRankMovies)
        for (movie in lowestRankMovies) {
            map.filter { (k, v) -> v.children.find { it.title == movie } != null }.forEach { (k, v) -> v -= movie }
            map -= movie
        }
    }
    return result.toList().reversed()
}

fun main(args: Array<String>) {
    val test = listOf(listOf("aladdin", "batman"), listOf("batman", "iron man"), listOf("jerassic park", "iron man"), listOf("spongebob", "men in black"), listOf("aladdin", "jerassic park"))
    print(rankMovies(test))
}