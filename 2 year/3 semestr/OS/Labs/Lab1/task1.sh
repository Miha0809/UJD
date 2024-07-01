#!/bin/bash

read file

if [[ ${#file} -eq 0 ]]
then
    echo "zbiór nie istnieje"
elif [[ -d $file ]]
then
    echo "zbiór istnieje i jest katalogiem"
elif [[ -f $file ]]
then
    echo "zbiór istnieje i jest plikiem zwykłym"
fi