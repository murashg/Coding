/* Greg Murashige


Given a string that contains a single pair of parenthesis,
compute recursively a new string made of only of the parenthesis
and their contents, so "xyz(abc)123" yields "(abc)".


parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"
*/

public String parenBit(String str) {
  //parens are somewhere in the middle of the string always
  //so lets close in on them from both sides at the same time
  //all we need are our base cases when they are found.
  //we always need position of last char so lets get that at the start
  int l = str.length() - 1;
  //parens are on start and end, we are done
  if (str.charAt(0) == '(' && str.charAt(l) == ')') return str;

  //paren is at start of string, close in on end
  if (str.charAt(0) == '(') return parenBit(str.substring(0,l));

  //paren is at end of string, close in on start
  if (str.charAt(l) == ')') return parenBit(str.substring(1));

  //paren is somewhere in the middle
  return parenBit(str.substring(1,l));
}
