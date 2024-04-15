class Measurable:
    def __init__(self, p: float = 0, q: float = 1) -> None:
        nwd = self.NWD(p, q)
        self.p = p / nwd
        self.q = q / nwd
        
    def getNumerator(self) -> float:
        return self.p
    
    def getDenominator(self) -> float:
        return self.q

    def NWD(self, a, b) -> float:
        if b > 0:
            return self.NWD(b, a % b)
        else:
            return a

    def __float__(self) -> float:
        return (float)(self.p / self.q)
    
    def __neg__(self) -> object:
        return Measurable(-self.p, self.q)

    def __pos__(self) -> object:
        return Measurable(self.p, self.q)

    def __add__(self, other: object) -> object:
        return Measurable(self.p * other.p + self.q * other.q, self.q * other.q)
    
    def __iadd__(self, other: object) -> object:
        self.p += other.p
        self.q += other.q

        return self
    
    def __sub__(self, other: object) -> object:
        return Measurable(self.p * other.p - self.q * other.q, self.q * other.q)

    def __isub__(self, other: object) -> object:
        self.p -= other.p
        self.q -= other.q

        return self
        
    def __eq__(self, other: object) -> bool:
        return (self.q == other.q) and (self.p == other.p)
    
    def __ne__(self, other: object) -> bool:
        return not self == other
    
    def __lt__(self, other: object) -> bool:
        return self.p * other.q < self.q * other.p
    
    def __le__(self, other: object) -> bool:
        return self.p * other.q <= self.q * other.p
    
    def __gt__(self, other: object) -> bool:
        return self.p * other.q > self.q * other.p
    
    def __ge__(self, other: object) -> bool:
        return self.p * other.q >= self.q * other.p
    
    def __mul__(self, other) -> object:
        return Measurable(self.p * other.p, self.q * other.q)
    
    def __truediv__(self, other) -> object:
        return Measurable(self.p / other.p, self.q / other.q)

    def __floordiv__(self, other) -> object:
        return Measurable(self.p // other.p, self.q // other.q)

    def __repr__(self) -> str:
        return f"Measurable({self.p}, {self.q})"

    def __str__(self) -> str:
        return f"({self.p}, {self.q})"
