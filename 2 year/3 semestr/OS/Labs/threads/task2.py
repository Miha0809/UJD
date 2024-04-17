import threading

def is_prime(num):
    if num < 2:
        return False

    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False

    return True

def check_primes(numbers):
    for num in numbers:
        if is_prime(num):
            print(f"{num} is a prime number")
        else:
            print(f"{num} is not a prime number")

user_input = input("Enter numbers separated by space: ")
numbers = list(map(int, user_input.split()))

thread = threading.Thread(target=check_primes, args=(numbers,))
thread.start()
thread.join()
