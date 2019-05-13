Q1. In a matrix of 0s and 1s, where 0 represents water and 1 represents land,
we need to find out the number of islands in the matrix.
 n
0 1 0 1 0 1 0
0 1 0 1 0 1 0 m
0 1 0 1 0 1 0
0 0 0 0 0 0 0
0 1 0 1 0 1 0
0 1 0 1 0 1 0
0 1 0 1 0 1 0

Answer: 6 islands

space O(n*m)
runtime O(n*m)

fun countIslands(matrix: List<List<Int>>): Int{
    if(matrix.length == 0 || matrix[0].length == 0) return 0
    //initialize visited matrix to false
    val visited = mutableListOf<MutableList<Boolean>>(matrix.length)
    for ((i,row) in visited.withIndex()){
        visited.add(mutableListOf<Boolean>(matrix[i].length))
    }

    var count = 0
    for (var i = 0; i < matrix.length; i++){
        for (var j = 0; j < matrix[i].length; j++){
            count += visitIsland(matrix, visited, i, j)
        }
    }
    return count
}

fun visitIsland(matrix: List<List<Int>>, visited: MutableList<MutableList<Boolean>>, y: Int, x: Int){
    if (!visited[y][x] && matrix[y][x] == 1){
        visited[y][x] = true
        try{visitIsland(matrix,visited,y-1,x)}catch(e: Exception){}//up
        try{visitIsland(matrix,visited,y+1,x)}catch(e: Exception){}//down
        try{visitIsland(matrix,visited,y,x-1)}catch(e: Exception){}//left
        try{visitIsland(matrix,visited,y,x+1)}catch(e: Exception){}//right
        return 1
    }
    return 0

}

fun main(){
    val test1 = listOf(0,1)
    val test2 = listOf(listOf(0, 1, 0, 1, 0, 1, 0), listOf(0, 1, 0, 1, 0, 1, 0))
    print(countIslands(test1))
    print(countIslands(test2))
    //print(countIslands())
}
