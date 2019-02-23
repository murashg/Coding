import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/* problem: Starting with a 1-indexed array of zeros and a list of operations,
    for each operation add a value to each of the array element between two given
    indices, inclusive. Once all operations have been performed,
    return the maximum value in your array.

    example input:
        10 3 <- first line integers n and q with n = size of array, q = number of queries
        1 5 3 <- queries integers a b and k, a = first index, b = second index, k = number to add
        4 8 7
        6 9 1

    Add the values of  between the indices  and  inclusive:
    1 2 3  4  5 6 7 8 9 10 <-index
    [0,0,0, 0, 0,0,0,0,0, 0] <-initial array
    [3,3,3, 3, 3,0,0,0,0, 0] <- first operation performed
    [3,3,3,10,10,7,7,7,0, 0] <- second operation performed
    [3,3,3,10,10,8,8,8,1, 0] <- third and final operation performed

    find max value of final array
    [3,3,3,10,10,8,8,8,1,0] <- max value is 10

    output:
    10
*/

public class Solution {

    // 1) queries are 1-indexed so we make arr n+1 (zero index isn't used)
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n+1];
        createDiffArray(arr,queries,n);
        return findMax(arr);
    }

    // example:  if original array = {0,0,4,4,5,0} difference array = {0,0,4,0,1,-5}
    // 1)iterate through queries
    // 2)arr[a]'s value is how much larger it is than arr[a-1]
    // 3)avoid out of bounds
    // 4)arr[b+1] will subtract k so we only increase proper positions in array
    //   example: query = {3,4,1} array after query = {0,0,0,1,1,0,0}
    //   (start with zero initialized array)
    //   our difference array will be {0,0,0,1,0,-1,0}
    //   important indexes of query {0,0,a-1,a,b,b+1,0}
    static void createDiffArray(long[] arr, int[][] queries,int n){
        int a,b,k;
        for (int[] query : queries){ // 1
            a = query[0];
            b = query[1];
            k = query[2];
            arr[a] += k; //2
            if (b+1 <= n){ //3
                arr[b+1] -= k; //4
            }
        }
    }

    //example:  if original array = {0,0,4,4,5,0} difference array = {0,0,4,0,1,-5}
    //therefore iterating over array keeping the running total (value)
    //we can keep track of the max value of the original array (max)
    //arr is the difference array
    //diff is the value of the current position in the difference array
    //value is current value of current position in original array
    //max is the largest value of array
    static long findMax(long[] arr){
        long value = 0, max = 0;
        for (long diff : arr){
            value += diff;
            if (max < value){
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        //read input
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), q = scan.nextInt();
        int[][] queries = new int[q][3];

        for (int i = 0; i < q; i++){
            queries[i][0] = scan.nextInt();
            queries[i][1] = scan.nextInt();
            queries[i][2] = scan.nextInt();
        }

        scan.close();

        //calculate max value
        long result = arrayManipulation(n,queries);
        //output result
        System.out.println(result);

    }
}
