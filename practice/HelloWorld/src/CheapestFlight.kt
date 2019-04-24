data class City(val id: Int, val destinations: MutableSet<Pair<City,Int>> = mutableSetOf<Pair<City,Int>>())

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
    //initialize cities
    val cities = mutableListOf<City>()
    for (i in 0 until n) cities.add(City(i))
    for (flight in flights) cities[flight[0]].destinations.add(cities[flight[1]] to flight[2])

    return 0
}

fun main(){
    print(findCheapestPrice(3, arrayOf(intArrayOf(0,1,100), intArrayOf(1,2,100), intArrayOf(0,2,500)),0,2,1))
}