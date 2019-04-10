/* Greg Murashige

    Josephus is in a delema.  He is surrounded by Roman soldiers facing immenant capture.  He and his (n) friends
    will do anything to avoid capture including ending their lives, however it is against their religion to take
    their own life.  Faced with this they decide that they will form a circle and by killing the person to the
    left of them (starting with person 1 kills person 2...) they will fairly all avoid capture except for the one
    left at the end who will then have to commit suicide.
    Josephus however thinks that capture is better than suicide, but doesn't know which position in the circle to stand
    to insure that he lives.

    Example, say we have 5 people including Josephus.  1 will kill 2, 3 will kill 4, 5 will kill 1 and 3 will kill 5,
    therefore Josephus would want to be the 3rd person in the circle to avoid dying.

    Your problem is to find an algorithm that would output which seat Josephus should choose given any Integer n
 */

import java.util.LinkedList;
import java.util.List;

public class josephus {

    private static int algorithmicSolution(int n){
        List<Integer> soldiers = new LinkedList<Integer>();
        int i = 1;
        while (i <= n){
            soldiers.add(i);
            i++;
        }
        i = 0;
        while (soldiers.size() > 1){
            soldiers.remove(i+1);
            i++;
            if (i == soldiers.size()){
                i = 0;
            }else if (i == soldiers.size()-1) i = -1;
        }
        return soldiers.get(0);
    }
    /*
     *   f(N) = 2L + 1 where N =2^M + L and 0 <= L < 2^M
     */
    private static int mathematicalSolution(int n){
        // find value of L for the equation
        int valueOfL = n - Integer.highestOneBit(n);
        int safePosition = 2 * valueOfL  + 1;

        return safePosition;
    }

    private static int blackMagic(int n){
        return ~Integer.highestOneBit(n*2) & ((n<<1) | 1);
    }

    private static void test(int n){
        System.out.println("TEST "+n);
        long startTime,endTime,duration;
        startTime = System.nanoTime();
        System.out.println("algorithm "+algorithmicSolution(n));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Method took: " + duration+"ns");
        startTime = System.nanoTime();
        System.out.println("maths "+mathematicalSolution(n));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Method took: " + duration+"ns");
        startTime = System.nanoTime();
        System.out.println("blackmagic "+blackMagic(n));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Method took: " + duration+"ns");
        System.out.println("\n");
    }

    public static void main(String[] args){
        test(32);
        test(45);
        test(1547);
        test(12398);
    }
}
