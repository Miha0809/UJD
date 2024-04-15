class FooBar:
    def __init__(self, limit):
        self.limit = limit
        self.n = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.n < self.limit:
            self.n += 1
            if self.n % 3 == 0 and self.n % 5 == 0:
                return "FooBar"
            if self.n % 3 == 0:
                return "Foo"
            elif self.n % 5 == 0:
                return "Bar"
            else:
                return self.n
        else:
            raise StopIteration