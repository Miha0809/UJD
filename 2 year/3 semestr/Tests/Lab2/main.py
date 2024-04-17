import math
from typing import Optional

def _max(*args: int) -> Optional[int]:
    '''Returns maximum value or None if there are no arguments'''
    if len(args) > 0:
        return max(args)

    return None

def _min(*args: int) -> Optional[int]:
    '''Returns minimum value or None if there are no arguments'''
    if len(args) > 0:
        return min(args)

    return None

def sign(val: int) -> Optional[int]:
    '''Returns -1 if lavue is less then 0, 1 if value is greater than 0, 0 if value is zero'''
    if val > 0:
        return 1
    elif val == 0:
        return 0
    elif val < 0:
        return -1

print(sign(-10))
def avg(*args: int) -> Optional[int]:
    '''Returns average value of the list of value'''
    return (sum(args) / len(args))

def median(*args: int) -> Optional[int]:
    '''Returns the median of the unsorted list of values'''
    return args[math.floor(len(args) / 2)]
