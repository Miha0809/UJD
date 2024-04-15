import math
from foo_bar import FooBar
import random

def MonteCarlo2D(minx, maxx, miny, maxy, n):
    for _ in range(n):
        x = random.uniform(minx, maxx)
        y = random.uniform(miny, maxy)
        yield (x, y)

def task1():
    foo_bar_iterator = FooBar(100)
    for item in foo_bar_iterator:
        print(item)

def task2():
    minx, maxx = 0, 1
    miny, maxy = 0, 1
    n = 100000
    count = 0
    monte_carlo = MonteCarlo2D(minx, maxx, miny, maxy, n)

    for x, y in monte_carlo:
        if (x * x + y * y) <= 1:
            count += 1

    result = 4 * (count / n)
    print(result)

def main():
    task = -1

    while task != 0:
        print("NAVIGATION")
        print("Enter 1 - task 1")
        print("Enter 2 - task 2")
        print("Enter 0 - EXIT")
        task = int(input("Enter task >>> "))

        if task == 1:
            task1()
        elif task == 2:
            task2()

if __name__ == "__main__":
    main()