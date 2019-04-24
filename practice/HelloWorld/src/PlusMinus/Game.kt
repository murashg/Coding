package PlusMinus

import java.lang.Exception
import java.util.*

class Tile(val num: Stack<Int>, var plusminus: Boolean, val position: Pair<Int,Int>){
    fun scramble(): Tile{
        plusminus = Random().nextBoolean()
        return this
    }

    operator fun plusAssign(otherTile: Tile){
        this.num.push(if (otherTile.plusminus) num.peek() + otherTile.num.peek() else num.peek() - otherTile.num.peek())
        otherTile.num.push(0)
    }
}

class Board(val r: Random, val tiles: MutableList<MutableList<Tile>> = createBoard(r)){
    val findSize = {
        var c = 0
        for (row in tiles){
            for (tile in row) if (tile.num.peek() != 0) c++
        }
        c
    }
}

class Moves(val moves: Stack<Tile>)

fun scrambleBoard(board: Board): Board{
    for (row in board.tiles){
        for (tile in row){
            tile.scramble()
        }
    }
    return board
}

fun createRandomTile(r: Random, position: Pair<Int,Int>): Tile{
    val stack = Stack<Int>()
    stack.push(r.nextInt(9)+1)
    return Tile(stack, r.nextBoolean(), position)
}

fun createBoard(r: Random): MutableList<MutableList<Tile>>{
    val board: MutableList<MutableList<Tile>> = mutableListOf()
    for (i in 0..2){
        val row = mutableListOf<Tile>()
        for (j in 0..2) row += createRandomTile(r,i to j)
        board += row
    }
    return board
}

fun findSolution(board: Board, r: Random): Int{
    val t = board //make sure not editing board
    var position = r.nextInt(3) to r.nextInt(3)
    val howManyMoves =
        {b:Board, p: Pair<Int, Int> ->
            val validMoves = mutableListOf<Int>()
            try{if (b.tiles[p.first-1][p.second].num.peek() != 0) validMoves.add(1)}catch (e: Exception){}
            try{if (b.tiles[p.first+1][p.second].num.peek() != 0) validMoves.add(2)}catch (e: Exception){}
            try{if (b.tiles[p.first][p.second-1].num.peek() != 0) validMoves.add(3)}catch (e: Exception){}
            try{if (b.tiles[p.first][p.second+1].num.peek() != 0) validMoves.add(4)}catch (e: Exception){}
            validMoves
        }
    var nextMove: Int
    var possibleMoves: MutableList<Int>
    //up, down, left, right
    var size = 9
    while(size > 1){
        possibleMoves = howManyMoves(t,position)
        nextMove = possibleMoves[r.nextInt(possibleMoves.size)]
        if (isValidMove(t,position,nextMove)) {
            makeMove(t, position, nextMove)
            position = when (nextMove) {
                1 -> position.first - 1 to position.second
                2 -> position.first + 1 to position.second
                3 -> position.first to position.second - 1
                else -> position.first to position.second + 1
            }
        }
        size = t.findSize()
    }
    var sum = 0
    for (row in t.tiles){
        for (tile in row){
            sum += tile.num.peek()
        }
    }
    return sum
}

fun makeMove(t: Board, p: Pair<Int,Int>, move: Int){
    when (move){
        1 -> {
            t.tiles[p.first-1][p.second] += t.tiles[p.first][p.second]
        }
        2 -> {
            t.tiles[p.first+1][p.second] += t.tiles[p.first][p.second]
        }
        3 -> {
            t.tiles[p.first][p.second-1] += t.tiles[p.first][p.second]

        }
        else -> {
            t.tiles[p.first][p.second+1] += t.tiles[p.first][p.second]
        }
    }
}

fun isValidMove(board: Board, position: Pair<Int, Int>, move: Int):Boolean {
    return when(move){
        1 -> {
                try {
                    board.tiles[position.first - 1][position.second].num.peek() != 0
                } catch (e: Exception) {false }
            }
        2 -> {
                try {
                    board.tiles[position.first + 1][position.second].num.peek() != 0
                } catch (e: Exception) {false }
            }
        3 -> {
            try {
                board.tiles[position.first][position.second - 1].num.peek() != 0
            } catch (e: Exception) { false}
            }
        else -> {
                try {
                    board.tiles[position.first][position.second + 1].num.peek() != 0
                } catch (e: Exception) { false}
            }
    }
}

fun print(board: Board){
    for (l in board.tiles){
        for (n in l){
            print("${n.num.peek()} ${if (n.plusminus) "+" else "-"}, ")
        }
        print("\n")
    }
}

fun main(){
    val r = Random()
    val board = Board(r)
    print("Starting board \n")
    print(board)
    print("\n ---------- \n")
    val solution = findSolution(board, r)
    print("Solution $solution \n")
    val initialBoard = scrambleBoard(board)
    print("Scrambled board: ---------\n")
    print(initialBoard)
}