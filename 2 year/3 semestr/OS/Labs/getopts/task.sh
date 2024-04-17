#!/bin/bash

while getopts "dnu" flag; do
    case "$flag" in
        d)
            current_date=$(date +"%Y-%m-%d %H:%M:%S")
            echo "Aktualna data: $current_date"
            ;;
        n)
            system_info=$(uptime)
            echo "Nazwa i czas pracy systemu: $system_info"
            ;;
        u)
            logged_users=$(who | wc -l)
            echo "Liczba zalogowanych użytkowników: $logged_users"
            ;;
        \?)
            echo "Nieprawidłowa opcja: -$OPTARG. Użyj -d, -n lub -u."
            ;;
    esac
done
