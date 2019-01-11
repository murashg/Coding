import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    //simple.  count possible exits.  count deadly areas.  those are possible outcomes.
    static int n,m,k;
    static char[][] frogDungeon;
    static int[][] tunnels;
    LinkedList<Character> adj[][];
    static boolean[][] visited;
    static double[] escapeOrDie;

    private static double traverseMaze(){

        convertDeadlyTunnels();
        convertTunnels();
        /* print converted dungeon
        for (char[] row : frogDungeon){
            for (char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
        */

        List<List<Integer>> starts = findStarts();
        DFS(starts);
        if (escapeOrDie[0] == 0.0) return 0.0;
        if (escapeOrDie[1] == 0.0) return 1.0;
        return escapeOrDie[0]/(escapeOrDie[0]+escapeOrDie[1]);

        //return 0.0;
    }

    private static void convertDeadlyTunnels(){
        for (int[] tunnel : tunnels){
            int[] entrance = Arrays.copyOfRange(tunnel,0,2);
            int[] exit = Arrays.copyOfRange(tunnel,2,4);
            //System.out.println(entrance[0]+ " "+ entrance[1]);
            //System.out.println(exit[0]+ " "+ exit[1]);
            if (checkTunnel(exit)){
                frogDungeon[entrance[0]][entrance[1]] = '*';
            }else if (checkTunnel(entrance)){
                frogDungeon[exit[0]][exit[1]] = '*';
            }
        }
    }

    private static boolean checkTunnel(int[] tunnel){
        int i = tunnel[0];
        int j = tunnel[1];
        //System.out.println(i + " " + j + " " + n + " " + m);
        //top left
        if (i == 0 && j == 0){
            //System.out.println("top left" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*')){
                return true;
            }
        }
        //top right
        else if (i == 0 && j == m - 1){
            //System.out.println("topright" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        //bottom left
        else if (i == n - 1 && j == 0){
            //System.out.println("bottomLeft" + i + " " + j);
            if ((frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*')){
                return true;
            }
        }
        //bottom right
        else if (i == n - 1 && j == m - 1){
            //System.out.println("bottomright" + i + " " + j);
            if ((frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        //top
        else if (i == 0){
            System.out.println("top" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        //left
        else if (j == 0){
            //System.out.println("left" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*')){
                return true;
            }
        }
        //right
        else if (j == m - 1){
            //System.out.println("right" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        //bottom
        else if (i == n - 1){
            //System.out.println("bottom" + i + " " + j);
            if ((frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        //middle
        else {
            //System.out.println("middle" + i + " " + j);
            if ((frogDungeon[i+1][j] == '#' || frogDungeon[i+1][j] == '*') &&
                (frogDungeon[i-1][j] == '#' || frogDungeon[i-1][j] == '*') &&
                (frogDungeon[i][j+1] == '#' || frogDungeon[i][j+1] == '*') &&
                (frogDungeon[i][j-1] == '#' || frogDungeon[i][j-1] == '*')){
                return true;
            }
        }
        return false;
    }

    private static void convertTunnels(){
        for (int[] tunnel : tunnels){
            if (frogDungeon[tunnel[0]][tunnel[1]] == 'O'){
                frogDungeon[tunnel[0]][tunnel[1]] = 'T';
            }
            if (frogDungeon[tunnel[2]][tunnel[3]] == 'O'){
                frogDungeon[tunnel[2]][tunnel[3]] = 'E';
            }
        }
    }

    private static List<List<Integer>> findStarts(){
        List<List<Integer>> starts = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (frogDungeon[i][j] == 'A'){
                    ArrayList<Integer> start = new ArrayList<Integer>(2);
                    start.add(i);
                    start.add(j);
                    starts.add(start);
                }
            }
        }
        return starts;
    }

    private static void DFS(List<List<Integer>> starts){
        escapeOrDie = new double[]{0.0,0.0};
        //System.out.println(escapeOrDie[0] + " " + escapeOrDie[1] + "DFS");
        for (List<Integer> start : starts){
            int[] v = new int[]{start.get(0),start.get(1)};
            visited = new boolean[n][m];
            //printVisited();
            makeWallsVisited();
            //printVisited();
            dfsUtil(v);
            //printVisited();
        }
    }

    private static void makeWallsVisited(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (frogDungeon[i][j] == '#')
                    visited[i][j] = true;
            }
        }
    }

    private static void printVisited(){
        System.out.println("--Visited--");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(visited[i][j] ? "1 ":"0 ");
            }
            System.out.println();
        }
    }

    private static void dfsUtil(int[] start){
        int i = start[0];
        int j = start[1];
        int[] up = new int[]{i-1,j};
        int[] down = new int[]{i+1,j};
        int[] left = new int[]{i,j-1};
        int[] right = new int[]{i,j+1};
        visited[i][j] = true;
        //System.out.println(escapeOrDie[0] + " " + escapeOrDie[1] + "dfsUtil");
        //System.out.println(frogDungeon[i][j] + " " + i + " " + j);
        if (frogDungeon[i][j] == 'O' || frogDungeon[i][j] == 'A'){
            if (i > 0 && i < n - 1 && j > 0 && j < m - 1){ //middle
                if (!visited[i-1][j])
                    dfsUtil(up); //up
                if (!visited[i+1][j])
                    dfsUtil(down); //down
                if (!visited[i][j-1])
                    dfsUtil(left); //left
                if (!visited[i][j+1])
                    dfsUtil(right); //right
            }else if (i == 0 && j == 0){ //top left
                if (!visited[i+1][j])
                    dfsUtil(down);
                if (!visited[i][j+1])
                    dfsUtil(right);
            }else if (i == 0 && j == m - 1){ //top right
                if (!visited[i+1][j])
                    dfsUtil(down);
                if (!visited[i][j-1])
                    dfsUtil(left);
            }else if (i == n - 1 && j == 0){ //bottom left
                if (!visited[i-1][j])
                    dfsUtil(up);
                if (!visited[i][j+1])
                    dfsUtil(right);
            }else if (i == n - 1 && j == m - 1){ //bottom right
                if (!visited[i-1][j])
                    dfsUtil(up);
                if (!visited[i][j-1])
                    dfsUtil(left);
            }else if (i == 0){ //top
                if (!visited[i+1][j])
                    dfsUtil(down);
                if (!visited[i][j-1])
                    dfsUtil(left);
                if (!visited[i][j+1])
                    dfsUtil(right);
            }else if (i == n - 1){ //bottom
                if (!visited[i-1][j])
                    dfsUtil(up);
                if (!visited[i][j-1])
                    dfsUtil(left);
                if (!visited[i][j+1])
                    dfsUtil(right);
            }else if (j == 0){ //left
                if (!visited[i-1][j])
                    dfsUtil(up);
                if (!visited[i+1][j])
                    dfsUtil(down);
                if (!visited[i][j+1])
                    dfsUtil(right);
            }else if (j == m - 1){ //right
                if (!visited[i-1][j])
                    dfsUtil(up);
                if (!visited[i+1][j])
                    dfsUtil(down);
                if (!visited[i][j-1])
                    dfsUtil(left);
            }
        }else if (frogDungeon[i][j] == 'T'){
            for (int[] tunnel : tunnels){
                if (tunnel[0] == i && tunnel[1] == j){
                    if (!visited[tunnel[2]][tunnel[3]])
                        frogDungeon[tunnel[2]][tunnel[3]] = 'O';
                        dfsUtil(new int[]{tunnel[2],tunnel[3]});
                    break;
                }
            }
        }else if (frogDungeon[i][j] == 'E'){
            for (int[] tunnel : tunnels){
                if (tunnel[2] == i && tunnel[3] == j){
                    if (!visited[tunnel[0]][tunnel[1]])
                        frogDungeon[tunnel[0]][tunnel[1]] = 'O';
                        dfsUtil(new int[]{tunnel[0],tunnel[1]});
                    break;
                }
            }
        }else if (frogDungeon[i][j] == '%') {
            escapeOrDie[0] += 1.0; //escaped :)
        }else if (frogDungeon[i][j] == '*') escapeOrDie[1] += 1.0; //died :(
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmk = scanner.nextLine().split(" ");

        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);

        frogDungeon = new char[n][m];

        for (int nItr = 0; nItr < n; nItr++) {
            String row = scanner.nextLine();
            int i = 0;
            for (char c : row.toCharArray()){
                frogDungeon[nItr][i] = c;
                i++;
            }
        }
        tunnels = new int[k][4];
        for (int kItr = 0; kItr < k; kItr++) {
            String[] i1J1I2J2 = scanner.nextLine().split(" ");

            int i1 = Integer.parseInt(i1J1I2J2[0]);
            int j1 = Integer.parseInt(i1J1I2J2[1]);
            int i2 = Integer.parseInt(i1J1I2J2[2]);
            int j2 = Integer.parseInt(i1J1I2J2[3]);

            tunnels[kItr][0] = i1 - 1;
            tunnels[kItr][1] = j1 - 1;
            tunnels[kItr][2] = i2 - 1;
            tunnels[kItr][3] = j2 - 1;

        }

        System.out.println(traverseMaze());

        scanner.close();
    }
}
