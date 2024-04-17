#!/bin/bash

if file "$1" | grep -q "compressed"; then
    echo "File $1 is compressed."
else
    echo "File $1 is not compressed."
    mkdir -p ~/trash/
    mv $1 ~/trash/
    find ~/trash/ -type f -mtime +1 -exec rm {} \;
fi
