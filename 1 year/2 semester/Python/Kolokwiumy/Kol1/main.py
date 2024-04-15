from polynomial import Polynomial

def main():
    mode: int = -1
    
    while mode != 0:
        print("NAVIGATION")
        print("Enter 1 - objects add")
        print("Enter 2 - objects sub")
        print("Enter 3 - deg()")
        print("Enter 4 - inc_deg()")
        print("Enter 5 - object neg")
        print("Enter 6 - equels object")
        mode = int(input("Enter mode: "))

        if mode == 1:
            first = Polynomial([1, 2, 3])
            second = Polynomial([1, 2 ,3, 4, 5])
            print(first + second)
        elif mode == 2:
            first = Polynomial([1, 2, 3])
            second = Polynomial([1, 2 ,3, 4, 5])
            print(first - second)
        elif mode == 3:
            first = Polynomial([1, 2, 3])
            print(first.deg())
        elif mode == 4:
            first = Polynomial([1, 2, 3])
            print(first.inc_deg())
        elif mode == 5:
            first = Polynomial([1, 2, 3])
            print(first.__neg__())
        elif mode == 6:
            first = Polynomial([1, 2, 3])
            second = Polynomial([1, 2 ,3, 4, 5])
            print(first == second)

            first = Polynomial([1, 2, 3])
            second = Polynomial([1, 2 ,3])
            print(first == second)

main()