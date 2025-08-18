# PowerShell run script for Tic Tac Toe game

Write-Host "=== Tic Tac Toe Game Runner ===" -ForegroundColor Green

# Check if bin directory exists
if (!(Test-Path "bin")) {
    Write-Host "Error: bin directory not found. Please run build.ps1 first." -ForegroundColor Red
    exit 1
}

# Check if Main.class exists
if (!(Test-Path "bin/com/nullhawk/tictactoe/Main.class")) {
    Write-Host "Error: Main.class not found. Please run build.ps1 first." -ForegroundColor Red
    exit 1
}

Write-Host "Starting Tic Tac Toe game..." -ForegroundColor Yellow
Write-Host "Press Ctrl+C to exit" -ForegroundColor Cyan
Write-Host ""

# Run the game
try {
    java -cp bin com.nullhawk.tictactoe.Main
} catch {
    Write-Host "Error running the game: $_" -ForegroundColor Red
    exit 1
}
