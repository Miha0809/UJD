#!/bin/bash

if [ -d $1 ];then
	files=$(ls $1)
	cd $1
	size=0
	for plik in $files; do
		if [ -e $plik ];then	
			size_file=$(wc --bytes $plik | cut -d' ' -f1)
			size=$((size+size_file))
		fi
done
fi

echo "Size all files in katalog '$1' = $size"
