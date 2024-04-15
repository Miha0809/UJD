import random


def task1():
    count = int(input("Enter count: "))

    for i in range(count):
        print(i * 2)


def task2():
    count = int(input("Enter count: "))
    suma = 0

    for i in range(2, count + 1, 2):
        suma += i

    print(suma)


def task3():
    number = int(input("Enter number: "))
    divider = 2

    while number > divider:
        if number % 2 == 0:
            number /= divider
            print(divider)
        elif number % 3 == 0:
            divider += 1
            number /= divider
            print(divider)
        else:
            print(int(number))
            break

    if number == divider:
        print(divider)


def task4():
    number = int(input("Enter number: "))
    suma = 0

    for i in range(1, number):
        if number % i == 0:
            suma += i

    if suma == number:
        print("Ta liczba jest doskonala")
    else:
        print("Ta liczba nie jest doskonala")


def task5():
    number = int(input("Enter number: "))
    suma = 1

    for i in range(number % 2 or 2, number + 1, 2):
        suma *= i

    return suma


def fibonacci(number):
    if number < 0:
        print("Incorrect input")
    elif number == 0:
        return 0
    elif number == 1:
        return 1
    else:
        return fibonacci(number - 1) + fibonacci(number - 2)


def isPrime(number):
    for i in range(2, number):
        if number % i == 0:
            return False

    return True


def task7():
    number = int(input("Enter number: "))

    for i in range(2, number):
        if isPrime(i):
            print(i)


def task8():
    for i in range(5):
        haslo = int(input("Enter hasło: "))
        if haslo == 1979:
            print("Bingo")
            return
    print("NOK")


def task9():
    isM = False
    isA = False

    while isM == False or isA == False:
        word = input("Enter: ").lower()

        for i in range(len(word)):
            if word[i] == "m":
                isM = True
            elif word[i] == "a":
                isA = True

    if isM and isA:
        print("Yes")
    else:
        print("No")

def task10():
    length = int(input("Enter length: "))

    for i in range(length, 1, -1):
        print("*" * i)

    for i in range(1, length + 1):
        print("*" * i)


def task11():
    for i in range(1000, 10000):
        left = int(i / 100)
        right = i % 100
        print(i, "=", (left ** 2) + (right ** 2))


def task12():
    number = 10

    for i in range(1, number + 1):
        for j in range(1, number + 1):
            print(i * j, end=" ")
        print()


def task13():
    length = int(input("Enter length list: "))
    arr = []

    for i in range(length):
        arr.append(random.randint(0, 100))

    # suma = 0
    # min = arr[0]
    # max = arr[0]
    #
    # for i in range(length):
    #     suma += arr[i]
    #
    #     if min > arr[i]:
    #         min = arr[i]
    #     elif max < arr[i]:
    #         max = arr[i]
    #
    # average = suma / len(arr)
    #
    # print("Average: ", average)
    # print("Max: ", min)
    # print("Min: ", max)
    print("Average: ", sum(arr) / len(arr))
    print("Max: ", min(arr))
    print("Min: ", max(arr))


def task14():
    randomNumber = random.randint(0, 10)
    number = -1
    count = 1
    giveHint = int(input("Give a hint (1-10): "))
    hint = False

    while number != randomNumber:
        number = int(input("Enter number: "))

        if count > giveHint:
            hint = True

            if number > randomNumber:
                print("number > randomNumber")
            elif number < randomNumber:
                print("number < randomNumber")

        count += 1

    print("\n\tCount enter numbers: ", count)
    print("\tRandom number: ", randomNumber)

    if hint:
        print("\tYou guessed it with hints")


def task15():
    randomNumber = random.randint(0, 10)
    number = -1
    count = 1

    while number != randomNumber:
        number = int(input("Enter number: "))

        if count == 3:
            print("Random number: ", randomNumber)
            break

        count += 1

    print("\n\tCount enter numbers: ", count)
    print("\tRandom number: ", randomNumber)


def task16():
    number = int(input("Enter number: "))
    buff = number

    for i in range(number + 1):
        print(i, "->", buff)
        buff -= 1

mode = -1

while mode != 0:
    print("\n\tNavigation")
    print("1 - task 1")
    print("2 - task 2")
    print("3 - task 3")
    print("4 - task 4")
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
    elif mode == 5:
        print(task5())
    elif mode == 6:
        print(fibonacci(int(input("Enter number: "))))
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
