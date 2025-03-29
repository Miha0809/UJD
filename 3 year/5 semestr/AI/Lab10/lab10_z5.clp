(defrule Sprawdzenie-Rozwiazania
   (problem-sieci)
   (not (problem-sieci))  ; Sprawdzenie, czy problem z siecią został rozwiązany
   =>
   (printout t "Problem z siecią został rozwiązany. Proces naprawczy zakończony." crlf))