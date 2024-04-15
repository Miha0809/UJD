import math

class Address:
    def __init__(self, street, code):
        self.street = street
        self.code = code

    def __init__(self, street, code, city, number, optional_apartment_number):
        self.street = street
        self.code = code
        self.number = number
        self.city = city
        self.optional_apartement_number = optional_apartment_number

    def comesBefore(self, other):
        return self.code < other.code

    def show(self):
        print(f"{self.street}, {self.number}, {self.optional_apartement_number}")
        print(f"{self.code}, {self.city}")
def task1():
    address1 = Address("Dekabrystow", "42-200", "Czestochowa", "19/17", 49)
    address1.show()

    address2 = Address("Dekabrystow", "41-200", "Czestochowa", "19/17", 49)
    address2.show()

    print(address1.comesBefore(address2))

class SodaCan:
    def __init__(self, height, radius):
        self.height = height
        self.radius = radius
        name = "JAd"

    def getSurfaceArea(self):
        return (math.pi * self.radius ** 2) + (2 * math.pi * self.radius) * self.height

    def getVolume(self):
        return math.pi * self.radius ** 2 * self.height
def task2():
    soda = SodaCan(5, 6)
    print(soda.getSurfaceArea())
    print(soda.getVolume())

class Car:
    def __init__(self, consumption, volume = 0):
        self.consumption = consumption
        self.volume = volume
        self.fuel = 0
        self.distance = 0
    
    def getFuelLevel(self):
        return f"Fuel: {self.fuel}\nDistance: {self.distance}"
    
    def drive(self, distance):
        if self.distance - (distance / 1000) > 0:
            self.fuel -= (1 / self.consumption) * (distance / 1000)
            self.distance -= distance
        else:
            print("You need to refuel")
    
    def addFuel(self, fuel):
        if self.fuel + fuel <= self.volume:
            self.fuel += fuel
            self.distance += self.consumption * fuel
        else:
            print("The fuel tank is too small")
def task3():
    car = Car(20, 40)
    car.addFuel(30)
    car.drive(100)
    print(car.getFuelLevel())

class Student:
    def __init__(self, name, lastname, total_quiz_score = 0):
        self.name = name
        self.lastname = lastname
        self.total_quiz_score = total_quiz_score
        self.count = 0

    def getName(self):
        return self.name
    
    def addQuiz(self, score):
        self.count += 1
        self.total_quiz_score += score

    def getTotalScore(self):
        return self.total_quiz_score
    
    def getAverageScore(self):
        return self.total_quiz_score / self.count
    
    def __str__(self):
        return f"Name: {self.name}\nLastName: {self.lastname}\nTotal: {self.total_quiz_score}"
def task4():
    student = Student("Mykhailo", "Hulii")
    student.addQuiz(100)
    student.addQuiz(50)
    student.addQuiz(75)
    student.addQuiz(25)
    print(student.getName())
    print(student.getAverageScore())
    print(student.getTotalScore())
    print(student)


def main():
    mode = -1

    while mode != 0:
        print("NAVIGATION")
        print("Enter 1 - task 1")
        print("Enter 2 - task 2")
        print("Enter 3 - task 3")
        print("Enter 4 - task 4")
        print("Enter 0 - EXIT")
        mode = int(input("Enter task: "))

        if mode == 1:
            task1()
        elif mode == 2:
            task2()
        elif mode == 3:
            task3()
        elif mode == 4:
            task4()

if __name__ == "__main__":
    main()