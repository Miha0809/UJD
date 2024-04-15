import random
from math import prod
from functools import reduce


def task1():
    number = int(input("Podaj liczbę całkowitą: "))

    if number % 2 == 0:
        print('Liczba', number, 'to liczba parzysta')
    else:
        print('To nie jest liczba parzysta')

    # pętla for powinna zsumować 10 początkowych liczb naturalnych
    suma = 0

    for i in range(1, 10 + 1):
        suma += i

    # pętla while powinna pomnożyć 10 początkowych liczb naturalnych
    i = 0
    multiply = 1

    while i < 10:
        multiply = i * i
        i += 1

    return f'Suma: {suma}\n' \
           f'Multiply: {multiply}'


def task2():
    a = []

    for i in range(1, 10 + 1):
        a.append(i)

    print(a)

    b = []

    for i in range(0, 20 + 1, 2):
        b.append(i)

    print(b)

    c = []

    for i in range(10 + 1):
        c.append(i ** 2)

    print(c)

    d = []

    for i in range(10):
        d.append(0)

    print(d)

    e = []

    for i in range(5):
        e.append(0)
        e.append(1)

    print(e)

    f = []

    for i in range(0, 4 + 1):
        f.append(i)

    print(f * 2)


def task3(arr):
    # countPositive = 0
    # countNegative = 0
    #
    # for item in arr:
    #     if item > 0:
    #         countPositive += 1
    #     else:
    #         countNegative += 1
    #
    # print("Positive: ", countPositive)
    # print("Negative: ", countNegative)
    return f'Negatives: {len(list(filter(lambda i: i < 0, arr)))}\n' \
           f'Positives: {len(list(filter(lambda i: i > 0, arr)))}'


def task4(arr):
    # result = 1
    #
    # for item in arr:
    #     result *= item
    #
    # return result
    return prod(arr)
    # return reduce((lambda x, y: x * y), arr)


def task5(arr):
    return [min(arr), max(arr)]


def task6(arr):
    # 1−4+16−9+9−7+4−9+11 = 12

    if len(arr) % 2 != 0:
        arr.append(0)

    result = 0

    for i in range(0, len(arr), 2):
        result += arr[i] - arr[i + 1]

    return result


def task7(arr):
    isSameElementInput = False
    isUnique = len(set(arr)) == len(arr)

    if not isUnique:
        return "Noe unique list"

    while len(arr) != 10:
        print(arr)

        number = int(input("Enter number: "))

        for item in arr:
            if number == item:
                isSameElementInput = True
                break
            else:
                isSameElementInput = False

        if not isSameElementInput:
            arr.append(number)

    return arr


def task8():
    arr = sorted([random.randint(2, 10000) for buff in range(100)])

    print(arr)

    i = 0

    for buff in range(len(arr)):
        if (arr[i] != 2 and arr[i] != 3) and (arr[i] % 2 == 0 or arr[i] % 3 == 0):
            arr.pop(i)
            i -= 1
        i += 1

    return f'{arr}\n' \
           f'len: {len(arr)}'


def task9a(arr):
    arr[0], arr[-1] = arr[-1], arr[0]
    return arr


def task9b(arr):
    return [arr[-1]] + arr[:-1]


def task9c(arr):
    for i in range(len(arr)):
        if arr[i] % 2 == 0:
            arr[i] = 0

    return arr


def task9d(arr):
    for i in range(1, len(arr) - 1):
        left = arr[i - 1]
        right = arr[i + 1]

        if left > right:
            arr[i] = left
        elif right > left:
            arr[i] = right

    return arr


def task9e(arr):
    if len(arr) % 2 != 0:
        arr.pop(int(len(arr) / 2))
    elif len(arr) % 2 == 0:
        arr.pop(int(len(arr) / 2))
        arr.pop(int(len(arr) / 2))

    return arr


def task9f(arr):
    index = 0

    for i in range(len(arr)):
        if arr[i] % 2 == 0:
            arr[index], arr[i] = arr[i], arr[index]
            index += 1

    return arr


def task9g(arr):
    arr.remove(max(arr))
    return max(arr)


def task9h(arr):
    return arr == sorted(arr)


def task9i(arr):
    for i in range(1, len(arr)):
        if arr[i] == arr[i - 1]:
            return True

    return False


def task9j(arr):
    return not (list(set(sorted(arr))) == sorted(arr))


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
    print("Enter 9 - task 9a")
    print("Enter 10 - task 9b")
    print("Enter 11 - task 9c")
    print("Enter 12 - task 9d")
    print("Enter 13 - task 9e")
    print("Enter 14 - task 9f")
    print("Enter 15 - task 9g")
    print("Enter 16 - task 9h")
    print("Enter 17 - task 9i")
    print("Enter 18 - task 9j")
    print("Enter 0 - EXIT")
    mode = int(input("Enter mode: "))

    if mode == 1:
        print(task1())
    elif mode == 2:
        task2()
    elif mode == 3:
        print(task3([random.randint(-50, 60) for x in range(20)]))
    elif mode == 4:
        print(task4([1, 2, 3, 4, 5, 6]))
    elif mode == 5:
        print(task5([31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]))
    elif mode == 6:
        print(task6([1, 4, 16, 9, 9, 7, 4, 9, 11]))
    elif mode == 7:
        print(task7([1, 2, 3, 4]))
    elif mode == 8:
        print(task8())
    elif mode == 9:
        print(task9a([4, 5, 6, 1, 9]))
    elif mode == 10:
        print(task9b([1, 4, 9, 16, 25]))
    elif mode == 11:
        print(task9c([5, 6, 7, 3, 1, 10, 12, 6, 9]))
    elif mode == 12:
        print(task9d([5, 6, 7, 9, 5, 3, 10, 1]))
    elif mode == 13:
        print(task9e([1, 2, 3, 4, 5]))
        print(task9e([1, 2, 3, 4, 5, 6]))
    elif mode == 14:
        print(task9f([1, 3, 5, 7, 6, 9, 8, 10]))
    elif mode == 15:
        print(task9g([4, 3, 2, 1, 7, 5, 9, 10, 0, 4]))
    elif mode == 16:
        print(task9h([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
        print(task9h([1, 2, 3, 2, 4, 5, 6, 8, 9, 10]))
    elif mode == 17:
        print(task9i([0, 1, 2, 3, 4, 5, 6]))
        print(task9i([0, 1, 2, 3, 4, 5, 5]))
    elif mode == 18:
        print(task9j([1, 2, 3, 4, 5, 6, 7, 8]))
        print(task9j([1, 2, 3, 4, 5, 2, 6, 7, 8]))
