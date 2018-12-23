/* Greg Murashige

More 2d list practice, it is also possible to do this whole logic in one double for loop, but where is the fun in that?

We define the following:

A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
The sum of an array is the total sum of its elements.
An array's sum is negative if the total sum of its elements is negative.
An array's sum is positive if the total sum of its elements is positive.
Given an array of  integers, find and print its number of negative subarrays on a new line.

Input Format

The first line contains a single integer, , denoting the length of array .
The second line contains  space-separated integers describing each respective element, , in array .

Constraints

Output Format

Print the number of subarrays of  having negative sums.

Sample Input

5
1 -2 4 -5 1
Sample Output

9

*/


import java.io.*;
import java.util.*;

public class Solution {

    private static int negativeSubArrays(int[] arr){
        List<List<Integer>> subArrays = generateSubArrays(arr);
        int count = 0;
        for (List<Integer> sub : subArrays){
            if (isNegativeSum(toIntArray(sub))) count++;
        }
        return count;
    }

    private static int[] toIntArray(List<Integer> list){
        int[] intArray = new int[list.size()];
        int j = 0;
        for (Integer i : list){
            intArray[j++] = i;
        }
        return intArray;
    }

    private static List<List<Integer>> generateSubArrays(int[] arr){
        List<List<Integer>> subArrays = new ArrayList<List<Integer>>();

        for (int l = arr.length; l > 0; l--){ //length of subarray
            for (int j = 0; j <= arr.length - l; j++){ //start index of subarray
                List<Integer> subArray = new ArrayList<Integer>(l);
                for (int i = j; i < j + l; i++){ //index of subarray
                    subArray.add(arr[i]);
                }
                subArrays.add(subArray);
            }
        }
        return subArrays;
    }

    private static boolean isNegativeSum(int[] arr){
        int sum = 0;
        for (int n : arr){
            sum += n;
        }
        if (sum < 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        while (n-- > 0){
            arr[n] = scan.nextInt();
        }
        System.out.println(negativeSubArrays(arr));
        scan.close();
    }
}
