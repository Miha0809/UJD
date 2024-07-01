#!/bin/bash

if [ "$#" -eq 3 ]
then
    echo "Count arguments == 3"
else
    echo "Count arguments != 3"
fi

if [ -f $1 ] && [-r $1 ] && [ -f $2 ] && [ -r $2 ]
then
    echo "File exists"
else
    echo "file does not exist"
fi

if [[ -e $3 ]]
then
    echo "File exists"
else
    touch $3
    cat $1 $2 > $3
fi