/* Greg Murashige


Return the number of times that the string "hi" appears
anywhere in the given string.


countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
*/

public int countHi(String str) {
  int size = str.length();
  int hiC = 0;
  if (str.isEmpty()) return 0;
  for (int i = 0; i < size - 1; i++){
    if (str.substring(i,i+2).equals("hi")) hiC++;
  }
  return hiC;
}
