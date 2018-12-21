/* Greg Murashige
Two strings, a and b, are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

Input Format

The first line contains a string denoting .
The second line contains a string denoting .

Constraints
1 <= length(a), length(b) <= 50
Strings a and b consist of English alphabetic characters.
The comparison should NOT be case sensitive.
Output Format

Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.
*/

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) return false;

        //convert strings to lowercase, then convert to int
        byte[] aSum = a.toLowerCase().getBytes();
        byte[] bSum = b.toLowerCase().getBytes();
        int aInt = 0;
        int bInt = 0;
        for (byte aByte : aSum){
            aInt += (int)aByte;
        }
        for (byte bByte : bSum){
            bInt += (int)bByte;
        }
        //compare stings values to see if words are anagrams
        if (aInt == bInt) return true;
        return false;

    }

  public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
