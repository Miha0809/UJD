import random
from cat import Cat

FILE_NAME = "toys.txt"

def main():
    count_boxes = int(input("Enter count boxes: "))
    cat = Cat()
    print(cat.say_hello())

    with open(FILE_NAME, "r") as file:
        toys = file.read().split()

        for box in range(count_boxes):
            number = random.randint(1, 3)
            toy = toys[random.randint(0, len(toys) - 1)]

            if number == 1:
                print("The cat passes by the toy indifferently")
            elif number == 2:
                cat.likes(toy)
                cat.write_favorites()
            elif number == 3:
                cat.takes_offense(toy)
                cat.write_disliked()


if __name__ == "__main__":
    main()
