import math
import random


def task1(a, b = 4, c = 5):
  print(a, b, c)

def task2(a, b, c = 5):
  print(a, b, c)

def task3(a, *args):
  print(a, args)

def task4(a, **kwargs):
  print(a, kwargs)

def task5(a, b, c = 3, d = 4):
  print(a, b, c, d)

def task6(*numbers):
  # max = 0

  # for i in numbers:
  #   if max < i:
  #     max = i

  # return max
  return max(numbers)

def task7(*numbers):
  # suma = 0

  # for i in numbers:
  #   suma += i

  # return suma
  return sum(numbers)

def task8(*numbers):
  # count = 0

  # for i in numbers:
  #   count += 1

  # return count
  return len(numbers)

def task9(*args):
  for i in args:
    print(i)

def task10(*args):
  for i in reversed(args):
    print(i)
  # return filter(lambda x: print(x), args) TODO: change

def task11(*numbers):
  suma = 1

  for i in numbers:
    if type(i) == type(int()):
      suma *= i

  return suma # TODO: in 1 line

def task12(n):
  return [x for x in range(1, n + 1) if x % 3 == 0 or x % 5 == 0]

def task13():
  # return [round(random.uniform(-100, 100), 2) for x in range(random.randint(1, 50))]
  return [7.78, -9.64, 3.39, -8.64, -3.22, 9.6, 9.5, -7.7, -5.73, 7.75]

def task13a(arr = task13()):
  return list(filter(lambda x: x >= 0, arr))

def task13b(arr = task13()):
  return list(map(int, list(filter(lambda x: x >= 0, arr))))

def task13c(arr = task13()):
  return list(map(lambda x: math.floor(x), arr))

def task13d(arr = task13()):
  return list(map(lambda x: math.ceil(x), arr))

def task13e(arr = task13()):
  return list(map(lambda x: math.log(x), list(filter(lambda x: x >=  0, arr))))


mode = -1

while mode != 0:
  print("NAVIGATION")
  print("Etner 1 - task 1")
  print("Etner 2 - task 2")
  print("Etner 3 - task 3")
  print("Etner 4 - task 4")
  print("Etner 5 - task 5")
  print("Etner 6 - task 6")
  print("Etner 7 - task 7")
  print("Etner 8 - task 8")
  print("Etner 9 - task 9")
  print("Etner 10 - task 10")
  print("Etner 11 - task 11")
  print("Etner 12 - task 12")
  print("Etner 13 - task 13")
  print("Etner 0 - EXIT")
  mode = int(input("Enter task: "))

  if mode == 1:
    task1(1, 2)
  elif mode == 2:
    task2(1, c = 3, b = 2)
  elif mode == 3:
    task3(1, 2, 3)
  elif mode == 4:
    task4(a = 1, c = 3, b = 2)
  elif mode == 5:
    task5(1, *(5, 6))
  elif mode == 6:
    print(task6(7, 4, 1, 10, 0, 2))
  elif mode == 7:
    print(task7(1, 2, 3, 4, 5))
  elif mode == 8:
    print(task8(1, 2, 3, 4, 5, 6, 7))
  elif mode == 9:
    task9(6, 3, 1, 5, 10)
  elif mode == 10:
    task10(6, 34, 1, 9, 10, 0)
  elif mode == 11:
    print(task11(3, 3.14, 5, "abc", 6))
  elif mode == 12:
    print(task12(int(input("Enter length: "))))
  elif mode == 13:
    print(task13())
    print(task13a())
    print(task13b())
    print(task13c())
    print(task13d())
    print(task13e())




