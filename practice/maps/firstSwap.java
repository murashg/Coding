/* Greg Murashige

  didn't use the private method this time.


We'll say that 2 strings "match" if they are non-empty and their first
chars are the same. Loop over and then return the given array
of non-empty strings as follows: if a string matches an earlier
string in the array, swap the 2 strings in the array. A particular
first char can only cause 1 swap, so once a char has caused a swap,
its later swaps are disabled. Using a map, this can be solved
making just one pass over the array. More difficult than it looks.


firstSwap(["ab", "ac"]) → ["ac", "ab"]
firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
*/

public String[] firstSwap(String[] strings) {
  int i = 0;

  Map<String, Integer> map = new HashMap<String, Integer>();

  for (String s : strings){
    String first = String.valueOf(s.charAt(0));
    if (!map.containsKey(first)){
      map.put(first,i); //map.get(first) is the index of first string is
    }else if(map.get(first) != -1 ){ //char has not already been swapped, lets swap
      String temp = strings[map.get(first)];
      strings[map.get(first)] = strings[i];
      strings[i] = temp;

      map.put(first,-1); //use -1 to denote string has been swapped
    }

    i++;
  }

  return strings;
}
