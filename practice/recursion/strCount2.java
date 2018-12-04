/* Greg Murashige

Given a string and a non-empty substring sub, compute recursively
the number of times that sub appears in the string, without the sub
strings overlapping.


strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0
*/

public int strCount(String str, String sub) {
  int sl = sub.length();
  //will be using string length to recurse
  int l = str.length();
  //empty string
  if (str.equals("")) return 0;

  //if string size of sub
  if (l < sl){
    return 0;
  }

  //we find a sub, add 1, move to remainder of string
  if (str.substring(0,sl).equals(sub))
    return (1 + strCount(str.substring(sl,l),sub));

  //we didn't find sub, move to next letter
  return strCount(str.substring(1,l),sub);
}
