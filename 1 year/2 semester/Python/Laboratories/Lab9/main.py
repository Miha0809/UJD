import math
import random


def podzielne_przez_3_i_5(limit):
    for num in range(limit):
        if num % 3 == 0 and num % 5 == 0:
            yield num

def podzielne_przez_3_i_5():
    num = 0
    while True:
        if num % 3 == 0 and num % 5 == 0:
            yield num
        num += 1
    
def fibonacci(limit):
    a, b = 0, 1
    while a < limit:
        yield a
        a, b = b, a + b

def fibonacci():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b

def divisible_by_3_or_5(n):
    return (num for num in range(1, n+1) if num % 3 == 0 or num % 5 == 0)

def generate_float_list(n):
    return [round(random.uniform(-100, 100), 2) for _ in range(n)]

def main():
    task = -1

    while task != 0:
        print("\t\tNAVIGATION")
        print("Enter 1 - task 1")
        print("Enter 2 - task 2")
        print("Enter 3 - task 3")
        print("Enter 4 - task 4")
        print("Enter 5 - task 5")
        print("Enter 6 - task 6")
        print("Enter 0 - EXIT")
        task = int(input("Enter task >>> "))

        if task == 1:
            n = int(input("Enter number: "))
            for num in podzielne_przez_3_i_5(n):
                print(num)
        elif task == 2:
                n = int(input("Enter number: "))
                generator = podzielne_przez_3_i_5()
                num = next(generator)
                while num < n:
                    print(num)
                    num = next(generator)
        elif task == 3:
            n = int(input("Enter number: "))
            for num in fibonacci(n):
                print(num)
        elif task == 4:
            n = int(input("Enter number: "))
            generator = fibonacci()
            num = next(generator)
            while num < n:
                print(num)
                num = next(generator)
        elif task == 5:
            n = int(input("Enter number: "))
            result = list(divisible_by_3_or_5(n))
            print(result)
        elif task == 6:
            n = int(input("Enter number: "))
            float_list = generate_float_list(n)

            print("List numbers float: ")
            print(float_list)

            positive_numbers = [num for num in float_list if num > 0]
            positive_integers = [int(num) for num in positive_numbers]
            math_floor_values = [math.floor(num) for num in float_list]
            math_ceil_values = [math.ceil(num) for num in float_list]
            math_log_values = [math.log(num) for num in float_list if num > 0]

            print("List positive numbers: ")
            print(positive_numbers)

            print("List posotove numbers convert to int: ")
            print(positive_integers)

            print("List numbers math.floor: ")
            print(math_floor_values)

            print("List numbers math.ceil: ")
            print(math_ceil_values)

            print("List 1math.log for positive numbers: ")
            print(math_log_values)

if __name__ == "__main__":
    main()