/*Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest.

Example 1:
Input: ["hi", "love", "leetcode", "hi", "love", "coding","hi"], k = 2
Output: ["hi", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.

Extra: If two words have the same frequency, then the word with the lower alphabetical order comes first.*/
/*
 * store words in a map where key is the word, and frequency is value
 * store frequency in a map where key is freq,
 *
 */
class Pair implements Comparator{
  String word;
  int freq;
  Pair(String w, int fre){
    word = w;
    freq = fre;
  }

  compare(Pair p1, Pair p2){
    if (p1.fre > p2.fre){
      return 1;
    }else if (p1.fre < p2.fre){
      return -1;
    }
    return 0;
  }
}

//O(nlgn) runtime O(n) space

public List<String> topKFrequent(String[] words, int k) {
  Map<String,Integer> wordMap = new HashMap<String,Integer>();
  List<Pair> wordFreqList = new ArrayList<Pair>(words.length());
  List<String> result = new ArrayList<String>(k);
  for (String word : words){
    if (!wordMap.containsKey(word)){
      wordMap.put(word,1);
    }else{
      wordMap.put(word,wordMap.get(word)+1);
    }
  }
  for (Map.Entry<String,Integer> entry : wordMap.entrySet()){
    wordFreqList.add(new Pair(entry.getKey(),entry.getValue()));
  }
  Collections.sort(wordFreqList);
  for (int i = 0; i < k; i++){
    result.add(wordFreqList.get(i));
  }
  return result;
}

table item1 name list all duplicate names

SELECT COUNT(NAME) AS NAMECOUNT, NAME
FROM ITEM1
WHERE NAMECOUNT > 1

  employee									employeeaddress
  employeeid employeename  employeeid employee address

  SELECT EMPOLOYEE.EMPLOYEENAME, EMPLOYEE.EMPLOYEEID, EMPLOYEEADDRESS.EMPLOYEEADDRESS
  FROM EMPLOYEE
  WHERE EMPLOYEEADDRESS.EMPLOYEEADDRESS != NULL
  INNER JOIN EMPOLYEEADDRESS ON EMPOLOYEE.EMPLOYEEID=EMPOLOYEEADDRESS.EMPLOYEEID
