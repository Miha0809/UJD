% Deklaracja dynamicznych faktów dla unikania powtórzeń
:- dynamic zadany_objaw/1.



% Fakty - Definicja chorób
choroba(grypa) :- objaw(goraczka), objaw(kaszel), objaw(bol_glowy).
choroba(przeziebienie) :- objaw(kichanie), objaw(kaszel), objaw(zatkany_nos).
choroba(angina) :- objaw(bol_gardla), objaw(goraczka), objaw(trudnosci_z_polknieciem).
choroba(migrena) :- objaw(bol_glowy), objaw(zawroty_glowy).
choroba(alergia) :- objaw(kichanie), objaw(swedzenie_oczu), objaw(zaczerwienienie_skory).
choroba(zapalenie_oskrzeli) :- objaw(kaszel), objaw(dusznosci).
choroba(grypa_zoladkowa) :- objaw(nudnosci), objaw(wymioty), objaw(goraczka).

% Reguły interakcji - Pytania wstępne
pytaj_o_objawy :-
    write('Czy uwazasz, ze jestes chory? (tak/nie)'), nl,
    read(Odpowiedz),
    (Odpowiedz == tak ->
        write('Czy masz mniej niz 18 lat? (tak/nie)'), nl,
        read(WiekOdp),
        (WiekOdp == tak -> Wiek = mlodszy ; Wiek = dorosly),
        assertz(wiek(Wiek))
    ; 
        write('Nie wykryto choroby.'), nl, fail
    ).

% Styl życia
styl_zycia :-
    write('Czy palisz papierosy? (tak/nie)'), nl,
    read(Pali),
    assertz(styl_zycia(pali, Pali)),
    write('Czy uprawiasz regularnie sport? (tak/nie)'), nl,
    read(Sport),
    assertz(styl_zycia(sport, Sport)).

% Rozpoznawanie objawów - zapamiętywanie zadanych pytań
objaw(Objaw) :-
    \+ zadany_objaw(Objaw),  % Sprawdza, czy objaw już nie był pytany
    write('Czy masz objaw: '), write(Objaw), write('? (tak/nie)'), nl,
    read(Odpowiedz),
    assertz(zadany_objaw(Objaw)),  % Zapisuje objaw, aby nie pytać ponownie
    Odpowiedz == tak.

% Diagnoza - sprawdzanie objawów pacjenta
diagnoza :-
    retractall(zadany_objaw(_)), % Resetowanie pamięci objawów
    pytaj_o_objawy,
    styl_zycia,
    findall(Objaw, (choroba(Choroba), objaw(Objaw)), ObjawySurowe),
    sort(ObjawySurowe, Objawy), % Usunięcie duplikatów objawów
    findall(Choroba, (choroba(Choroba), sprawdz_objawy(Choroba, Objawy)), Wyniki),
    sprawdz_alergie,
    (   Wyniki = [] 
    ->  write('Nie moge ustalic diagnozy na podstawie podanych objawow.'), nl
    ;   write('Mozliwe diagnozy: '), write(Wyniki), nl,
        zalecenia(Wyniki),
        wyjasnienia(Wyniki)
    ).

% Sprawdzanie objawów dla choroby
sprawdz_objawy(Choroba, ObjawyPacjenta) :-
    choroba(Choroba),
    findall(Objaw, (choroba(Choroba), objaw(Objaw)), ObjawyChoroby),
    subset(ObjawyChoroby, ObjawyPacjenta).

% Zalecenia dla chorób
zalecenia([]).
zalecenia([Choroba|T]) :-
    zalecenie(Choroba, Rekomendacja),
    write('Rekomendacja dla '), write(Choroba), write(': '), write(Rekomendacja), nl,
    zalecenia(T).

zalecenie(grypa, 'Skonsultuj sie z lekarzem, odpoczywaj, pij duzo plynow.').
zalecenie(przeziebienie, 'Zazyj leki dostepne bez recepty, odpoczywaj.').
zalecenie(angina, 'Skonsultuj sie z lekarzem, moze byc konieczna antybiotykoterapia.').
zalecenie(migrena, 'Unikaj stresu, odpocznij w ciemnym pokoju.').
zalecenie(alergia, 'Zazyj leki antyhistaminowe, unikaj alergenow.').
zalecenie(zapalenie_oskrzeli, 'Skonsultuj sie z lekarzem, stosuj inhalacje.').
zalecenie(grypa_zoladkowa, 'Pij duzo plynow, unikaj ciezkich potraw.').



% Wyjaśnienia dotyczące chorób
wyjasnienia([]).
wyjasnienia([Choroba|T]) :-
    wyjasnij(Choroba),
    wyjasnienia(T).

wyjasnij(grypa) :-
    write('Grypa to wirusowa infekcja ukladu oddechowego, trwajaca zwykle 7-10 dni.'), nl.
wyjasnij(przeziebienie) :-
    write('Przeziebienie to lagodna infekcja wirusowa, trwajaca kilka dni.'), nl.
wyjasnij(angina) :-
    write('Angina to bakteryjne zapalenie gardla, czesto wymagajace antybiotykow.'), nl.
wyjasnij(migrena) :-
    write('Migrena to silny bol glowy, czesto powiazany ze swiatlowstretem i nudnosciami.'), nl.
wyjasnij(alergia) :-
    write('Alergia to nadwrazliwosc ukladu immunologicznego na alergeny.'), nl.
wyjasnij(zapalenie_oskrzeli) :-
    write('Zapalenie oskrzeli to infekcja drog oddechowych powodujaca kaszel i dusznosci.'), nl.
wyjasnij(grypa_zoladkowa) :-
    write('Grypa zoladkowa to infekcja wirusowa przewodu pokarmowego, objawiajaca sie wymiotami i biegunka.'), nl.

% Sezonowe alergie
pora_roku :-
    write('Jaka jest aktualna pora roku? (wiosna/lato/jesien/zima)'), nl,
    read(Pora),
    assertz(pora_roku(Pora)).

sprawdz_alergie :-
    pora_roku,
    (   pora_roku(wiosna) ; pora_roku(lato) ),
    write('Alergie sezonowe sa aktywne w tej porze roku.'), nl.
sprawdz_alergie :-
    write('Alergie sezonowe nie sa aktywne w tej porze roku.'), nl.