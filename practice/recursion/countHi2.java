/* Greg Murashige
Given a string, compute recursively the number of times lowercase
"hi" appears in the string, however do not count "hi" that have an
'x' immedately before them.


countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0
*/

public int countHi2(String str) {

  //base cases for length 0-3
  if (str.length() <= 1) return 0;
  if (str.length() == 2){
    if (str.substring(0,2).equals("hi")){
      return 1;
    }else{
      return 0;
    }
  }
  if (str.length() == 3){
    if (str.substring(0,3).matches("hi.|([^x]hi)")){ //regex :)
      return 1;
    }else{
      return 0;
    }
  }
  //iterate through from back to front
  int c = 0;
  if (str.substring(str.length()-3,str.length()).matches("[^x]hi")){
    c++;
  }
  return (c + countHi2(str.substring(0,str.length()-1)));
}
