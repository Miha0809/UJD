class Polynomial:
    def __init__(self, coefficients: list = []):
        self.__coefficients: list = coefficients

    def deg(self) -> int:
        return self.__coefficients.index(self.__coefficients[len(self.__coefficients) - 1])
    
    def inc_deg(self, degree: int) -> list:
        for i in range(degree - (len(self.__coefficients) - 1)):
            self.__coefficients.append(0)

        return self.__coefficients

    def __neg__(self) -> object:
        for i in range(len(self.__coefficients)):
            self.__coefficients[i] = -self.__coefficients[i]

        return Polynomial(self.__coefficients)
    
    def __add__(self, other: object) -> object:
        if (len(self.__coefficients) < (len(other.__coefficients))):
            self.__coefficients = self.inc_deg(len(self.__coefficients))
        elif (len(self.__coefficients) > (len(other.__coefficients))):
            other.__coefficients = other.inc_deg(len(other.__coefficients))

        for i in range(len(self.__coefficients)):
            self.__coefficients[i] = (self.__coefficients[i]) + (other.__coefficients[i])

        return Polynomial(self.__coefficients)
    
    def __sub__(self, other: object) -> object:
        if (len(self.__coefficients) < (len(other.__coefficients))):
            self.__coefficients = self.inc_deg(len(self.__coefficients))
        elif (len(self.__coefficients) > (len(other.__coefficients))):
            other.__coefficients = other.inc_deg(len(other.__coefficients))

        for i in range(len(self.__coefficients)):
            self.__coefficients[i] = (self.__coefficients[i]) - (other.__coefficients[i])

        return Polynomial(self.__coefficients)
    
    def __eq__(self, other) -> bool:
        return self.__coefficients == other.__coefficients

    def __call__(self, x) -> int:
        suma: int = 0

        for i, p in enumerate(self.__coefficients):
            suma += p * (x ** i)
            

        return suma

    def __str__(self) -> str:
        return f"({self.__coefficients})"