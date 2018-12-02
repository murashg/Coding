/*
  Much cleaner this time, turns out first param of substring
  is the starting index, second is the amount of chars in the
  substring.  Also, it is easier recursing through strings starting
  at the front rather than the back.

  Given a string, compute recursively (no loops) the number
  of times lowercase "hi" appears in the string.


countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1
*/

public int countHi(String str) {
  if (str.length() <= 1) return 0;
  if (str.length() == 2){
    if (str.equals("hi")) return 1;
    return 0;
  }
  int hi = 0;
  //not as bad as single characters
  if (str.substring(0,2).equals("hi")){
    hi = 1;
  }
  int count = hi + countHi(str.substring(1,str.length()));
  return count;
}
