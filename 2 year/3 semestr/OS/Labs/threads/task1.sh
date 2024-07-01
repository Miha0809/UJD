#!/bin/bash

print_numbers() {
    for i in {1..9}; do
        echo $i
        sleep 1
    done
}

for _ in {1..9}; do
    print_numbers &
done

wait