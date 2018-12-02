/* Greg Murashige


Loop over the given array of strings to build a result string
like this: when a string appears the 2nd, 4th, 6th, etc. time
in the array, append the string to the result. Return the empty
string if no string appears a 2nd time.


wordAppend(["a", "b", "a"]) → "a"
wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
wordAppend(["a", "", "a"]) → "a"

*/

public String wordAppend(String[] strings) {

  //count words
  Map<String, Integer> wordCount = new HashMap<String, Integer>();
  String wordAppend = "";
  for (String s : strings){
    if (wordCount.containsKey(s)){
      wordCount.put(s,wordCount.get(s)+1);
      if (wordCount.get(s)%2 == 0){
        wordAppend += s;
      }
    }else{
      wordCount.put(s,1);
    }
  }

  return wordAppend;
}
