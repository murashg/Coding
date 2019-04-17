package Movie

fun turnLightsOnSimple(grid: Array<Array<Int>>): Array<Array<Int>>{
    val newGrid = Array(grid.size){Array(grid[0].size){0}}
    val h = grid.size-1
    val w = grid[0].size-1
    for (i in 0..h){
        for (j in 0..w){
            if (grid[i][j] == 1){
                for (y in 0..h) newGrid[y][j] = 1
                for (x in 0..w) newGrid[i][x] = 1
            }
        }
    }
    return newGrid
}
fun turnLightsOn(grid: Array<Array<Int>>): Array<Array<Int>>{
    val yPoints = mutableSetOf<Int>()
    val xPoints = mutableSetOf<Int>()
    for ((i, row) in grid.withIndex()){
        for ((j, num) in row.withIndex()) {
            if (num == 1){
                yPoints.add(i-1)
                xPoints.add(j+1)
            }
        }
    }
    val newGrid = grid
    val h = grid.size-1
    val w = grid[0].size - 1
    for (i in yPoints) for (y in 0..h) newGrid[y][i] = 1
    for (j in xPoints) for (x in 0..w) newGrid[j][x] = 1

    return newGrid
}

fun print(result: Array<Array<Int>>){
    for (row in result){
        for (i in row){
            print("$i ")
        }
        print("\n")
    }
}

fun main(){
    val test = Array(5){Array(5){0}}
    test[3][2] = 1
    print(turnLightsOn(test))
    val test2 = Array(6){Array(4){0}}
    test2[2][2] = 1
    test2[0][3] = 1
    //print(turnLightsOn(test2))
}