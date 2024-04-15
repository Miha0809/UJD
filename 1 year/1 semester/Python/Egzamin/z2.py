def main():
    try:
        nazwa = input("Enter name file: ")
        liczba = int(input("Enter number: "))
        plikIn = open(nazwa, "r")
        plikOut = open("wynik.txt", "w")
        
        for line in plikIn:
            if str(liczba) in line:
                plikOut.write(line)

        plikIn.close()
        plikOut.close()
    except NameError as name:
        print(name)

if __name__ == "__main__":
    main()
