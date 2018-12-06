/* Greg Murashige


Given a string, return a string where for every char in the
original, there are two chars.


doubleChar("The") → "TThhee"
doubleChar("AAbb") → "AAAAbbbb"
doubleChar("Hi-There") → "HHii--TThheerree"
*/
public String doubleChar(String str) {
  if (str.isEmpty()) return str;

  String lastChar = String.valueOf(str.charAt(str.length()-1));
  lastChar += lastChar; //double the last char

  return (doubleChar(str.substring(0, str.length()-1)) +  lastChar);
}
