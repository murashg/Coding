/*
Note to self.  Don't use mod 7 when looking at rightmost digit...

Given a non-negative int n, return the count of the occurrences of 7
as a digit, so for example 717 yields 2. (no loops). Note that mod
(%) by 10 yields the rightmost digit (126 % 10 is 6), while divide
(/) by 10 removes the rightmost digit (126 / 10 is 12).


count7(717) → 2
count7(7) → 1
count7(123) → 0
*/

public int count7(int n) {
  //check base digit for 7
  if (n < 10){
    if (n%10 == 7){
      return 1;
    }
    return 0;
  }
  //add 1 if right most digit is 7
  int t = 0;
  if (n%10 == 7){
    t = 1;
  }
  //recursive step
  int count = t + count7(n/10);

  return count;
}
