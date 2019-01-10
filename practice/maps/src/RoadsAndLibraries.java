import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RoadsAndLibraries {


    static long dfs(int i, boolean[][] roads, boolean[] visited, int n){
        visited[i] = true;
        long count = 1;
        System.out.print((int)(i + 1) + "->");
        //check paths out to nodes
        for (int j = 0; j < n; j++){
            if (roads[i][j] && !visited[j]){
                count += dfs(j, roads, visited, n);
            }
        }
        // check paths back from nodes
        for (int j = 0; j < n; j++){
            if (roads[j][i] && !visited[j]){
                count += dfs(j, roads, visited, n);
            }
        }
        return count;
    }

    // Complete the roadsAndLibraries function below.
    // if the cost of a library is cheaper or = to the cost of a road, build
    // libraries in every city
    // else build 1 library in each city group and use Depth First Search to create and go through
    // adjacency matrix
    // n = number of cities
    // c_lib = cost of a library
    // c_road = cost of a road
    // cities = a matrix of unobstructed roads

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if (c_lib <= c_road) return c_lib * n;
        //print cities
        /*
        System.out.println("cities :" + (int)n);
        for (int i = 0; i < cities.length; i++){
            for (int j = 0; j < cities[i].length; j++){
                System.out.print((int)cities[i][j] + " ");
            }
            System.out.println();
        }
        */
        //build adjacency matrix
        boolean[][] roads = new boolean[n][n];
        for (int i = 0; i < cities.length; i++){
            roads[cities[i][0]-1][cities[i][1]-1] = true;
        }

        System.out.println("Adjacency Matrix");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(roads[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }

        // dfs through adjacency matrix till all cities are visited.
        boolean[] visited = new boolean[n];
        //System.out.println("Depth First Search");
        long totalCost = 0;
        long longRoad = (long) c_road;
        long longLib = Integer.toUnsignedLong(c_lib);
        long one = 1;
        int a = 0;
        while (a < n){
            if (visited[a] == false){
                totalCost += (dfs(a, roads, visited, n) - one) * longRoad + longLib;
                /*
                System.out.println();
                for (int i = 0; i < n; i++) System.out.print(visited[i] ? "1" : "0");
                System.out.println("Visited : Total = " + (long)totalCost);
                */
            }
            a++;
        }
        return totalCost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            System.out.println(result);

        }

        scanner.close();
    }
}
