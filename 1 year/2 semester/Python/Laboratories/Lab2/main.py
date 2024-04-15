import os
import random

PATH_NUMBERS = "numbers"
FILE_EVEN_NUMBERS = "even.txt"
FILE_ODD_NUMBERS = "odd.txt"

def task1():
  try:
    number = -1

    if not os.path.exists(PATH_NUMBERS):
      os.mkdir(PATH_NUMBERS)

    while number != 0:
      number = int(input("Enter number: "))

      with open(f"{PATH_NUMBERS}/{FILE_EVEN_NUMBERS}", 'a') as file_even:
        with open(f"{PATH_NUMBERS}/{FILE_ODD_NUMBERS}", 'a') as file_odd:
          if number > 0:
            if number % 2 == 0:
              file_even.write(str(number) + ' ')
            elif number % 2 != 0:
              file_odd.write(str(number) + ' ')
          
          file_odd.close()
        file_even.close()
  except NameError as name:
    print(name)

def task2():
  try:
    numbers_even = open(f"{PATH_NUMBERS}/{FILE_EVEN_NUMBERS}")
    numbers_odd = open(f"{PATH_NUMBERS}/{FILE_ODD_NUMBERS}")
    numbers = (numbers_even.read() + numbers_odd.read()).split()
    suma = 0
    
    for i in numbers:
      suma += int(i)

    averange = suma / len(numbers)

    return f"Suma: {suma}\nAverange: {averange}"
  except NameError as name:
    print(name)

def task3():
  arr = []
  LENGHT = 100

  while len(arr) != LENGHT:
    rnd = random.randint(1, LENGHT)

    if rnd not in arr:
      arr.append(rnd)

  arr.pop(random.randint(0, LENGHT - 1))

  with open("input_data.txt", 'w') as file:
    for item in arr:
      file.write(str(item) + '\n')
    file.close()

  with open("input_data.txt", 'r') as file:
    buff = file.read().split()
    arr = sorted([int(i) for i in buff])
    count = 1

    try:
      for i in range(len(arr) + 1):
        if count != int(arr[i]):
          print(count)
          file.close()
          break
        count += 1
    except:
      print(count)
      file.close()

def by_marks(buff):
  return buff[1]

def task4():
  # arr = [("Jan","Kowalski"), ("Grzegorz","Brzęczyszczykiewicz"), ("Jacek", "Placek")]
  # return sorted(arr, key=by_marks)
  arr = []
  count = int(input("Enter count of pairs: "))

  for i in range(count):
    arr.append((input("Enter key: "), input("Enter value: ")))

  return sorted(arr, key=by_marks)

def task5():
  ''' 1)
  t = (1, 2, 3, 4)
  t[0] = 8 -> TypeError: 'tuple' object does not support item assignment
  '''

  ''' 2)
  t = (1, 2, 3, 4)
  t.append(5) -> AttributeError: 'tuple' object has no attribute 'append'
  '''

  ''' 3)
    t = "hehe"
  w = t * 5
  print(w) -> hehehehehehehehehehe
  '''  

  ''' 4)
  t = {}
  print(type(t)) -> <class 'dict'>
  '''

  ''' 5)
  t = {}
  t[1] = 10
  t[199] = 'c'
  print(t) -> {1: 10, 199: 'c'}
  '''

  ''' 6)
  a = [1, 2, 3]
  b = a
  b[2] = 10
  print(a) -> [1, 2, 10]
  print(b) -> [1, 2, 10]
  '''

  ''' 7)
  L = [1, 2, 3]
  for element in L:
    element = 5
  print(L) -> [1, 2, 3]
  '''

  ''' 8)
  L = [1, 2, 3]
  for i in range(len(L)):
    L[i] = 5
  print(L) -> [5, 5, 5]
  '''

  ''' 9)
  if True:
    x = 10
  print(x) -> 10
  '''

  ''' 10)
  for i in range(5):
    pass
  print(i) -> 4
  '''

  ''' 11)
  def f():
    print(a)
  a = 8
  f() -> 8
  '''

  ''' 12)
  def f():
    a = 15
  a = 8
  f()
  print(a) -> 8
  '''

  ''' 13)
  def f():
    global a
    a = 15
  a = 8
  f()
  print(a) -> 15
  '''

  ''' 14)
  def f():
    global a
    a = 15
  a = 8
  print(a) -> 8
  '''

  ''' 15)
  def f(L1):
    L1[0] = 15
  L = [1, 2, 3]
  f(L)
  print(L, L1) -> NameError: name 'L1' is not defined.
  '''

  ''' 16)
  def f(L1):
    L = L1
  L = [1, 2, 3]
  f([4, 5, 6])
  print(L) -> [1, 2, 3]
  '''

  ''' 17)
  def f(L1):
    global L
    L = L1
  L = [1, 2, 3]
  f([4, 5, 6])
  print(L) -> [4, 5, 6]
  '''

  ''' 18)
  def f(L1):
    L = L1[:]
    L[0] = 15
  L = [1, 2, 3]
  f([4, 5, 6])
  print(L) -> [1, 2, 3]
  '''

  ''' 19)
  def f(L1):
    L = L1[:]
    L[0] = 15
  L = (1, 2, 3)
  f((4, 5, 6))
  print(L) -> TypeError: 'tuple' object does not support item assignment
  '''

def main():
  mode = -1

  while mode != 0:
    print("\tNAVIGATION")
    print("Enter 1 - task 1")
    print("Enter 2 - task 2")
    print("Enter 3 - task 3")
    print("Enter 4 - task 4")
    print("Enter 0 - EXIT")
    mode = int(input("Enter task: "))

    if mode == 1:
      task1()
    elif mode == 2:
      task2()
    elif mode == 3:
      task3()
    elif mode == 4:
      print(task4())

if __name__ == '__main__':
  main()