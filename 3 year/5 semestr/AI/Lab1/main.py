def task1():
    array = [i for i in range(0, 20 + 1)]
    for i in range(len(array)):
        array[i] += 6
    print(array)
    array = array[::-1]
    print(array)


def main():
    mode = -1

    while True:
        print("\nNAVIGATION")
        print("Enter 1 - task1")
        print("Enter 0 - Exit")
        mode = int(input(">>> "))

        if mode == 1:
            task1()
        elif mode == 0:
            break


if __name__ == "__main__":
    main()
