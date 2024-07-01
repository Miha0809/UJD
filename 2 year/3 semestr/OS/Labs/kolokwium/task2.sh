#/bin/bash

suma=0
count=0

for ((i = 0; i <= (($# + 1)); i++))
do
    suma=$((suma+$1))
    count=$((count+1))
    shift
done

echo $suma
echo $count
