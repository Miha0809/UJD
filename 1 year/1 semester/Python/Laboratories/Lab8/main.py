def task1():
    for i in range(6 + 1):
        if i == 3 or i == 6:
            continue
        print(i)


def task2():
    number = int(input("Enter number: "))
    
    for i in range(number + 1):
        if i == 3 or i == 6:
            continue
        print(i)

def task3():
    # TODO: zrobić
    # Nie zrozumiałem zadanie

    number = float(input("Enter number: "))
    item = number
    suma = 0

    while True:
        if item > 0:
            if suma <= number:
                suma += item
            else:
                break
        else:
            continue



    print(suma)

def task4():
    # TODO: Zrobić
    # Nie zrozumiałem zadanie

    number = float(input("Enter number: "))
    item = 0 
    suma = 0

    # Nie prawindlowo, kiedy w while 
    while True:
        if item >= 0:
            if suma <= number:
                suma += item
            else:
                break
        else:
            continue

        item += 1
    
    print(suma)


def task5():
    try:
        numbers = [1, 2, 3, 4]
        count = 0
        total = 0
        
        for value in numbers:
            total += value

        print(total / count)
    except NameError as name:
        print(name)

def task6():
    try:
        number = int(input("Enter number: "))

        for i in range(number + 1):
            if i % 3 == 0 or i % 6 == 0:
                continue
            print(i)
    except NameError as name:
        print(name)


def task7():
    # TODO: Zrobić
    try:
        number = float(input("Enter number: "))
        
        if number == int(number):
            # raise "Number is int"
            return
        

    except NameError as name:
        print(name)

def inputComplex():
    return complex(input("Enter complex number: "))

def inputInt():
    return int(input("Enter int number: "))

def inputFloat():
    return float(input("Enter float number: "))


def task8():
    try:
        inputComplex()
        inputFloat()
        inputInt()
    except NameError as name:
        print(name)


mode = -1

while mode != 0:
    print("Navigation")
    print("Enter 1 - task 1")
    print("Enter 2 - task 2")
    print("Enter 3 - task 3")
    print("Enter 4 - task 4")
    print("Enter 5 - task 5")
    print("Enter 6 - task 6")
    print("Enter 7 - task 7")
    print("Enter 8 - task 8")
    mode = int(input("Etner task: "))
    
    if mode == 1:
        task1()
    elif mode == 2:
        task2()
    elif mode == 3:
        task3()
    elif mode == 4:
        task4()
    elif mode == 5:
        task5()
    elif mode == 6:
        task6()
    elif mode == 7:
        task7()
    elif mode == 8:
        task8()
