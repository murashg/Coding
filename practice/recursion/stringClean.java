/* Greg Murashige

Given a string, return recursively a "cleaned" string where
adjacent chars that are the same have been reduced to a single
char. So "yyzzza" yields "yza".


stringClean("yyzzza") → "yza"
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"
*/

public String stringClean(String str) {
  if (str.length() == 1) return str;
  if (str.length() == 2){
    if (str.charAt(0) == str.charAt(1)){
      return str.substring(1);
    }
  }
  if (str.charAt(0) == str.charAt(1)){
    return stringClean(str.substring(1));
  }
  return str.substring(0,1) + stringClean(str.substring(1));
}

/* kotlin
fun stringClean(str: String): String {
    return when {
        str.length == 1 -> str
        str.length == 2 && str[0] == str[1] -> str.substring(1)
        str[0] == str[1] -> stringClean(str.substring(1))
        else -> str[0] + stringClean(str.substring(1))
    }
}
*/
