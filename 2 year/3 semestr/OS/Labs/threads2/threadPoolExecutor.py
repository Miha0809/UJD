from concurrent.futures import ThreadPoolExecutor

def square_number(num):
    return num**2

user_input = input("Enter numbers separated by space: ")
numbers = list(map(int, user_input.split()))

with ThreadPoolExecutor() as executor:
    squared = list(executor.map(square_number, numbers))

result = ' '.join(map(str, squared))
print(result)
