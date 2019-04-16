package Movie
/*
    A movie critic likes to review movies by comparing them side-by-side. Given a list of movie comparison pairs,
    in which the first element is better than the second, print out a ranking of movies from best-to-worst.
    Movies in a tie are sorted lexiconically.

*/

class Movie(val lowerRankedMovies: MutableSet<Movie> = mutableSetOf()){
    //cheeky operator overrides
    operator fun plus(movie: Movie): Movie{
        lowerRankedMovies += movie
        return this
    }
    operator fun minusAssign(movie: Movie?) {
        lowerRankedMovies.remove(movie)
    }
}
/*

    @param: list of movie comparison pairs: List<Pair<String,String>>
    @return: sorted ranked list of movies: List<String>

    create map of movies where movie has a set of movies ranked below it
    use map to implement graph for O(1) lookup, only 1 movie object is created for each title, children are
    pointers.  Once map is created we loop while the graph is not empty, adding the movies without children to
    our result list in reverse lexocanonical order. These operations take O(2n + nlgn) at worst case
    Then we have to remove the lowest ranked movies from our map and from movies with them as children O(nlgn)
    Finally since movies are added with the lowest rank first, we return our result list reversed.
    Note - without sorting runtime would be O(n)
    Note - code is very kotliny with each line doing a lot of logic, for simplified understanding see comments
    Runtime: O(3n + 2nlgn)
    Space: O(n) n = number of unique movies
*/
fun rankMovies(moviePairs: List<Pair<String,String>>): List<String>{
    val map = mutableMapOf<String, Movie>()
    val result = mutableListOf<String>()
    //for each movie comparison pair, add the first movie to the map with it's child being the second
    for (moviePair in moviePairs) map[moviePair.first] = map.getOrDefault(moviePair.first,Movie()) + map.getOrElse(moviePair.second
    ) {
        map[moviePair.second] = Movie()
        map[moviePair.second]
    }!!
    var lowestRankMovies: List<String>
    var movie: Movie?
    //add the movies without children to the result list and remove those from map
    while(map.any()){
        lowestRankMovies = map.filter { (k, v) -> v.lowerRankedMovies.isEmpty() }.keys.sortedDescending()
        result.addAll(lowestRankMovies)
        for (title in lowestRankMovies) {
            movie = map[title]
            //get movies where children contains title and remove title from children
            map.filter { (k, v) -> v.lowerRankedMovies.contains(movie) }.forEach { (k, v) -> v -= movie }
            map -= title
        }
    }
    return result.toList().reversed()
}

fun main(args: Array<String>) {
    val test = listOf("aladdin" to "batman", "batman" to "iron man", "jerassic park" to "iron man", "back to the future" to "men in black", "aladdin" to "jerassic park")
    print(rankMovies(test)) //[aladdin, back to the future, batman, jerassic park, iron man, men in black]
}