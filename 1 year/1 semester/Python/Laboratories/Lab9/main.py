import random

length = 10
set1 = set(sorted([random.randint(1, 15) for x in range(length)]))
set2 = set(sorted([random.randint(1, 15) for x in range(length)]))
set3 = set(sorted([random.randint(1, 15) for x in range(length)]))

print("Set1: ", set1)
print("Set2: ", set2)
print("Set3: ", set3)

def task2a():
    s1 = set(set1)
    s2 = set(set2)

    result = []

    for item1 in set1:
        for item2 in set2:
            if (item2 not in s1) and (item1 not in s2) and (item1 not in result):
                result.append(item1)
            if (item2 not in s1) and (item1 not in s2) and (item2 not in result):
                result.append(item2)

    return sorted(result)

def task2b():
    # result = []
    
    # for item in set1:
    #     if (item not in set2) and (item not in set3) and (item not in result):
    #         result.append(item)

    # return result
    return list(set(filter(lambda x: (x not in set2) and (x not in set3), set1)))

def task2c():
    # result = []

    # for item in set1:
    #     if (item in set2) and (item in set3) and (item not in result):
    #         result.append(item)

    # return result
    return list(set(filter(lambda x: (x in set2) and (x in set3), set1)))

def task2d():
    # result = []

    # for i in range(1, 25 + 1):
    #     if i not in set1:
    #         result.append(i)

    # return result
    return list(filter(lambda x: x not in set1, range(1, 25 + 1)))

def task2e():
    # result = []

    # for i in range(1, 25 + 1):
    #     if (i not in set1) or (i not in set2) or (i not in set3):
    #         result.append(i)

    # return result
    return list(filter(lambda x: (x not in set1) or (x not in set2) or (x not in set3), range(1, 25 + 1)))

def task2f():
    # result = []

    # for i in range(1, 25 + 1):
    #     if (i not in set1) and (i not in set2) nad (i not in set3):
    #         result.append(i)

    # return result
    return list(filter(lambda x: (x not in set1) and (x not in set2) and (x not in set3), range(1, 25 + 1)))

def task3a(str1, str2):
    # str1 = str1.lower()
    # str2 = str2.lower()
    # result = []

    # for item in str1:
    #     if item in str2:
    #        result.append(item)

    # return result
    # return list(filter(lambda x: x in str2, str1))
    return list(filter(lambda x: x in str2.lower(), str1.lower()))

def task3b(str1, str2):
    # result = []

    # for i in range(len(str1)):
    #     if str1[i] in str2:
    #         result.append(str1[i])

    # return result
    return list(filter(lambda x: x in str2, str1))

def task3c(str1, str2):
    # result = []

    # big letters
    # for i in range(65, 90 + 1):
    #     if (chr(i) not in str1) and (chr(i) not in str2):
    #         result.append(chr(i))

    # small letters
    # for i in range(97, 122 + 1):
    #     if (chr(i) not in str1) and (chr(i) not in str2):
    #         result.append(chr(i))

    # return result
    return list(map(chr, list(filter(lambda x: (chr(x) not in str1) and (chr(x) not in str2), range(65, 90 + 1))))) + list(map(chr, list(filter(lambda x: (chr(x) not in str1) and (chr(x) not in str2), range(97, 122 + 1)))))

def task3d(str1, str2):
    # result = []

    # for i in range(65):
    #     if chr(i) in str1 and chr(i) in str2:
    #         result.append(chr(i))

    # for i in range(91, 96 + 1):
    #     if chr(i) in str1 and chr(i) in str2:
    #         result.append(chr(i))

    # for i in range(123, 127 + 1):
    #     if chr(i) in str1 and chr(i) in str2:
    #         result.append(chr(i))

    # return result
    return list(map(chr, list(filter(lambda x: chr(x) in str1 and chr(x) in str2, range(65))))) + list(map(chr, list(filter(lambda x: chr(x) in str1 and chr(x) in str2, range(91, 96 + 1)))))

def task3e(str1, str2):
    return list(map(chr, list(filter(lambda x: chr(x) in str1 and chr(x) in str2, range(65))))) + list(map(chr, list(filter(lambda x: chr(x) in str1 and chr(x) in str2, range(91, 96 + 1)))))

def task4(n):
    primes = set(range(2, n + 1))


    for i in range(2, int(n ** 0.5) + 1):
        if i in primes:
            primes -= set(range(i * 2, n + 1, i))

    return primes

def task5(n):
    primes = set(range(2, n + 1))

    for i in range(2, int(n ** 0.5) + 1):
        if i in primes:
            primes.difference_update(set(range(i * 2, n + 1, i)))

    return primes

mode = -1

while mode != 0:
    print("NAVIGATION")
    print("Enter 1 - task 2a")
    print("Enter 2 - task 2b")
    print("Enter 3 - task 2c")
    print("Enter 4 - task 2d")
    print("Enter 5 - task 2e")
    print("Enter 6 - task 2f")
    print("Enter 7 - task 3a")
    print("Enter 8 - task 3b")
    print("Enter 9 - task 3c")
    print("Enter 10 - task 3d")
    print("Enter 11 - task 3e")
    print("Enter 12 - task 4")
    print("Enter 13 - task 5")
    mode = int(input("Enter task: "))

    if mode == 1:
        print(task2a())
    elif mode == 2:
        print(task2b())
    elif mode == 3:
        print(task2c())
    elif mode == 4:
        print(task2d())
    elif mode == 5:
        print(task2e())
    elif mode == 6:
        print(task2f())
    elif mode == 7:
        print(task3a("HelloWorld", "Word"))
    elif mode == 8:
        print(task3b("Helloworld", "Word"))
    elif mode == 9:
        print(task3c("ABC", "abc"))
    elif mode == 10:
        print(task3d("13234@##", "#@7990-13"))
    elif mode == 11:
        print(task3e("13234@##", "#@7990-13"))
    elif mode == 12:
        print(task4())
    elif mode == 13:
        print(task5())