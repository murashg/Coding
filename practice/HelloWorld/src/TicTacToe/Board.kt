package TicTacToe

data class Board(val board: List<MutableList<Int>> = listOf(mutableListOf(4,4,4), mutableListOf(4,4,4),
    mutableListOf(4,4,4))){
    private val sumL = listOf(
        {board[0].sum()},
        {board[1].sum()},
        {board[2].sum()},
        {board[0][0]+board[1][0]+board[2][0]},
        {board[0][1]+board[1][1]+board[2][1]},
        {board[0][2]+board[1][2]+board[2][2]},
        {board[0][0]+board[1][1]+board[2][2]},
        {board[0][2]+board[1][1]+board[2][0]})

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
        println("+ - + - + - +\n" +
                "| ${pixel(board[0][0])} | ${pixel(board[0][1])} | ${pixel(board[0][2])} |\n" +
                "+ - + - + - +\n" +
                "| ${pixel(board[1][0])} | ${pixel(board[1][1])} | ${pixel(board[1][2])} |\n" +
                "+ - + - + - +\n" +
                "| ${pixel(board[2][0])} | ${pixel(board[2][1])} | ${pixel(board[2][2])} |\n" +
                "+ - + - + - +")
    }
    private inline fun pixel(p: Int): String{
        return when(p){
            0 -> "O"
            1 -> "X"
            else -> " "
        }
    }
    private inline fun assign(player: Boolean) = if (player) 0 else 1
    fun makeMove(player: Boolean){
        println("Player ${if(player) "O" else "X"}'s turn, please make a move: ")
        val move = readLine()?.map{it.toString().toInt()}?.take(2)
        if (isValidMove(move)) {
            board[move!![1]][move[0]] = assign(player)
        }else{
            println("Invalid Input, please try again.")
            makeMove(player)
        }
    }
    private inline fun isValidMove(move: List<Int>?): Boolean{
        if (move.isNullOrEmpty()) return false
        return move?.run{ move[0] in 0..2 && move[1] in 0..2 && board[move[1]][move[0]] == 4} ?: false
    }
}