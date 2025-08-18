# PowerShell build script for Tic Tac Toe game

Write-Host "=== Tic Tac Toe Game Build Script ===" -ForegroundColor Green

# Create bin directory if it doesn't exist
if (!(Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
    Write-Host "Created bin directory" -ForegroundColor Yellow
}

# Find all Java files
$javaFiles = Get-ChildItem -Path "src" -Filter "*.java" -Recurse | Select-Object -ExpandProperty FullName

if ($javaFiles.Count -eq 0) {
    Write-Host "No Java files found!" -ForegroundColor Red
    exit 1
}

Write-Host "Found $($javaFiles.Count) Java files:" -ForegroundColor Yellow
$javaFiles | ForEach-Object { Write-Host "  $_" -ForegroundColor Gray }

# Compile all Java files
Write-Host "`nCompiling Java files..." -ForegroundColor Yellow
try {
    javac -d bin $javaFiles
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Compilation successful!" -ForegroundColor Green
    } else {
        Write-Host "Compilation failed!" -ForegroundColor Red
        exit 1
    }
} catch {
    Write-Host "Error during compilation: $_" -ForegroundColor Red
    exit 1
}

Write-Host "Build completed successfully!" -ForegroundColor Green
Write-Host "To run the game, use: java -cp bin com.nullhawk.tictactoe.Main" -ForegroundColor Cyan
