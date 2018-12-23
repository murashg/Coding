/* Greg Murashige

The O(n) solution using check sum.  happy with this one

Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

Input Format

The first line contains a string denoting .
The second line contains a string denoting .

Constraints

Strings  and  consist of English alphabetic characters.
The comparison should NOT be case sensitive.
Output Format

Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.

Sample Input 0

anagram
margana
Sample Output 0

Anagrams
*/

import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    static boolean isAnagram(String a, String b) {
        //check a and b have the same length
        if (a.length() != b.length()) return false;

        //check that a and b have the same characters
        HashSet<Character> set = new HashSet<Character>(a.length());
        for (char c : a.toCharArray()){
          if (!set.contains(c)){
            set.add(c);
          }
        }
        for (char c : b.toCharArray()){
          if (!set.contains(c)) return false;
        }

        //compute checksum
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
