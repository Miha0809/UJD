import L1_zad5


def task1():
    print(((12 ** 2 - 23) * 15) / 4)


def task2():
    x = "Hello, World"
    print("Value: ", x)
    print(type(x))
    print()

    x = 'x'
    print("Value: ", x)
    print(type(x))
    print()

    x = 1j
    print("Value: ", x)
    print(type(x))
    print()

    x = 1
    print("Value: ", x)
    print(type(x))
    print()

    x = 1.1
    print("Value: ", x)
    print(type(x))
    print()

    x = True
    print("Value: ", x)
    print(type(x))
    print()

    x = range(10)
    print("Value: ", x)
    print(type(x))
    print()

    x = ["Hello, World", 'x', 1, 1.1, 1j, True, range(10)]
    print("Value: ", x)
    print(type(x))
    print()


def task3():
    x = input("Enter value: ")
    print("Value: ", x)
    print(type(x))
    print()

    x = int(input("Enter int value: "))
    print("Value: ", x)
    print(type(x))
    print()

    x = float(input("Enter float value: "))
    print("Value: ", x)
    print(type(x))
    print()

    x = bool(input("Enter bool value: "))
    print("Value: ", x)
    print(type(x))
    print()


def task4():
    mode = -1

    while mode != 0:
        print("Navigation")
        print("1 - +")
        print("2 - -")
        print("3 - *")
        print("4 - /")
        print("5 - //")
        print("6 - %")
        print("7 - **")
        print("0 - exit")

        mode = int(input(">>> "))

        if mode == 1:
            print(L1_zad5.suma(int(input("Num1: ")), int(input("Num2: "))))
        elif mode == 2:
            print(L1_zad5.minus(int(input("Num1: "), int(input("Num2: ")))))
        elif mode == 3:
            print(L1_zad5.multiplication(int(input("Num1: ")), int(input("Num2: "))))
        elif mode == 4:
            print(L1_zad5.division(int(input("Num1: ")), int(input("Num2: "))))
        elif mode == 5:
            print(L1_zad5.whole_part(int(input("Num1: ")), int(input("Num2: "))))
        elif mode == 6:
            print(L1_zad5.remainder(int(input("Num1: ")), int(input("Num2: "))))
        elif mode == 7:
            print(pow(int(input("Num1: ")), int(input("Num2: "))))


def task6():
    try:
        x = 1 / 0
        print(x)
    except:
        print("Error")


def task7():
    print("Nie ważne jak się zaczyna, ważne jak się kończy ;) " * 100)


def task8():
    print("*     *  ***   *     *")
    print("*     *  *  *  *    * *")
    print("*     *  *  *  *   * * *")
    print("****  *  ***   *  *     *")


def task9():
    char = input("Enter char: ")
    print("  ", char)
    print(" ", char, char)
    print("", char, " ", char)
    print(char, "   ", char)
    print(char * 7)
    print(char, "   ", char)
    print(char, "   ", char)
    print(char * 7)


mode = -1

while mode != 0:
    print("Navigation")
    print("1 - task 1")
    print("2 - task 2")
    print("3 - task 3")
    print("4 - task 4")
    print("6 - task 6")
    print("7 - task 7")
    print("8 - task 8")
    print("9 - task 9")
    print("0 - EXIT")
    mode = int(input("Enter mode: "))

    if mode == 1:
        task1()
    elif mode == 2:
        task2()
    elif mode == 3:
        task3()
    elif mode == 4:
        task4()
    elif mode == 6:
        task6()
    elif mode == 7:
        task7()
    elif mode == 8:
        task7()
    elif mode == 9:
        task9()
