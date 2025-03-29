(defrule Problem-MySQL-Sieć
   (and (problem-sieci) (błąd-mysql ?serwer))
   =>
   (printout t "Występują problemy z siecią i MySQL na serwerze " ?serwer ". Proponowane kroki naprawcze: ..." crlf))