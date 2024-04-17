#!/bin/bash

backup_folder="BACKUP"

if [ -e "$backup_folder" ]; then
    echo "Error: $backup_folder already exists. Please remove or rename it."
    exit 1
fi

mkdir "$backup_folder"

if [ $? -ne 0 ]; then
    echo "Error: Failed to create $backup_folder."
    exit 1
fi

for file in *~; do
    if [ -f "$file" ]; then
        cp "$file" "$backup_folder/"
        echo "Copied $file to $backup_folder/"
    fi
done

echo "Backup completed successfully."
