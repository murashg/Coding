/* Greg Murashige


We'll say that 2 strings "match" if they are non-empty and their
first chars are the same. Loop over and then return the given
array of non-empty strings as follows: if a string matches an
earlier string in the array, swap the 2 strings in the array.
When a position in the array has been swapped, it no longer
matches anything. Using a map, this can be solved making just
one pass over the array. More difficult than it looks.


allSwap(["ab", "ac"]) → ["ac", "ab"]
allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]

*/

public String[] allSwap(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();

  int index = 0;
  for (String s : strings){
    String first = String.valueOf(s.charAt(0));
    if (!map.containsKey(first)){
      map.put(first,index);
    }else{
      swap(strings,map.get(first),index);
      map.remove(first);
    }
    index++;
  }
  return strings;
}

private String[] swap(String[] strings, int a, int b){
  String temp = strings[a];
  strings[a] = strings[b];
  strings[b] = temp;
  return strings;
}
