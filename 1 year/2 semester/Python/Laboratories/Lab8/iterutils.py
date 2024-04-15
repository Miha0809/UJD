from itertools import count, islice, chain, repeat


def pobierz(n, iterable):
    return list(islice(iterable, n))


def dolacz(value, iterator):
    return chain([value], iterator)


def tabela(func, start=0):
    return map(func, count(start))


def nty(iterable, n, default=None):
    return next(islice(iterable, n, None), default)


def takie_same(iterable):
    iterator = iter(iterable)
    try:
        first = next(iterator)
    except StopIteration:
        return True
    return all(element == first for element in iterator)


def policz(iterable, pred=bool):
    return sum(map(pred, iterable))


def wypełnij(iterable):
    return chain(iterable, repeat(None))


def nrazy(iterable, n):
    return chain.from_iterable(repeat(iterable, n))


def splaszcz(list_of_lists):
    return chain.from_iterable(list_of_lists)


def powtarzaj(func, times=None, *args):
    if times is None:
        return chain.from_iterable(repeat(func(*args)))
    else:
        return chain.from_iterable(repeat(func(*args), times))
