/* Greg Murashige

Are hashmaps cheating?

Consider the leftmost and righmost appearances of some value in an
array. We'll say that the "span" is the number of elements between
the two inclusive. A single value has a span of 1. Returns the
largest span found in the given array. (Efficiency is not a priority.)


maxSpan([1, 2, 1, 1, 3]) → 4
maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
*/

public int maxSpan(int[] nums) {
  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  int i = 0;
  int span = 0;
  for (int n : nums){
    if (!map.containsKey(n)){
      map.put(n,i);
    }
    if (span <= i-map.get(n)){
        span = (i - map.get(n)) + 1;
    }
    i++;
  }

  return span;
}
