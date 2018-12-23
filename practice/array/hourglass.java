/* Greg Murashige

The ol' hourglass problem, feel like I've done this before.  

You are given a  2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

The hourglass which has the largest sum is:

2 4 4
  2
1 2 4

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static int maxHourGlass(int[][] arr){
        int max = sumHourGlass(arr, 0, 0);
        int shg = 0;
        for (int y = 0; y < arr.length-2; y++){
            for (int x = 0; x < arr[y].length - 2; x++){
                shg = sumHourGlass(arr, x, y);
                if (shg > max){
                    max = shg;
                }
            }
        }
        return max;
    }

    private static int sumHourGlass(int[][] arr, int x, int y){

        int sum = 0;

        sum = arr[y][x] + arr[y][x+1] + arr[y][x+2];
        sum += arr[y+1][x+1];
        sum += arr[y+2][x] + arr[y+2][x+1] + arr[y+2][x+2];

        return sum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        System.out.println(Solution.maxHourGlass(arr));
    }
}
