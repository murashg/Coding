""" Greg Murashige

Given an int array length 2, return True if it contains a 2 or a 3.


has23([2, 5]) → True
has23([4, 3]) → True
has23([4, 5]) → False

"""

def has23(nums):
  for n in nums:
    if n == 2 or n == 3:
      return True
  return False
