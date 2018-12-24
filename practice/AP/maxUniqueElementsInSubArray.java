/* Greg Murashige

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
You can find more details about Deque here.

In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is 3 second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input

6 3
5 3 5 2 3 2
Sample Output

3

*/

import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //number of elements
        int m = in.nextInt(); //size of subarray

        Deque deque = new ArrayDeque<Integer>(m); //queue for keeping track of subarrays
        HashSet<Integer> set = new HashSet<Integer>(m); //hashset for keeping track of unique elements

        for (int i = 0; i < m; i++){ //initialize queue and set
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
        }

        int max = set.size();
        for (int i = m; i < n; i++) {
            if (max == m) break; //max size can not be larger, we are done
            int num = in.nextInt();
            int first = (int)deque.remove();
            deque.add(num);

            if(!deque.contains(first)) set.remove(first); //removed element not in subarray, so we remove it from unique element set
            if (set.add(num)) if (set.size() > max) max++; //if we added new element, see if we have new max
        }

        in.close();
        System.out.println(max);
    }
}
