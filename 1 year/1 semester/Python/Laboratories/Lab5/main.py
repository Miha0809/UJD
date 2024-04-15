def task1(str):
    text = ""

    for i in range(len(str)):
        if str[i] == str[i].lower():
            text += str[i]

    return text[::-1].replace(" ", "")


def task2(str):
    text = ""

    for i in range(len(str)):
        if str[i] == str[i].upper():
            text += str[i]

    return text.replace(" ", "")


def task3(str):
    count = 0

    for i in range(len(str)):
        key = ord(str[i])  # ASCII key

        if (key < 65 or key > 90) and (key < 97 or key > 122):
            count += 1

    return count


def task4(str):
    # str = str.lower() # nie wiem czy H == h jeśli tak, to trzeba napisać ten kod
    letter = ''
    countLetters = 0
    maxCountLetters = 0

    for i in str:
        for j in str:
            if i == j:
                countLetters += 1

                if countLetters > maxCountLetters:
                    maxCountLetters = countLetters
                    letter = i

        countLetters = 0

    return letter


def task5(str1, str2):
    return str1 == str2


def task6(str1, str2):
    # nie wiem jak to zrobić
    return


def task7(str):
    str2 = ""

    for i in range(len(str)):
        key = ord(str[i])  # ASCII key

        if (key < 48 or key > 57) and (key < 65 or key > 90) and (key < 97 or key > 122):
            str2 += str[i]

    return str2


def task8(str, remove):
    return str.replace(remove, "")


def task9(str, remove):
    return str.replace(remove, "")


def reverse(str):  # task10
    return str[::-1]


def palindrom(str):  # task 11
    return str.lower() == str[::-1].lower()


def task12(str):
    return str + str[::-1]


mode = -1

while mode != 0:
    print("\n\rNavigation")
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
        print(task1(input("[1] Enter string: ")))
    elif mode == 2:
        print(task2(input("[2] Enter string: ")))
    elif mode == 3:
        print(task3(input("[3] Enter string: ")))
    elif mode == 4:
        print(task4(input("[4] Enter string: ")))
    elif mode == 5:
        print(task5(input("[5] Enter first string: "), input("[5] Enter second string: ")))
    elif mode == 6:
        print(task6(input("[6] Enter first string: "), input("[6] Enter second string: ")))
    elif mode == 7:
        print(task7(input("[7] Enter string: ")))
    elif mode == 8:
        print(task8(input("[8] Enter string: "), input("[8] Enter remove: ")))
    elif mode == 9:
        print(task9(input("[9] Enter string: "), input("[9] Enter remove: ")))
    elif mode == 10:
        print(reverse(input("[10] Enter string: ")))
    elif mode == 11:
        print(palindrom(input("[11] Enter string: ")))
    elif mode == 12:
        print(task12(input("[12] Enter string: ")))
