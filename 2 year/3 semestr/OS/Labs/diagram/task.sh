#!/bin/bash

while true; do
    clear

    echo "Menu:"
    echo "1. Wyświetl aktualną datę"
    echo "2. Wyświetl nazwę i czas pracy systemu"
    echo "3. Wyświetl liczbę zalogowanych użytkowników"
    echo "q. Zakończ program"

    read -p "Wybierz opcję: " choice

    case "$choice" in
        1)
            current_date=$(date +"%Y-%m-%d %H:%M:%S")
            echo "Aktualna data: $current_date"
            ;;
        2)
            system_info=$(uptime)
            echo "Nazwa i czas pracy systemu: $system_info"
            ;;
        3)
            logged_users=$(who | wc -l)
            echo "Liczba zalogowanych użytkowników: $logged_users"
            ;;
        q)
            echo "Zakończono program."
            exit 0
            ;;
        *)
            echo "Nieprawidłowy wybór. Spróbuj ponownie."
            ;;
    esac

    read -p "Naciśnij dowolny klawisz, aby kontynuować..."
done
