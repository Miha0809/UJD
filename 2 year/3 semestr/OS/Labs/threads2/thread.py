import threading

def square_numbers(numbers):
    squared = [num**2 for num in numbers]
    result = ' '.join(map(str, squared))
    print(result)

user_input = input("Enter numbers separated by space: ")
numbers = list(map(int, user_input.split()))

thread = threading.Thread(target=square_numbers, args=(numbers,))
thread.start()
thread.join()
