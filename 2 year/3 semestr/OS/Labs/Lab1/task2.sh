#!/bin/bash

read file

if [[ ${#file} -eq 0 ]]
then
    echo "zbiór nie istnieje"
fi

if [[ -d $file ]]
then
    echo -e "zbiór istnieje i jest katalogiem"
    echo $(cd $file; ls)
fi

if [[ -f $file ]]
then
    echo -e "zbiór istnieje i jest plikiem zwykłym"
    echo -e $(cat < $file)
fi

if [[ -r $file ]]
then
    echo "Yes"
else
    echo "No"
fi