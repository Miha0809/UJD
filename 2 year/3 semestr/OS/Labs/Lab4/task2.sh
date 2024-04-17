#!/bin/bash
output_file="output.txt"
echo $(grep -Eo '[0-9]' $1 | sort -rn > $output_file)
echo $(grep -Eo '[0-9]' $1)
echo $(grep -Eo '[0-9]' $1 | sort -n)
echo $(grep -Eo '[0-9]' $1 | sort -rn)