/* Greg Murashige

Given 3 int values, a b c, return their sum. However, if one of
the values is the same as another of the values, it does not count
towards the sum.


loneSum(1, 2, 3) → 6
loneSum(3, 2, 3) → 2
loneSum(3, 3, 3) → 0

*/

public int loneSum(int a, int b, int c) {
  HashSet<Integer> set = new HashSet<Integer>();
  int sum = 0;
  if (a == b && b == c && c == a) {
    return 0;
  }
  if (!set.contains(a)){
    set.add(a);
    sum += a;
  }
  if (!set.contains(b)){
    set.add(b);
    sum += b;
  }else{
    sum -= b;
  }
  if (!set.contains(c)){
    set.add(c);
    sum += c;
  }else{
    sum -= c;
  }
  return sum;
}
