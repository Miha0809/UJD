(defrule Naprawa-DNS
   (problem-sieci)
   (problem-dns ?serwer)
   =>
   (printout t "Wystąpił problem z DNS na serwerze " ?serwer ". Podejmuję próbę restartu usługi DNS." crlf)
   ; Dodaj tu polecenie restartu usługi DNS (np. za pomocą komendy systemowej)
)