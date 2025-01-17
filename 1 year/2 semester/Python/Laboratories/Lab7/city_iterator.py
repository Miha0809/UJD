class CityIterator:
    def __init__(self, cities):
        self.cities = cities
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.cities):
            raise StopIteration
        city = self.cities[self.index]
        self.index += 1
        return city