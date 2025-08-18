#!/bin/bash

# Bash build script for Tic Tac Toe game

echo "=== Tic Tac Toe Game Build Script ==="

# Create bin directory if it doesn't exist
if [ ! -d "bin" ]; then
    mkdir -p bin
    echo "Created bin directory"
fi

# Find all Java files
java_files=$(find src -name "*.java" -type f)

if [ -z "$java_files" ]; then
    echo "No Java files found!"
    exit 1
fi

echo "Found Java files:"
echo "$java_files" | while read -r file; do
    echo "  $file"
done

# Compile all Java files
echo ""
echo "Compiling Java files..."
if javac -d bin $java_files; then
    echo "Compilation successful!"
else
    echo "Compilation failed!"
    exit 1
fi

echo "Build completed successfully!"
echo "To run the game, use: java -cp bin com.nullhawk.tictactoe.Main"
