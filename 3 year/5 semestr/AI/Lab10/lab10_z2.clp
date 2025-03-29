(defrule Problem-Serwer-Wielu
   (or (awaria-serwera ?*serwery) (błąd-systemowy ?*serwery))
   =>
   (printout t "Wystąpił problem z serwerami: " ?*serwery " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Komponent-Wielu
   (błąd-konfiguracji ?*komponenty)
   =>
   (printout t "Wystąpił błąd konfiguracji w komponentach: " ?*komponenty " - proponowane kroki naprawcze: ..." crlf))