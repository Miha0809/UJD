#!/bin/bash

echo $(date)
echo $(uname -a && uptime)
echo $(who -q)

while true; do
    echo "Menu:"
    echo "1. Calculate the total size of files in a directory"
    echo "2. Another action (to be customized)"
    echo "q. Quit"

    read -p "Choose an action: " choice

    case "$choice" in
        1)
            read -p "Enter the path to the directory: " directory_path

            if [ ! -d "$directory_path" ]; then
                echo "Error: '$directory_path' is not a directory."
                continue
            fi

            total_size=$(find "$directory_path" -type f -exec wc -c {} + | awk '{sum += $1} END {print sum}')

            echo "Total size of files in the directory '$directory_path': $total_size bytes"
            ;;
        2)
            echo "You selected another action. You can customize the code for this action."
            ;;
        q)
            echo "Exiting the program."
            exit 0
            ;;
        *)
            echo "Invalid choice. Please try again."
            ;;
    esac

    read -n 1 -s -r -p "Press any key to return to the menu..."
    echo
done
