#!/bin/bash

read file

if [[ -e $file ]]
then
    if [[ -x $file ]]
    then
        ./"$file"
        echo $?
    fi
fi