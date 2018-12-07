""" Greg Murashige
Return the number of times that the string "code" appears
anywhere in the given string, except we'll accept any letter
for the 'd', so "cope" and "cooe" count.


count_code('aaacodebbb') → 1
count_code('codexxcode') → 2
count_code('cozexxcope') → 2
"""

def count_code(str):
  if len(str) < 4:
    return 0
  if str[:2] == "co" and str[3] == "e":
    return 1 + count_code(str[1:])
  return count_code(str[1:])
