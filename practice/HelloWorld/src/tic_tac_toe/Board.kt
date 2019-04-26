package tic_tac_toe

class Board(private val board: List<MutableList<Int>> = listOf(mutableListOf(4,4,4), mutableListOf(4,4,4),
    mutableListOf(4,4,4))){

    //sumL is a list of the different summations to check
    private val sumL = listOf(
        //rows
        {board[0].sum()},
        {board[1].sum()},
        {board[2].sum()},
        //columns
        {board[0][0]+board[1][0]+board[2][0]},
        {board[0][1]+board[1][1]+board[2][1]},
        {board[0][2]+board[1][2]+board[2][2]},
        //diagonals
        {board[0][0]+board[1][1]+board[2][2]},
        {board[0][2]+board[1][1]+board[2][0]})

    //returns true if there are no empty spaces, or the sum of a row, column or diagonal is equal to 0 or 3
    fun gameOver(): Boolean{
        return board.none { it.contains(4) } || sumL.any{it() == 0 || it() == 3}
    }

    fun getWinner(): String{
        val oWinner = sumL.any{it() == 0}
        val xWinner = sumL.any{it() == 3}
        return when{
            oWinner -> "O"
            xWinner -> "X"
            else -> "T"
        }
    }

    fun display(){
        println("    A   B   C\n" +
                "  + - + - + - +\n" +
                "3 | ${pixel(board[0][0])} | ${pixel(board[0][1])} | ${pixel(board[0][2])} | 3\n" +
                "  + - + - + - +\n" +
                "2 | ${pixel(board[1][0])} | ${pixel(board[1][1])} | ${pixel(board[1][2])} | 2\n" +
                "  + - + - + - +\n" +
                "1 | ${pixel(board[2][0])} | ${pixel(board[2][1])} | ${pixel(board[2][2])} | 1\n" +
                "  + - + - + - +\n" +
                "    A   B   C\n")
    }

    private fun pixel(p: Int): String{
        return when(p){
            0 -> "O"
            1 -> "X"
            else -> " "
        }
    }

    private fun readMove():List<Int>? {
        return readLine()
            ?.toLowerCase()
            ?.mapIndexedNotNull { index, c ->
                when (index) {
                    0 -> when(c){
                        'a' -> 0
                        'b' -> 1
                        'c' -> 2
                        else -> 3
                    }
                    1 -> when(c){
                        '1' -> 2
                        '2' -> 1
                        '3' -> 0
                        else -> 3
                    }
                    else -> {0}
                }
            }
            ?.take(2)
    }

    fun makeMove(player: Boolean){
        print("Player ${if(player) "O" else "X"}'s turn, please make a move (xy): ")
        val move = readMove()
        if (isValidMove(move)) {
            board[move!![1]][move[0]] = if(player) 0 else 1
        }else{
            println("Invalid Input, please try again.")
            makeMove(player)
        }
    }

    private fun isValidMove(move: List<Int>?) =
        !move.isNullOrEmpty() &&
                move[0] in 0..2 &&
                move[1] in 0..2 &&
                board[move[1]][move[0]] == 4

}