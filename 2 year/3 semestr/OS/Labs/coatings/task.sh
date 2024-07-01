#!/bin/bash

awk -F: '{print $7}' /etc/passwd | sort | uniq -c