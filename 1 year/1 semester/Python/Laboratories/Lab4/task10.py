# -*- coding: utf-8 -*-
"""
2 graczy, 2 kostki, 
l. tur podaje uzytkownik
gracz1 > gracz2
gracz1 < gracz2
gracz1 == gracz2
"""

import random
from pickle import TRUE

gracz1_total = 0
gracz2_total = 0


def rzut_kostka():
    suma = 0
    for i in range(0, 2):
        rzut = random.randint(1, 6)
        suma += rzut
    return suma

if __name__ == "__main__":
    print('Witaj w grze rzut kostką! W danej turze każdy z zawodników rzuca dwoma kostkami. Turę wygrywa ten zawodnik, który na samym końcu tury będzie miał większą ilosc zwyciestw')

    tury = int(input('Ile tur będziemy grać?'))

    while tury > 0:
        gracz1 = rzut_kostka()
        gracz2 = rzut_kostka()
        dogrywka = False

        print('Gracz rzuca kostką. Suma oczek wynosi {}'.format(gracz1))
        print('Gracz rzuca kostką. Suma oczek wynosi {}'.format(gracz2))

        if gracz1 > gracz2:
            print('Gracz1 wygrał!')
            gracz1_total += 1
        elif gracz1 < gracz2:
            print('Gracz2 wygrał!')
            gracz2_total += 1
        elif gracz1 == gracz2:
            print('Pojedynek zakończył się remisem!')

        else:
            print('Cos poszlo nie tak, konczymy!')
            break

        if tury == 1:
            if gracz1_total == gracz2_total:
                print('Wyglada na to ze mamy remis. DOGRYWKA!')
                dogrywka = TRUE
                tury += 1
        print('Gracz1 wygrał {} gier, Gracz2 wygrał {} gier'.format(gracz1_total, gracz2_total))

        tury -= 1

        if gracz1_total > gracz2_total:
            print('Grę wygrywa Gracz 1 --GRATULACJE--')
        elif gracz1_total < gracz2_total:
            print('Grę wygrywa Gracz2. --GRATULACJE--')
