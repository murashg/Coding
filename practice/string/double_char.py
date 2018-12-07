""" Greg Murashige
Recursion because.


Given a string, return a string where for every char in the
original, there are two chars.


double_char('The') → 'TThhee'
double_char('AAbb') → 'AAAAbbbb'
double_char('Hi-There') → 'HHii--TThheerree'
"""

def double_char(str):
  if len(str) == 0:
    return str
  return str[0] + str[0] + double_char(str[1:])
