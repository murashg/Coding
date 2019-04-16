package Movie
/*
    A movie critic likes to review movies by comparing them side-by-side. Given a list of movie comparison pairs,
    in which the first element is better than the second, print out a ranking of movies from best-to-worst.
    Movies in a tie are sorted lexiconically.

*/
class Movie(val title: String, val lowerRankedMovies: MutableSet<Movie> = mutableSetOf()){
    //cheeky operator overrides
    operator fun plus(movie: Movie): Movie{
        lowerRankedMovies += movie
        return this
    }
    operator fun minusAssign(movie: String){
        lowerRankedMovies.remove(lowerRankedMovies.find{ it.title == movie})
    }
}
/*

    @param: list of movie comparison pairs: List<Pair<String,String>>
    @return: sorted ranked list of movies: List<String>

    create graph of movies where movie has a title and a set of movies ranked below it
    use map to implement graph for O(1) lookup, only 1 movie object is created for each title, children are
    pointers.  Once map is created we loop while the graph is not empty, adding the movies without children to
    our result list in reverse lexocanonical order. These operations take O(2n + nlgn) at worst case
    Then we have to remove the lowest ranked movies from our map and from movies with them as children O(nlgn)
    Finally since movies are added with the lowest rank first, we return our result list reversed.
    Runtime: O(3n + 2nlgn)
    Space: O(n) n = number of unique movies
*/
fun rankMovies(moviePairs: List<Pair<String,String>>): List<String>{
    val map = mutableMapOf<String, Movie>()
    val result = mutableListOf<String>()
    //for each movie comparison pair, add the first movie to the map with it's child being the second
    for (moviePair in moviePairs) map[moviePair.first] = map.getOrDefault(moviePair.first,Movie(moviePair.first)) + map.getOrElse(moviePair.second
    ) {
        map[moviePair.second] = Movie(moviePair.second)
        map[moviePair.second]
    }!!

    //add the movies without children to the result list and remove those from map
    while(map.any()){
        val lowestRankMovies = map.filter { (k, v) -> v.lowerRankedMovies.isEmpty() }.keys.toList().sorted().reversed()
        result.addAll(lowestRankMovies)
        for (title in lowestRankMovies) {
            map.filter { (k, v) -> v.lowerRankedMovies.find { it.title == title } != null }.forEach { (k, v) -> v -= title }
            map -= title
        }
    }
    return result.toList().reversed()
}

fun main(args: Array<String>) {
    val test = listOf("aladdin" to "batman", "batman" to "iron man", "jerassic park" to "iron man", "spongebob" to "men in black", "aladdin" to "jerassic park")
    print(rankMovies(test))
}