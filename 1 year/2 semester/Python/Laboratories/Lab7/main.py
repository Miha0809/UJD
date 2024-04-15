from functools import reduce
from city_iterator import CityIterator
import sys

def calculate_sum_task2(n):
    numbers = list(range(1, n + 1))
    total_sum = sum(numbers)
    return total_sum

def calculate_sum_task3(n):
    total_sum = sum(range(1, n + 1))
    return total_sum

def fibonacci(length):
    fib_list = [0, 1]
    while len(fib_list) < length:
        fib_list.append(fib_list[-1] + fib_list[-2])
    return fib_list[:length]

def main():
    task = -1

    while task != 0:
        print("Enter 1 - task 1")
        print("Enter 2 - task 2")
        print("Enter 3 - task 3")
        print("Enter 5 - task 5")
        print("Enter 6 - task 6")
        print("Enter 7 - task 7")
        print("Enter 8 - task 8")
        print("Enter 9 - task 9")
        print("Enter 10 - task 10")
        print("Enter 0 - EXIT")
        task = int(input("Enter task >>> "))

        if task == 1:
            cities = ["Warszawa", "Kraków", "Wrocław", "Poznań", "Gdańsk"]
            iterator = CityIterator(cities)

            while True:
                try:
                    city = next(iterator)
                    print(city)
                except StopIteration:
                    break
        elif task == 2:
            if len(sys.argv) != 2:
                print("Enter number n as argument!")
                sys.exit(1)

            n = int(sys.argv[1])

            total_sum = calculate_sum_task2(n)
            print(total_sum)
        elif task == 3:
            if len(sys.argv) != 2:
                print("Enter number n as argument!")
                sys.exit(1)

            n = int(sys.argv[1])

            total_sum = calculate_sum_task3(n)
            print(total_sum)
        elif task == 5:
            celsius_temperatures = [25, 30, 15, 10, 20]
            fahrenheit_temperatures = list(map(lambda c: c * 9 / 5 + 32, celsius_temperatures))
            print(fahrenheit_temperatures)
        elif task == 6:
            fahrenheit_temperatures = [77, 86, 59, 50, 68]
            celsius_temperatures = list(map(lambda f: (f - 32) * 5/9, fahrenheit_temperatures))
            print(celsius_temperatures)
        elif task == 7:
            length = 10
            fibonacci_numbers = fibonacci(length)
            odd_fibonacci_numbers = list(filter(lambda x: x % 2 != 0, fibonacci_numbers))
            print(odd_fibonacci_numbers)
        elif task == 8:
            length = 10 
            fibonacci_numbers = fibonacci(length)
            even_fibonacci_numbers = list(filter(lambda x: x % 2 == 0, fibonacci_numbers))
            print(even_fibonacci_numbers)
        elif task == 9:
            number_list = [10, 5, 20, 15, 25]
            max_number = max(number_list)
            print("Max number (function max):", max_number)
            max_number_reduce = reduce(lambda x, y: x if x > y else y, number_list)
            print("Max number (function reduce):", max_number_reduce)
        elif task == 10:
            number_list = [10, 5, 20, 15, 25]
            max_number = reduce(lambda x, y: x if x > y else y, number_list)
            print("Max number:", max_number)

