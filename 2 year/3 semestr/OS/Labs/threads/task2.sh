#!/bin/bash

is_prime() {
    num=$1
    if [ $num -lt 2 ]; then
        return 1
    fi

    for ((i = 2; i * i <= num; i++)); do
        if [ $((num % i)) -eq 0 ]; then
            return 1
        fi
    done

    return 0
}

check_primes() {
    for num in "$@"; do
        if is_prime "$num"; then
            echo "$num is a prime number"
        else
            echo "$num is not a prime number"
        fi
    done
}

read -p "Enter numbers separated by space: " numbers

check_primes $numbers &
wait
