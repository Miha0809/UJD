import random
import numpy as np
import matplotlib.pyplot as plt


def task1():
    array = [i for i in range(0, 20 + 1)]
    for i in range(len(array)):
        array[i] += 6
    print(array)
    array = array[::-1]
    print(array)


def task2():
    array = [random.randint(0, 1) for _ in range(100)]
    array = [bool(i) for i in array]
    print(array)


def task3():
    array1 = [random.randint(1, 10) for _ in range(10, 20 + 1)]
    array2 = [random.randint(1, 10) for _ in range(10, 20 + 1)]
    array3 = [(array1[i] + array2[i]) / 2 for i in range(len(array1))]

    print(array1)
    print(array2)
    print(array3)


def task4():
    x = np.linspace(-5, 5, 1000)
    y = np.exp(-(x**2) / 2) / np.sqrt(2 * np.pi)
    plt.plot(x, y)
    plt.show()


def main():
    mode = -1

    while True:
        print("\nNAVIGATION")
        print("Enter 1 - task1")
        print("Enter 2 - task2")
        print("Enter 3 - task3")
        print("Enter 4 - task4")
        print("Other - Exit")
        mode = input(">>> ")

        if mode == "1":
            task1()
        elif mode == "2":
            task2()
        elif mode == "3":
            task3()
        elif mode == "4":
            task4()
        else:
            break


if __name__ == "__main__":
    main()
