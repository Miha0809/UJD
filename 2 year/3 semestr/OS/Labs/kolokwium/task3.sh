#/bin/bash

while true; do
    echo "Menu:"
    echo "1. date"
    echo "2. time"
    echo "3. count users"
    echo "q. Quit"

    read -p "Enter task: " number

    case "$number" in
        1)
            echo
            echo $(date)
            echo
            ;;
        2)
            echo
            echo $(uptime)
            echo
            ;;
        3)
            echo
            echo $(who -q)
            echo
            ;;
        q)
            echo "Exiting the program."
            exit 0
            ;;
        *)
            echo "Invalid choice. Please try again."
            ;;
    esac
done

