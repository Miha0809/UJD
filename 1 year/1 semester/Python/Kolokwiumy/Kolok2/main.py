def multiplication(arr):
  result = 1

  for i in arr:
    result *= i
  
  return result

def task3(arr):
  for i in range(0, 5):
    arr.pop(0)
    
  return arr

mode = -1

while mode != 0:
  print("NAVIGATION")
  print("Enter 1 - task 1")
  print("Enter 2 - task 2")
  print("Enter 3 - task 3")
  print("Enter 0 - EXIT")
  mode = int(input("Enter task: "))

  if mode == 1:
    print(multiplication([1, 2, 3, 4]))
  elif mode == 2:
    print([i for i in range(0, 100) if i % 5 != 0 and i % 7 != 0])
  elif mode == 3:
    print(task3([x ** 2 for x in range(1, 20 + 1)]))