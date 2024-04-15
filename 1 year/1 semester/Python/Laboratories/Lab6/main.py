import random
import part2

mode = -1

while mode != 0:
    print("\n\tNavigation")
    print("Enter 1 = task1")
    print("Enter 2 = task2")
    print("Enter 3 = task3")
    print("Enter 4 = task4")
    print("Enter 5 = task5")
    print("Enter 6 = task6")
    print("Enter 7 = task7")
    print("Enter 8 = task8")
    print("Enter 9 = task9")
    print("Enter 10 = task10")
    print("Enter 0 = EXIT")
    mode = int(input("Enter mode: "))

    if mode == 1:
        print(part2.task1([random.randint(1, 100) for i in range(100)]))
    elif mode == 2:
        print(part2.task2([random.randint(50, 50) for i in range(100)], int(input("Enter search number: "))))
    elif mode == 3:
        print(part2.task3([random.randint(10, 20) for i in range(100)]))
    elif mode == 4:
        print(part2.task4([random.randint(50, 50) for i in range(100)]))
    elif mode == 5:
        print(part2.task5([chr(random.randint(97, 122)) for i in range(100)]))
    elif mode == 6:
        print(part2.task6([random.randint(1, 100) for i in range(1000)]))
    elif mode == 7:
        print(part2.task7([random.randint(1, 64) for i in range(1000)], random.randint(0, 6)))
    elif mode == 8:
        print(part2.task8([random.randint(50, 50) for i in range(100)]))
    elif mode == 9:
        print(part2.task9([random.randint(50, 50) for i in range(100)], [random.randint(50, 50) for i in range(100)]))
    elif mode == 10:
        print(part2.task10([1, 2], [1, 2]))
        print(part2.task10([1, 2], [2, 1]))
        print(part2.task10([1, 2], [2, 1, 1]))
