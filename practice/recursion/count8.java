/*
Just like count7 with an extra step

Given a non-negative int n, compute recursively (no loops) the
count of the occurrences of 8 as a digit, except that an 8 with
another 8 immediately to its left counts double, so 8818 yields
4. Note that mod (%) by 10 yields the rightmost digit (126 % 10
is 6), while divide (/) by 10 removes the rightmost digit (126
/ 10 is 12).


count8(8) → 1
count8(818) → 2
count8(8818) → 4
*/

public int count8(int n) {
  if (n < 100){
    if(n%100 == 88){
      return 3;
    }else if(n < 10){
      if (n%10 == 8){
        return 1;
      }
      return 0;
    }
  }

  //double eights are worth 2
  int eights = 0;
  if (n%100 == 88){
    eights = 2;
  }else if (n%10 == 8){
    eights = 1;
  }

  int count = eights + count8(n/10);

  return count;
}

/* Kotlin
fun count8(n: Int): Int {
    return when {
        n < 100 -> if (n % 100 == 88) 3 else if (n < 10 && n % 10 == 8) 1 else 0
        else -> {
            when {
                n % 100 == 88 -> 2 + count8(n/10)
                n % 10 == 8 -> 1 + count8(n/10)
                else -> count8(n/10)
            }
        }
    }
}
*/
