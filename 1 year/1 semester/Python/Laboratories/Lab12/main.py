def task1a(string):
  char_count = {}
  for char in string:
    if char in char_count:
      char_count[char] += 1
    else:
      char_count[char] = 1
  return char_count

def task1bc(string): #zad1.3 nie rożróznia wielkość liter
  letter_count = {}
  string = string.lower()
  for letter in string:
    if letter.isalpha():
      if letter in letter_count:
        letter_count[letter] += 1
      else:
        letter_count[letter] = 1
  return letter_count

def task1d(string):
  string = string.lower()
  letter_count = {}
  for letter in string:
    if letter.isalpha():
      if letter in letter_count:
        letter_count[letter] += 1
      else:
        letter_count[letter] = 1
  return max(letter_count, key=letter_count.get)

def task2():
  num = {}
  while True:
    numer_input = input("Podaj liczbę: ")
    if numer_input == "":
      print(num)
      break
    try:
      numer = int(numer_input)
      if numer in num :
        num[numer] += 1
      else:
        num[numer] = 1
    except ValueError:
      print('Podano niepoprawną wartość,prosze podać liczbe calkowitą')

def task3():
  liczby = {}
  while True:
    line = input()
    
    if line == "":
      break
    word = line.split()
    
    for word in word:
      try:
        numer = int(word)
        if numer in liczby:
          liczby[numer] += 1
        else:
          liczby[numer] = 1
      except ValueError:
        print('Podano niepoprawną wartość, prosze podać liczbe calkowitą')

mode = -1

while mode != 0:
  print("NAVIGATION")
  print("Enter 1 - task1a")
  print("Enter 2 - task1bc")
  print("Enter 3 - task1d")
  print("Enter 4 - task2")
  print("Enter 5 - task3")
  print("Enter 0 - EXIT")
  mode = int(input("Enter task: "))
  
  if mode == 1:
    print(task1a('Hello World'))
  elif mode == 2:
    print(task1bc('abrakadabra'))
  elif mode == 3:
    print(task1d('abrakadabra'))
  elif mode == 4:
    task2()
  elif mode == 5:
    task3()