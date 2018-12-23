/* Greg Murashige

Did some extra work for the practice.

Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.

Take your input from System.in.

Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

Constraints

Each number will fit in signed integer.
Total number of integers in  lines will not cross .

Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> dataTable = new ArrayList<List<Integer>>(n);

        while (n-- > 0){
            int d = scan.nextInt();
            List<Integer> data = new ArrayList<Integer>(d);
            while (d-- > 0){
                data.add(scan.nextInt());
            }
            dataTable.add(data);
        }

        int q = scan.nextInt();

        while (q-- > 0){
            int y = scan.nextInt();
            int x = scan.nextInt();
            y--;
            x--;
            try{
                System.out.println(dataTable.get(y).get(x));
            }catch (Exception e){
                System.out.println("ERROR!");
            }

        }
        scan.close();

    }
}
