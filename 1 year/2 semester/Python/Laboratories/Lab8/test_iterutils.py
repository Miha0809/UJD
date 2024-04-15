from iterutils import *

def main():
    iterable = [1, 2, 3, 4, 5]

    print("Test dla funkcji pobierz:")
    print(pobierz(3, iterable))
    print(pobierz(10, iterable))
    print("\nTest dla funkcji dolacz:")
    iterator = iter(iterable)
    print(list(dolacz(0, iterator)))
    print("\nTest dla funkcji tabela:")
    func = lambda x: x * 2
    print(list(tabela(func, start=1)))

main()