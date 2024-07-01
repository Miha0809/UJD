#!/bin/bash

for ((i = 0; i <= (($# + 1)); i++))
do
    echo $1
    shift
done
