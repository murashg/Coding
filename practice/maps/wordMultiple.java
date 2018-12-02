/*
  I'm tricky

  Given an array of strings, return a Map<String, Boolean>
  where each different string is a key and its value is true
  if that string appears 2 or more times in the array.


wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}
*/

public Map<String, Boolean> wordMultiple(String[] strings) {
  Map<String, Boolean> map = new HashMap<String, Boolean>();

  for (String s : strings){
    if (!map.containsKey(s)){
      map.put(s,false);
    }else{
      if(!map.get(s)){ //rather proud of this one
        map.put(s,true);
      }
    }
  }

  return map;
}
