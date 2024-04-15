class Punkt:
    __slots__ = ("_x", "_y")

    def __init__(self, x: int = 0, y: int = 0):
        self._x = x
        self._y = y
    
    @property
    def x(self) -> int:
        return self._x
    
    @x.setter
    def x(self, value) -> None:
        self._x = value
    
    @x.deleter
    def x(self) -> None:
        del self._x

    @property
    def y(self) -> int:
        return self._y

    @y.setter
    def y(self, value) -> None:
        self._y = value

    @y.deleter
    def y(self) -> None:
        del self._y

    def move(self, deltaX, deltaY) -> None:
        self._x += deltaX
        self._y += deltaY

    def __repr__(self) -> str:
        return f"Punkt({self._x}, {self._y})"

    def __str__(self) -> str:
        return f"({self._x}, {self._y})"
