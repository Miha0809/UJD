class Student:
    def __init__(self, fullname: str, age):
        self.fullname = fullname
        self.age = age

    def __float__(self):
        return (float)(self.age / 1.0)
    
    def __add__(self, other):
        return Student(self.fullname + other.fullname, self.age + other.age)
    
    def __iadd__(self, other):
        self.fullname += other.fullname
        self.age += other.age

        return self
    
    def __sub__(self, other):
        return Student(self.fullname.replace(other.fullname, ""), self.age - other.age)
    
    def __isub__(self, other):
        self.fullname = self.fullname.replace(other.fullname, "")
        self.age -= other.age

        return self
    
    def __eq__(self, other):
        return (self.fullname == other.fullname) and (self.age == other.age)
    
    def __ne__(self, other):
        return not self == other
    
    def __lt__(self, other):
        return (self.fullname < other.fullnamne) and (self.age < other.age)

    def __le__(self, other):
        return (self.fullname < other.fullnamne) and (self.age < other.age)

    def __gt__(self, other):
        return (self.fullname > other.fullnamne) and (self.age > other.age)

    def __ge__(self, other):
        return (self.fullname >= other.fullnamne) and (self.age >= other.age)

    def __mul__(self, other):
        return Student(self.fullname * len(other.fullname), self.age * other.age)

    def __truediv__(self, other):
        return Student(self.fullname, self.age / other.age)
    
    def __floordiv__(self, other):
        return Student(self.fullname, self.age // other.age)

    def __repr__(self) -> str:
        return f"Student({self.fullname}, {self.age})"
    
    def __str__(self):
        return f"({self.fullname}, {self.age})"