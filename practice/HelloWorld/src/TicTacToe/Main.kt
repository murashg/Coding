package TicTacToe

fun main(args: Array<String>){
    if (args.isEmpty()) {
        var runGame = true
        val history = mutableListOf(0,0)
        var winner: String
        start@ while (runGame) {
            print("New Game? (Y/N): ")
            when(readLine()?.toLowerCase()){
                "n" -> {
                    runGame = false
                    continue@start
                }
                "y" -> {}
                else -> {
                    println("Invalid Input")
                    continue@start
                }
            }

            winner = startGame(initializeBoard())
            when (winner){
                "O" -> println("Player O has won the game!\n")
                "X" -> println("Player X haas won the game!\n")
                else -> println("Game is a Tie!\n")
            }
        }
        println("X player won ${history[0]} games\n" +
                "O player won ${history[1]} games\n")

    }else{

    }
}

fun initializeRow(): MutableList<Int>{
     return readLine()
        ?.map{if (it == '0' || it == '1') it.toString().toInt() else 2}
        ?.plus(listOf(2,2,2))!!
        .take(3)
        .toMutableList()
}

fun initializeBoard(): Board{
    print("***Starting game***\n\n - Would you like to add your own board-state? (Y/N): ")
    return when(readLine()?.toLowerCase()){
        "y" -> {
            println("Enter the board state: format is 3 ints per row.  0's represent X's and 1's represent 0's, anything else will be treated as blank.\nEntering nothing in row will default row to blank and only the first 3 characters will be counted towards row")
            print("Enter row 1 (---): ")
            val row1 = initializeRow()
            print("Enter row 2 (---): ")
            val row2 = initializeRow()
            print("Enter row 3 (---): ")
            val row3 = initializeRow()
            Board(listOf(row1,row2,row3))
        }
        else -> {
            Board()
        }
    }
}

fun startGame(board: Board): String{
    println(board)
    return "O"
}