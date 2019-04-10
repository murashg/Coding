import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class skyscrapers {

    // Complete the solve function below.
    static int solve(int[] arr) {
        int paths = 0;
        Deque<Integer> skyline = new ArrayDeque<Integer>();
        int a = 0;
        for (int n : arr){
            if (skyline.peekFirst() == null) {
                skyline.add(n);
            }
            if (a > 0) {

                while (n > skyline.peekLast()) {
                    skyline.remove();
                }
                if (n == skyline.peekLast()) {
                    int count = 0;
                    while (n == skyline.remove()) {
                        count++;
                    }
                    paths += count * 2;
                    for (int i = 0; i < count + 1; i++) {
                        skyline.add(n);
                    }
                }
                if (n < skyline.peekLast()) {
                    skyline.add(n);
                }
            }
            a++;
        }
        return paths;
    }
    /*
        3 2 1 2 3 3


        i = 0 peek()stack empty    3 push  stack 3
        i = 1 peek() n < 3         2 push  stack 2 3
        i = 2 peek() n < 2         1 push  stack 1 2 3
        i = 3 peek() n > 1         pull()  stack 2 3
        i = 4 peek() n == 2        count += 2 * how many 2's on stack (1) then push stack 2 2 3
        i = 5 peek() n > 2         pull()  stack 2 3
        i = 5 peek() n > 2         pull()  stack 3
        i = 5 peek() n == 3        count += 2 * how many 2's on stack (1) then push stack 3 3
        i = 6 peek() n == 3        count += 2 * how many 2's on stack (2) then push stack 3 3 3
    */
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int result = solve(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
