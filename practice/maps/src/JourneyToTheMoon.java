import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JourneyToTheMoon {

    static int n;
    static LinkedList<Integer> adj[];

    // Create map that connects country (represented by int) and a list of astronauts (represented by int)
    // multiply number of astronauts by the amount of countrys
    static int journeyToMoon(int[][] astronaut) {

        //create adjacency list
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++){
            adj[i] = new LinkedList();
        }

        for (int[] pair : astronaut){
            adj[pair[0]].add(pair[1]);
            adj[pair[1]].add(pair[0]);
        }

        List<List<Integer>> countries = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[n];
        int a = 0;
        while (a < n){
            if (!visited[a]){
                System.out.println("Country ");
                countries.add(dfs(a,visited));
                System.out.println();
            }
            a++;
        }

        int sum = 0;
        int result = 0;
        for(List<Integer> astronauts : countries){
            result += sum*astronauts.size();
            sum += astronauts.size();
        }
        return result;
    }

    static List<Integer> dfs(int v, boolean[] visited){
        List<Integer> list = new LinkedList<Integer>();
        visited[v] = true;
        list.add(v);
        System.out.print((v) + "->");
        //check paths out to nodes
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int j = i.next();
            if (!visited[j])
                list.addAll(dfs(j, visited));
        }
        return list;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
