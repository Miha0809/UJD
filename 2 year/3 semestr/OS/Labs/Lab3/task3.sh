#!/bin/bash

if [ $# -eq 1 ]
then
    echo "Only 1 argument"
else
    echo "More  than 1 argument"
fi

if [ -e $1 ] && [ -d $1 ] && [ -r $1 ]
then
    count_files=$(cd $1; find . -maxdepth 1 -type f | wc -l)
    echo "count files: " $count_files
    echo "count dirs: " $(find "$1/*" -maxdepth 1 -type d | wc -l)
fi