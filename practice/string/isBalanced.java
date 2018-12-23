/* Greg Murashige

A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.
*/


import java.util.*;
class Solution{

    private static boolean isBalanced(String s){
        Deque<Character> stack = new ArrayDeque<Character>();
        char[] line = s.toCharArray();
        for (char c : line) {
            try{
                if (c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else if (c == ')'){
                    if ((char)stack.pop() != '(') return false;
                }else if (c == '}'){
                    if ((char)stack.pop() != '{') return false;
                }else{
                    if ((char)stack.pop() != '[') return false;
                }
            }catch (Exception e){
                return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            if (isBalanced(input)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

		}
        sc.close();

	}
}
