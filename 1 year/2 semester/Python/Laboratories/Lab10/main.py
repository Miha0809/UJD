import re 

def task17():
     for word in ['lis', 'pies', 'koń']:
        a = re.search(r'\b{}\b'.format(re.escape(word)), "Szybki brązowy lis przeskakuje nad leniwym psem", re.IGNORECASE)

        if a:
            print("Jest ", word)
        else:
            print("Nie jest ", word)

def task23():
    for item in re.finditer(r'\b\d+', 'To jest przykład łańcucha 123 z liczbą 4567.'):
        print("\t", item.group())
        print(item.start())
        print(item.end())

def main():
    print(re.match(r'^[a-zA-Z0-9]+$', "sjkdgfu1723649AKSFGIAS")[0]) # 1
    print(bool(re.match(r'^a[b]*$', 'abbbbbb')[0])) # 2
    print(bool(re.match(r'^a[b]+$', 'ab')[0])) # 3
    print(bool(re.match(r'^ab{3}$', 'abbb')[0])) # 4
    print(bool(re.match(r'^ab{2,3}$', 'abb')[0])) # 5
    print(re.findall(r'[a-z]+(?:_[a-z]+)+', 'hello word one_two')[0]) # 6
    print(re.findall(r'[a-z][A-Z]+', 'hello word one_twoP')[0]) # 7
    print(re.match(r'^a.*b$', 'asadfb')[0]) # 8
    print(re.match(r'^\w*', 'asadfb')[0]) # 9
    print(re.search(r'\W*$', '3+=1sxfsasadfb_!+-)()')[0]) # 10
    print(re.search(r'\b\w*z\w*\b', 'helzlo')[0]) # 11
    print(re.search(r'\b.\w*z\w\b', 'zalo olaz ozo')[0]) # 12
    print(re.search(r'\b[a-zA-Z0-9_]+\b', 'zalo olaz ozo')[0]) # 13
    print(re.search(r'\b[a-zA-Z0-9_]+\b', 'zalo olaz ozo')[0]) # 14
    print(bool(re.search('\d*$', "asdfsd123d")[0])) # 15
    print(re.findall(r'[0-9]{1,3}', "jhasgudfhag122hjfs")) # 16
    task17()
    print(re.search('lis', "Szybki brązowy lis przeskakuje nad leniwym psem").span()) # 18
    print(re.findall(r'\bćwiczenia\b', "Ćwiczenia z Pythona, ćwiczenia z Javy, ćwiczenia z C++")) # 19
    print(re.search(r'\bworld\b', "Hello, world!")[0]) # 20
    print(re.findall(r'\d+', "To jest przykład łańcucha 123 z liczbą 4567.")) # 21
    print(re.findall(r'\b[a-e]\w*', 'apple banana orange elephant ant eagle zella')) # 22
    task23()
    print(re.findall('\b\w{5}\b', "Hello, world! How are you?")) # 24
    print(re.findall(r'\b\w{1,5}\b', "Hello, world! How are you? I Love UKRAINE")) # 25
    print(re.findall(r'\b\w{4,}\b', "Hello, world! How are you? I Love UKRAINE")) # 26
    print(re.findall(r'"(.*?)"', '"Ćwiczenia z Pythona, ćwiczenia z Javy, ćwiczenia z C++" jhGLDSuifhig "dsa"')) # 27
    print(re.findall(r'\bhttps?://\S+', "To jest przykład tekstu zawierającego adresy URL, takie jak https://www.example.com i http://example.org.")) # 28
    print(re.findall(r'(\b[A-Z]\w+)', "Hello, World how are You I!")) # 29
    print(re.findall(r'\b\d+\.\d{,2}+\b', "123 123.1 123.12 123.123 123.1234")) #30

main()