def task1():
    suma = 0

    for i in range(1, 100 + 1):
        if i % 2 == 0:
            suma += i

    print("Suma: ", suma)


def BMI():
    weight = float(input("Enter you weight [kg]: "))
    height = float(input("Enter you height [m]: "))
    bmi = weight / (height ** 2)

    # if bmi < 18.5:
    #     print("under height")
    # elif bmi >= 18.5 and bmi < 25:
    #     print("height is normal")
    # elif bmi >= 25 and bmi < 30:
    #     print("over height")
    # elif bmi >= 30 and bmi < 35:
    #     print("obesity class 1")
    # elif bmi >= 35 and bmi < 40:
    #     print("obesity class 2")
    # elif bmi >= 40:
    #     print("obesity class 3")

    if bmi < 18.5:
        print("under height")
    elif 18.5 <= bmi < 25:
        print("height is normal")
    elif 25 <= bmi < 30:
        print("over height")
    elif 30 <= bmi < 35:
        print("obesity class 1")
    elif 35 <= bmi < 40:
        print("obesity class 2")
    elif bmi >= 40:
        print("obesity class 3")


def Pattern(length):
    # for i in range(1, (length + 1) // 2 + 1):
    #     for j in range((length + 1) // 2 - i):
    #         print(" ", end="")
    #
    #     for j in range((i * 2) - 1):
    #         print("*", end="")
    #
    #     print()
    #
    # for i in range((length + 1) // 2 + 1, length + 1):
    #     for j in range(i - (length + 1) // 2):
    #         print(" ", end="")
    #
    #     for j in range((length + 1 - i) * 2 - 1):
    #         print("*", end="")
    #
    #     print()

    for i in range(1, length, 2):
        i = ' ' * ((length - i) // 2) + '*' * i + ' ' * (length - i)
        print(i)

    if length % 2 == 0:
        for i in range(length - 1, 0, -2):
            i = ' ' * ((length - i) // 2) + '*' * i + ' ' * (length - i)
            print(i)
    elif length % 2 != 0:
        for i in range(length, 0, -2):
            i = ' ' * ((length - i) // 2) + '*' * i + ' ' * (length - i)
            print(i)


if __name__ == "__main__":
    mode = -1

    while mode != 0:
        print("\n\tNavigation")
        print("Enter 1 - task 1")
        print("Enter 2 - task 2")
        print("Enter 3 - task 3")
        print("Enter 0 - Exit")
        mode = int(input("Enter mode: "))

        if mode == 1:
            task1()
        elif mode == 2:
            BMI()
        elif mode == 3:
            length = int(input("Enter length: "))
            Pattern(length)
        else:
            break
