/* Greg Murashige

This was my first attempt, algorithm works but is really
space inefficient.  Will have to improve.

We want to make a row of bricks that is goal inches long. We have a
number of small bricks (1 inch each) and big bricks (5 inches each).
Return true if it is possible to make the goal by choosing from the
given bricks. This is a little harder than it looks and can be done
without any loops.


makeBricks(3, 1, 8) → true
makeBricks(3, 1, 9) → false
makeBricks(3, 2, 10) → true
*/

public boolean makeBricks(int small, int big, int goal) {
  if (goal == 0){
    return true;
  }else if (small == 0 && big == 0){
    return false;
  }else if (small == 0){
    return makeBricks(small,big-1,goal-5);
  }else if (big == 0){
    return makeBricks(small-1,big,goal-1);
  }
  return (makeBricks(small-1,big,goal-1) || makeBricks(small,big-1,goal-5));
}
