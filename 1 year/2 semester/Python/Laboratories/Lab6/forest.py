import random


class Forest:
    """ Las """
    def __init__(self, liczba_drzew):
        self.drzewa = [Tree() for _ in range(liczba_drzew)]
        self.bobr = Beaver()

    def symuluj_ewolucje(self):
        while self.bobr.sila > 0 and self.drzewa:
            self.bobr.podgryz(random.choice(self.drzewa))
            for drzewo in self.drzewa:
                drzewo.rosnij()
                if drzewo.srednica <= 0:
                    self.drzewa.remove(drzewo)
                    break

        if self.bobr.sila <= 0:
            print("Bobr zmęczony. Ewolucja lasu zakończona.")
        elif not self.drzewa:
            print("Pierwsze drzewo powalone. Ewolucja lasu zakończona.")


class Tree(Forest):
    """ Drzewo """
    def __init__(self):
        self.srednica = 1

    def rosnij(self):
        self.srednica += 0.01

class Beaver:
    """ Bobr """
    def __init__(self):
        self.sila = 2

    def podgryz(self, drzewo):
        koszt = 0.07 * drzewo.srednica
        self.sila -= koszt
        drzewo.srednica -= 0.2

forest = Forest(10)
forest.symuluj_ewolucje()