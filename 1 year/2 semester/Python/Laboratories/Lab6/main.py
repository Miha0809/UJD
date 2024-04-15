import pickle
from test_nazwanypunkt import NamePunkt
from punkt import Punkt

x1 = Punkt(1, 2)
print(x1._x)
print(x1._y)
print(x1)
print(repr(x1))

x1.x = 4
x1.y = 7
print(x1)

punkt1 = Punkt(1, 2)
punkt2 = Punkt(3, 4)
name_punkt1 = NamePunkt("A", 5, 6)
name_punkt2 = NamePunkt("B", 7, 8)

lista_punktow = [punkt1, punkt2, name_punkt1, name_punkt2]

with open("punkty.pkl", "wb") as file:
    pickle.dump(lista_punktow, file)
