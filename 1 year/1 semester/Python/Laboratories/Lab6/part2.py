def task1(arr):
    # count = 0
    #
    # for item in arr:
    #     if item % 2 == 0:
    #         count += 1
    #
    # return count
    return len(list(filter(lambda item: (item % 2 == 0), arr)))


def task2(arr, number):
    # count = 0
    #
    # for item in arr:
    #     if item == number:
    #         count += 1
    #
    # return count
    return len(list(filter(lambda item: (item == number), arr)))


def task3(arr):
    # suma = 0
    #
    # for item in arr:
    #     suma += item
    #
    # return suma / len(arr)
    return sum(arr) / len(arr)


def task4(arr):
    # min = arr[0]
    # minIndex = 0
    #
    # for i in range(len(arr)):
    #     if min > arr[i]:
    #         min = arr[i]
    #         minIndex = i
    #
    # return f"Min: {min}\nIndex: {minIndex}"
    return f"Min: {min(arr)}\nIndex: {arr.index(min(arr))}"


def task5(arr):
    # count = 0
    #
    # for item in arr:
    #     if (item == 'a') or (item == 'e') or (item == 'o') or (item == 'u') or (item == 'i') or (item == 'y'):
    #         count += 1
    #
    # return count
    return len(list(filter(
        lambda item: (item == 'a') or (item == 'e') or (item == 'o') or (item == 'u') or (item == 'i') or (item == 'y'),
        arr)))


def task6(arr):
    # max = arr[0]
    # min = arr[0]
    #
    # for item in arr:
    #     if max < item:
    #         max = item
    #     elif min > item:
    #         min = item
    #
    # return max - min
    return max(arr) - min(arr)


def task7(arr, n):
    # for i in range(len(arr)):
    #     for j in range(i, len(arr)):
    #         if arr[i] == n ** 2:
    #             return True
    #
    # return False
    return bool((n ** 2) in arr)


def task8(arr):
    # nie wiem jak napisać w jedenej linii :D
    result = []

    for item in arr:
        if item not in result:
            result.append(item)

    return result



def task9(arr1, arr2):
    # result = []
    #
    # for item in arr1:
    #     if item in arr2:
    #         result.append(item)
    #
    # return result
    return list(filter(lambda item: item in arr2, arr1))


def task10(arr1, arr2):
    return sorted(arr1) == sorted(arr2)
