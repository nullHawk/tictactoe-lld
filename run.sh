#!/bin/bash

# Bash run script for Tic Tac Toe game

echo "=== Tic Tac Toe Game Runner ==="

# Check if bin directory exists
if [ ! -d "bin" ]; then
    echo "Error: bin directory not found. Please run build.sh first."
    exit 1
fi

# Check if Main.class exists
if [ ! -f "bin/com/nullhawk/tictactoe/Main.class" ]; then
    echo "Error: Main.class not found. Please run build.sh first."
    exit 1
fi

echo "Starting Tic Tac Toe game..."
echo "Press Ctrl+C to exit"
echo ""

# Run the game
if ! java -cp bin com.nullhawk.tictactoe.Main; then
    echo "Error running the game"
    exit 1
fi
