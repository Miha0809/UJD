class Segregator:
    def __init__(self, maxKartek=500, ileStron=0):
        self._max = maxKartek
        self._ile = ileStron

    def ileWlozonych(self):
        return self._ile
    
    def ilePomiesci(self):
        return self._max - self._ile
    
    def zmienIle(self, ile):
        self._ile = ile

    def oproznij(self):
        self._ile = 0

    def __add__(self, other):
        return Segregator(self._max + other._max, self._ile + other._ile)
    
    def __sub__(self, n):
        max = self._max - n
        ile = self._ile - n

        if max < 0:
            max = 500
        if ile < 0:
            ile = 0

        return Segregator(max, ile)
    
    def __gt__(self, other):
        return self._max > other._max

    def __str__(self):
        return f"Segregator: maksymalna liczba kartek: {self._max}, aktualna liczba kartek: {self._ile}"
    
class NazwanySegregator(Segregator):
    def __init__(self, name, maxKartek=500, ileStron=0):
        super().__init__(maxKartek, ileStron)
        self._name = name

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, new_name):
        self._name = new_name

    @name.deleter
    def name(self):
        del self._name

    def __str__(self):
        return f"Nazwany Segregator: {self._name}, maksymalna liczba kartek: {self._max}, aktualna liczba kartek: {self._ile}"