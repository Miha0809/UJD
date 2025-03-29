(defrule MAIN::Problem-Backup
   (brak-kopii-zapasowej ?serwer)
   =>
   (printout t "Brak kopii zapasowej na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Serwera
   (or (awaria-serwera ?serwer)
       (błąd-systemowy ?serwer))
   =>
   (printout t "Wystąpił problem z serwerem " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Sieci
   (problem-sieci)
   =>
   (printout t "Wystąpił problem z siecią - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Konfiguracji
   (błąd-konfiguracji ?komponent)
   =>
   (printout t "Wystąpił błąd konfiguracji w " ?komponent " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-MySQL
   (błąd-mysql ?serwer)
   =>
   (printout t "Wystąpił problem z bazą danych MySQL na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Apache
   (błąd-apache ?serwer)
   =>
   (printout t "Wystąpił problem z serwerem Apache na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-Firewall
   (or (awaria-firewall ?serwer) (blad-konfiguracji-firewalla ?serwer))
   =>
   (printout t "Problem z firewallem na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-FTP
   (or (awaria-ftp ?serwer) (blad-serwera-ftp ?serwer))
   =>
   (printout t "Problem z serwerem FTP na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))

(defrule Problem-DNS
   (problem-dns ?serwer)
   =>
   (printout t "Problem z serwerem DNS na serwerze " ?serwer " - proponowane kroki naprawcze: ..." crlf))