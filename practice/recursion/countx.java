/*
  I guess that substring goes from from the first to the
  second parameter str.substring(0,10) str[0] - str[9] ?


Given a string, compute recursively (no loops) the number of
lowercase 'x' chars in the string.


countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0
*/

public int countX(String str) {

  if (str.length() == 0) return 0;
  if (str.length() == 1){
    if (str.equals("x")) return 1;
    return 0;
  }
  int x = 0;
  //this string logic is just the worst, thanks java
  if (String.valueOf(str.charAt(str.length()-1)).equals("x")){
    x = 1;
  }
  int count = x + countX(str.substring(0,str.length()-1));
  return count;

}
