/*
Given an M x N grid filled with non-negative numbers, find a path
from top left to bottom right which minimizes the sum of all numbers
along the path and return that minimum sum.

Note: You can only move either down or right at any point in time.

Input:
[1, 8, 2]
[1, 4, 0]
[1, 2, 5]

Output:
10

Explanation:
(Start) 1 + (Down) 1 + (Down) 1 + (Right) 2 + (Finish) 5 = 10

*/

import java.io.*;
import java.lang.*;

class MyCode {
  public static void main (String[] args) {
    int[][] grid = new int[][] {{1,8,2},{1,4,0},{1,2,5}};

    System.out.println("Minimum path: " + minSumPath(grid));

  }
  public static int minSumPath(int[][] grid) {

    return breathHelper(grid,0,0,0);
  }
  private static int breathHelper(int[][] grid,int x, int y, int sum){

    if (x >= grid[0].length || y >= grid.length){
      return Integer.MAX_VALUE;
    }
    sum += grid[y][x];
    //check boundries
    if (x == grid[0].length){
      if (y == grid.length){
        //we've reached the end
        return sum;
      }
      //go down
      return sum + breathHelper(grid,x,y+1,sum);
    }else if (y == grid.length){
      //go right
      return sum + breathHelper(grid,x+1,y,sum);
    }

    int right = sum + breathHelper(grid,x+1,y,sum);
    int down = sum + breathHelper(grid,x,y+1,sum);
    if (right < down){
      return right;
    }
    return down;

  }

}
