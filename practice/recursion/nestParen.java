/* Greg Murashige

Now with 100% more comments!

Given a string, return true if it is a nesting of zero or more
pairs of parenthesis, like "(())" or "((()))". Suggestion: check
the first and last chars, and then recur on what's inside them.

nestParen("(())") → true
nestParen("((()))") → true
nestParen("(((x))") → false
*/

public boolean nestParen(String str) {
  //parens will always match on the outside
  //we will be using the last character a lot so lets find that
  int l = str.length() - 1;

  //empty string
  if (str.equals("")) return true;

  //parens on the inside with nothing in the middle
  if (str.charAt(0) == '(' && str.charAt(l) == ')' && l == 1) return true;

  //we are in the middle without 2 parens
  if (l == 1) return false;

  //we are not at the middle, we need parens to move closer
  if (str.charAt(0) == '(' && str.charAt(l) == ')') return nestParen(str.substring(1,l));

  //there is character other than paren in there;
  return false;
}
