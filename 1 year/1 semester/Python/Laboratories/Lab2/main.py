import math
from datetime import date


def task1():
    a = float(input("Enter value for a: "))
    b = float(input("Enter value for b: "))

    if a == 0 or b == 0:
        print("a == b or b == 0")
        exit()

    x = (-b) / (a)

    y = a * x + b

    print(y)


def task2():
    number = int(input("Enter number: "))

    if (number % 2) == 0:
        print("YES")
    else:
        print("NO")


def task3():
    number = int(input("Enter mark in %: "))

    if (number >= 50) and (number < 60):
        print("dostateczna")
    elif (number >= 60) and (number < 70):
        print("dostateczna plus")
    elif (number >= 70) and (number < 80):
        print("dobra")
    elif (number >= 80) and (number < 90):
        print("dobra plus")
    elif (number >= 90) and (number <= 100):
        print("bardzo dobra")
    else:
        print("Nie dostateczno")


def task4():
    count = int(input("Enter count: "))
    max = 0
    i = 0

    while i < count:
        number = int(input("Enter number: "))

        if max < number:
            max = number

        i += 1

    print(max)


def task4_1():
    a = int(input("Enter value for a: "))
    b = int(input("Enter value for b: "))
    c = int(input("Enter value for c: "))

    if a > b and a > c:
        print("Max a")
    elif b > c and b > a:
        print("Max a")
    else:
        print("Max c")


def task5():
    a = float(input("Enter a: "))
    b = float(input("Enter b: "))
    c = float(input("Enter c: "))
    delta = math.pow(b, 2) - 4 * a * c

    print("Delta: ", delta)

    if (delta >= 0):
        x1 = (-b - math.sqrt(delta)) / 2 / a
        x2 = (-b + math.sqrt(delta)) / 2 / a

        print("X1: ", x1)
        print("X2: ", x2)
    else:
        if delta == 0:
            x1 = -b / (2 * a)
            print("X1: ", x1)


def task6():
    radius = float(input("Enter radius: "))

    print("Połe koła = ", math.pi * radius ** 2)
    print("Obwód koła = ", 2 * math.pi * radius)


def task7():
    a = float(input("Enter a: "))
    b = float(input("Enter b: "))
    h = float(input("Enter h: "))

    print("Pole trapezu wynosi: ", ((a + b) * h) / 2)


def task8():
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    c = int(input("Enter c: "))
    p = (a + b + c) / 3
    P = math.sqrt((p * (p - a) * (p - b) * (p - c)))
    print("P: ", P)


def task9():
    x = int(input("Enter x: "))
    y = int(input("Enter y: "))

    if x == 0 and y == 0:
        print("0")
    elif x > 0 and y > 0:
        print("1 ćwiartka")
    elif x < 0 and y < 0:
        print("2 ćwiartka")
    elif x < 0 and y < 0:
        print("3 ćwiartka")
    elif x > 0 and y < 0:
        print("4 ćwiartka")
    elif x == 0 and y > 0 or y < 0:
        print("0Y")
    elif y == 0 and x > 0 or x < 0:
        print("X0")


def task10():
    a = int(input("Enter value for a: "))
    b = int(input("Enter value for b: "))
    c = int(input("Enter value for c: "))

    if a > 0 and b > 0 and c > 0:
        if a ** 2 + b ** 2 == c ** 2:
            print("Tak")
        else:
            print("No")


def task11():
    print("Program ilustruje działanie operatora logicznego or.")
    print("True or True -> ", "True", ".", sep="")
    print("False or True -> ", "True", ".", sep="")
    print("True or False -> ", "True", ".", sep="")
    print("False or False -> ", "False", ".", sep="")


def task12():
    print("Program ilustruje działanie operatora logicznego or.")
    print("True and True -> ", "True", ".", sep="")
    print("False and True -> ", "False", ".", sep="")
    print("True and False -> ", "False", ".", sep="")
    print("False and False -> ", "False", ".", sep="")


def task13():
    a = True
    b = True
    l = not (a and b)
    p = (not a) or (not b)

    if (l == p):
        print("Prawo de Morgana jest ok")
    else:
        print("Czy to morze prawo?")


def task14():
    print()

    a1 = int(input("Enter value for a1: "))
    b1 = int(input("Enter value for b1: "))
    a2 = int(input("Enter value for a2: "))
    b2 = int(input("Enter value for b2: "))
    c1 = int(input("Enter value for c1: "))
    c2 = int(input("Enter value for c2: "))
    h = a1 * b2 - b1 * a2
    hx = c1 * b2 - b1 * c2
    hy = a1 * c2 - c1 * a2

    if h != 0:
        print("X = ", hx / h)
        print("Y = ", hy / h)
    else:
        if hx == 0:
            print("Układ ma nieskonczone rizwązań")
        else:
            print("Układ sprzeczny")


def task15():
    g = 9.18
    height = int(input("Enter height: "))

    for i in range(0, 6):
        distanceFallen = (g * (i ** 2) / 2)
        ballLocation = height - distanceFallen

        if (ballLocation > 0):
            print("On the ", i, " second the ball is on the hight: ", ballLocation)
        else:
            print("On the ", i, " second the ball is on the ground")


def task16():
    fullName = input("Enter yor full name: ")
    age = int(input("Enter age: "))

    if age > 0 and age < 110:
        print(fullName, "urodził się w ", date.today().year - age)
    else:
        print("Not current input date")


def task17():
    suma = 0

    for i in range(2, 4 + 1, 2):
        suma += i

    print("Suma: ", suma)


def task18():
    suma = 0

    for i in range(1, 100 + 1):
        suma += i ** 2

    print("Suma: ", suma)


def task19():
    suma = 0

    for i in range(1, 63 + 1):
        suma += 2 ** i

    print("Suma: ", suma)


def task20():
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    suma = 0

    for i in range(a, b + 1):
        if i % 2 != 0:
            suma += i

    print("Suma: ", suma)


mode = -1

while mode != 0:
    print("\n\t1 - task 1")
    print("2 - task 2")
    print("3 - task 3")
    print("4 - task 4")
    print("4.1 - task 4.1")
    print("5 - task 5")
    print("6 - task 6")
    print("7 - task 7")
    print("8 - task 8")
    print("9 - task 9")
    print("10 - task 10")
    print("11 - task 11")
    print("12 - task 12")
    print("13 - task 13")
    print("14 - task 14")
    print("15 - task 15")
    print("16 - task 16")
    print("17 - task 17")
    print("18 - task 18")
    print("19 - task 19")
    print("20 - task 20")
    print("0 - Exit")
    mode = float(input("Enter mode: "))

    if mode == 1:
        task1()
    elif mode == 2:
        task2()
    elif mode == 3:
        task3()
    elif mode == 4:
        task4()
    elif mode == 4.1:
        task4_1()
    elif mode == 5:
        task5()
    elif mode == 6:
        task6()
    elif mode == 7:
        task7()
    elif mode == 8:
        task8()
    elif mode == 9:
        task9()
    elif mode == 10:
        task10()
    elif mode == 11:
        task11()
    elif mode == 12:
        task12()
    elif mode == 13:
        task13()
    elif mode == 14:
        task14()
    elif mode == 15:
        task15()
    elif mode == 16:
        task16()
    elif mode == 17:
        task17()
    elif mode == 18:
        task18()
    elif mode == 19:
        task19()
    elif mode == 20:
        task20()
    else:
        break
