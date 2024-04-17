#!/bin/bash

echo "Number of non-hidden directories in the current directory: $(find . -maxdepth 1 -type d ! -name ".*" | wc -l)"
