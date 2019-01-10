/* Greg Murashige

The member states of the UN are planning to send 2 people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

For example, we have the following data on 2 pairs of astronauts, and 4 astronauts total, numbered 0 through 3.

1   2
2   3

Astronauts by country are [0] and [1,2,3]. There are 3 pairs to choose from: [0,1],[0,2] and [0,3].

Function Description

Complete the journeyToMoon function in the editor below. It should return an integer that represents the number of valid pairs that can be formed.

journeyToMoon has the following parameter(s):

n: an integer that denotes the number of astronauts
astronaut: a 2D array where each element astronaut[i] is a 2 element integer array that represents the ID's of two astronauts from the same country
Input Format

The first line contains two integers n and p, the number of astronauts and the number of pairs.
Each of the next p lines contains 2 space-separated integers denoting astronaut ID's of two who share the same nationality.

Constraints

1 <= n <= 10^5
1 <= p <= 10^4

Output Format

An integer that denotes the number of ways to choose a pair of astronauts from different coutries.

Sample Input 0

5 3
0 1
2 3
0 4
Sample Output 0

6
Explanation 0

Persons numbered [0,1,4] belong to one country, and those numbered [2,3] belong to another. The UN has 6 ways of choosing a pair:
[0,2],[0,3],[1,2],[1,3],[4,2],[4,3]

Sample Input 1

4 1
0 2
Sample Output 1

5
Explanation 1

Persons numbered [0,2] belong to the same country, but persons 1 and 3 don't share countries with anyone else. The UN has 5 ways of choosing a pair:
[0,1],[0,3],[1,2],[1,3],[2,3]

*/

import java.io.*;
import java.util.*;

public class JourneyToTheMoon {

    static int n; //number of astronauts
    static LinkedList<Integer> adj[]; //adj used to connect astronauts sharing a country
    static int[][] astronaut; //our input array of astronaut pairs

    /* 1st create an adjacency list representing which astronauts are paired
     * with each other, this will be used to assemble our countrys, then those
     * countries are used in the final calculation of how many pairs of Astronauts
     * we have.  Final return type is long to avoid overflow
     */
    static long journeyToMoon() {
        createAdjList();
        return calculateAstronautPairs(assembleCountries());
    }

    /* final output is calculated by all the possible combinations of pairs with
     * the condition that astronauts must come from different countries.
     * We have a list of countries each containing a list of astronauts.
     * The total pairs of astronauts possible will be the sum of  the number of
     * astronauts we have previously seen, times how many astronauts we have in
     * the current country, looped for every country.
     */
    static long calculateAstronautPairs(List<List<Integer>> countries){
        long previousAstronauts = 0;
        long totalPairs = 0;
        for (List<Integer> astronauts : countries) {
            long astronautsInCountry = (long) astronauts.size();
            totalPairs += previousAstronauts * astronautsInCountry;
            previousAstronauts += astronautsInCountry;
        }
        return totalPairs;
    }

    /* Every astronaut has to have a country, every astronaut has to
     * be in only one country.  We have multiple countries with 1 to many
     * astronauts.  Here countries is self explainatory, and visited is
     * representing all of our astronauts and whether they have been placed
     * into a country.  a will be used to iterate through our visited array
     * till all astronauts have been put into countries.  The placing of
     * astronauts uses a depth first search through our adjacency list which
     * will find all astronauts in a specific country.
     */
    static List<List<Integer>> assembleCountries(){
        List<List<Integer>> countries = new LinkedList<List<Integer>>();
        boolean[] visited = new boolean[n];
        int a = 0;
        while (a < n){
            if (!visited[a]) countries.add(dfs(a,visited));
            a++;
        }
        return countries;
    }

    /* The adjacency list that is described by the int[][] astronaut
     * for instance the pair 1 2 means that astronaut[1] shares a country
     * with astronaut[2]. so because we don't know where we will end up
     * being in the depth first search, it is best to connect the Astronauts
     * both ways, ex. pair 1 2 will have adj[1].add(2) and adj[2].add(1) that
     * way we can get to either astronaut from one another.  It is possible that
     * multiple astronauts will be connected.  That is handled fine by connections
     * having a data structure of a LinkedList. Also we create adj to have an
     * entry for every astronaut, that way we can jump to the index of an certain
     * astronaut to examine what connections he has.
     */
    static void createAdjList(){
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) adj[i] = new LinkedList();
        for (int[] pair : astronaut) {
            adj[pair[0]].add(pair[1]);
            adj[pair[1]].add(pair[0]);
        }
    }

    /* DEPTH FIRST SEARCH
     * Here we are taking the starting Astronaut(v) and adding him to
     * a country(LinkedList), then recursively traversing his connections(adj)
     * each time we go to an astronaut we mark him as visited, then add him to
     * the country.
     */
    static List<Integer> dfs(int v, boolean[] visited){
        List<Integer> list = new LinkedList<Integer>();
        visited[v] = true;
        list.add(v);
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int j = i.next();
            if (!visited[j]) list.addAll(dfs(j, visited));
        }
        return list;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /* Read input file and output the number of pairs of Astronauts
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon();

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
