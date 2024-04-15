import task10


def Wypisz(var):  # task 1
    print(var, ':', type(var))


def IleCyfr(number):  # task 2
    count = 0

    while number > 0:
        number = int(number / 10)
        count += 1

    return count


def Odwrotnosc(number):  # task 3
    # return -number # nie zrozumiałem zadanie jak trzeba zrobić
    return str(number)[::-1]


def task4(number):
    return number % 2 == 0


def task5(begin, end, number):
    count = 0

    for i in range(begin, end + 1):
        if i % number == 0:
            count += 1

    return count


def task6():
    # TODO: nie rozumiam zadanie
    return


def task7(number, n):
    item = 0
    suma = 0

    while item < n:
        suma -= (number + item) / (number + 2 ** item)
        item += 1

    return suma


def task8(number, n):
    item = 0
    suma = 0

    while item < n:
        suma += 1 / (number + (2 * n))
        item += 1

    return suma


def task9(n):
    # TODO: nie rozumiam zadanie
    return


def task11():
    number = int(input("Enter number: "))
    suma = 0

    for i in range(2, number + 1):
        for i in range(2, number + 1):
            if i % 2 == 0:
                suma += 1

    return suma


def task12():
    number = int(input("Enter number: "))
    suma = 0

    for i in range(1, number):
        suma += i * (i + 1)

    return suma


mode = -1

while mode != 0:
    print("\n\tNavigation")
    print("Enter 1 - task 1")
    print("Enter 2 - task 2")
    print("Enter 3 - task 3")
    print("Enter 4 - task 4")
    print("Enter 5 - task 5")
    print("Enter 6 - task 6")
    print("Enter 7 - task 7")
    print("Enter 8 - task 8")
    print("Enter 9 - task 9")
    print("Enter 10 - task 10")
    print("Enter 11 - task 11")
    print("Enter 12 - task 12")
    print("Enter 0 - EXIT")
    mode = int(input("Enter mode: "))

    if mode == 1:
        Wypisz("String")
        Wypisz(True)
        Wypisz(1)
        Wypisz(1.1)
        Wypisz(1j)
        Wypisz([])
    elif mode == 2:
        print(IleCyfr(int(input("[2] Enter number: "))))
    elif mode == 3:
        print(Odwrotnosc(int(input("[3] Enter number: "))))
    elif mode == 4:
        print(task4(int(input("[4] Enter number: "))))
    elif mode == 5:
        print(task5(int(input("[5] Enter begin: ")), int(input("[5] Enter end: ")), int(input("[5] Enter number: "))))
    elif mode == 6:
        print(task6())
    elif mode == 7:
        print(task7(int(input("[7] Enter number: ")), int(input("[7] Enter n: "))))
    elif mode == 8:
        print(task8(int(input("[8] Enter number: ")), int(input("[8] Enter n: "))))
    elif mode == 9:
        print(task9(0))
    elif mode == 10:
        print("Start next file")
    elif mode == 11:
        print(task11())
    elif mode == 12:
        print(task12())