import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Movie{
    String title;
    List<Movie> children;

    Movie(String in){
        this.title = in;
        children = null;
    }

    void addChild(String in){
        children
    }
}

public class Solution {
    /*
    	A movie critic likes to review movies by comparing them side-by-side. Given a list of movie comparison pairs,
    	in which the first element is better than the second, print out a ranking of movies from best-to-worst.
    	Movies in a tie can be printed in any order.

		Example Input: (Aladdin, DaddyDaycare), (Aladdin, Batman), (Batman, DaddyDaycare), (Ghostbusters, DaddyDaycare), (jp, ironman)
        Example Output: Aladdin, Batman, Ghostbusters, DaddyDaycare

        aladdin -> daddydaycare, batman
        batman -> daddydaycare
        ghostbusters -> daddycare
        daddycare -> []
        jp -> ironman
        ironman -> []

        aladdin -> batman
        batman -> []
        ghostbusters -> []


        batman, ghostbusters, ironman, daddycare
    */
    //check if first element exists as a Movie, if not create and set or create second element as child.


    private static void rankMovies(String[][] moviePairs){

        Map<String,Movie> map = new HashMap<String,Movie>();

        for (String[] moviePair: moviePairs){
            if (!map.containsKey(moviePair[0])){
                Movie newMovie = new Movie(moviePair[0]);
                newMovie.addChild(moviePair[1]);
            }else{
                
            }
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String[][] moviePairs = new String[4][2];



    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
    The mayor wants to know how well-lit her streets are. On each intersection with a street light,
    both the vertical street and horizontal street are considered "lit".
    The map she has supplied you is an integer matrix of 1s and 0s, where 1 represents a street light. If the matrix cell has a 1,
    can you fill the entire row and entire column with 1s to which streets are lit?

    Input:
    0 0 0
    1 0 0
    0 0 0

    Output:
    1 0 0
    1 1 1
    1 0 0

     */

    private static int[][] lightStreets(int[][] arr){
        int[][] result = new int[arr.length][arr[0].length];
        int len = arr[0].length;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < len; j++){
                if (arr[i][j] == 1){
                    light(result, i, j);
                }
            }
        }

        return result;
    }

    private static void light(int[][] result, int y, int x){

        for (int i = 0; i < result.length; i++){
            result[i][x] = 1;
        }
        for (int j = 0; j < result[0].length; j++){
            result[y][j] = 1;
        }

    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        //get input
        int[][] matrix = new int[][]{{0,0,0},{1,0,0},{0,0,0}};

        matrix = lightStreets(matrix);

        for (int[] street : matrix){
            for (int n : street){
                System.out.print(n + " ");
            }
            System.out.print("\n");
        }



    }
}
