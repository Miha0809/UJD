import random


def task1():
    array = [i for i in range(0, 20 + 1)]
    for i in range(len(array)):
        array[i] += 6
    print(array)
    array = array[::-1]
    print(array)


def task2():
    array = [random.randint(0, 1) for i in range(100)]
    array = [bool(i) for i in array]
    print(array)


def main():
    mode = -1

    while True:
        print("\nNAVIGATION")
        print("Enter 1 - task1")
        print("Enter 2 - task2")
        print("Other - Exit")
        mode = input(">>> ")

        if mode == "1":
            task1()
        elif mode == "2":
            task2()
        else:
            break


if __name__ == "__main__":
    main()
