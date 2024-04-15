from punkt import Punkt


class NamePunkt(Punkt):
    __slots__ = ("_name")

    def __init__(self, name: str, x: int = 0, y: int = 0):
        super().__init__(x, y)
        self._name = name

    @property
    def name(self) -> str:
        return self._name
    
    @name.setter
    def name(self, value) -> None:
        self._name = value

    @name.deleter
    def name(self) -> None:
        del self._name

    def __repr__(self) -> str:
        return f"NamePunkt({self._x}, {self._y})"
    
    def __str__(self) -> str:
        return f"({self._name}, {self._x}, {self._y})"