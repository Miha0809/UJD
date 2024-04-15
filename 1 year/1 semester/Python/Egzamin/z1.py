def zamien(Sl, Lan):
    for key in Sl:
        if Lan in key:
            Sl[key] *= 2
    return Sl

def main():
    # podpunkt a
    tydzien = {
            "poniedziałek": len("poniedziałek"),
            "wtorek": len("wtorek"),
            "środa": len("środa"),
            "czwartek": len("czwartek"),
            "piątek": len("piątek"),
            "sobota": len("sobota"),
            "niedziela": len("niedziela")}
    print(zamien(tydzien, 'ni'))
    
    #podpunkt b
    slowa = {}
    length = int(input("Enter length dictionary: "))
    
    for i in range(length):
        word = input("Enter key to dictionry: ")
        slowa[word] = len(word)

    print(slowa)

    search = input("Search word: ")
    print(zamien(slowa, search))

if __name__ == "__main__":
    main()
