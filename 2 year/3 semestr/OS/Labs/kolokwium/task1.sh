#!/bin/bash

if [[ -e ~/$1 ]]
then
    echo "this folder is created"
fi

# nie pamiętam jak szukać wszystkie pliki rozpoczynające się od litery 
mv $2 $1