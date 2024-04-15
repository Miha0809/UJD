from segregator import Segregator, NazwanySegregator

s1 = NazwanySegregator("Zielony", 400, 30)
s2 = NazwanySegregator("Niebieski", 300)

print(f"Ilość włożonych stron w segregatorze s1: {s1.ileWlozonych()}")
print(f"Ilość stron, które może pomieścić segregator s1: {s1.ilePomiesci()}")
print(f"Ilość włożonych stron w segregatorze s2: {s2.ileWlozonych()}")
print(f"Ilość stron, które może pomieścić segregator s2: {s2.ilePomiesci()}")

seg_sum = s1 + s2
print(f"Segregator powstały z dodawania s1 i s2: {seg_sum}")

if s1.ileWlozonych() > s2.ileWlozonych():
    seg_diff = s1 - s2.ileWlozonych()
else:
    seg_diff = s2 - s1.ileWlozonych()

if seg_diff.ileWlozonych() > 0:
    seg_diff.oproznij()

print(f"Segregator powstały z odejmowania s1 i s2 (po opróżnieniu): {seg_diff}")

if s1 > s2:
    print("Segregator s1 ma większą maksymalną pojemność.")
else:
    print("Segregator s2 ma większą maksymalną pojemność.")

s1 += s2
print(f"Po przelożeniu stron z s2 do s1:\n{s1}\n{s2}")

try:
    del s2.name
except AttributeError:
    print("Nie można usunąć właściwości 'name' z obiektu s2.")

s2.name = "Czerwony"
print(f"Po zmianie nazwy obiektu s2:\n{s2}\n")

print(f"Informacje o segregatorach:\n{s1}\n{s2}")