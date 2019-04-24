package com.example.plusminus.Game

import java.util.*

// operations 0 = plus, 1 = minus, 2 = multiply, 3 = divide(round down)

class Tile(val num: Int, var operation: Int, val type: Int){

    fun randomOperation(type: Int): Int {
        if (type == 0) return if (Random().nextBoolean()) 0 else 1
        if (type == 1) return when (Random().nextInt(3)) {
            0 -> 0
            1 -> 1
            else -> 2
        }
        return Random().nextInt(4)

    }

    fun randomTile(range: Int = 20, type: Int = 0): Tile{
       return Tile(Random().nextInt(range).inc(), randomOperation(type), type)
    }


}

class MainEngine{
    //create a bunch of tiles and a value.  Scramble the tiles.  If tile is tapped the tile changes from plus to minus
    //drag two tiles together to make one tile with the value of the two summed.  Tile held is added to one stationary.
    //once all tiles are consumed, if the last tile matched the number listed.  You win.  back button will backtrack moves

    fun createTiles(){
        return listOf<Tile>()
    }
}
