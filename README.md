# Tic Tac Toe Game

A well-structured Tic Tac Toe game implementation in Java following proper Low Level Design (LLD) practices.

## Project Structure

```
src/com/nullhawk/tictactoe/
├── model/           # Core game models
│   ├── Board.java   # Game board representation
│   ├── Game.java    # Main game logic
│   ├── Player.java  # Player interface
│   ├── AbstractPlayer.java  # Abstract player base class
│   └── HumanPlayer.java     # Human player implementation
├── view/            # User interface layer
│   ├── GameView.java        # View interface
│   └── CLIGameView.java     # Command-line view implementation
├── service/         # Business logic and utilities
│   └── GameFactory.java     # Factory for creating game components
├── controller/      # Controller layer (for future extensions)
└── Main.java        # Application entry point
```

## Design Patterns Used

### 1. **Interface Segregation Principle (ISP)**
- `Player` interface defines the contract for players
- `GameView` interface defines the contract for different view implementations

### 2. **Abstract Class Pattern**
- `AbstractPlayer` provides common functionality for different player types
- Reduces code duplication and enforces common behavior

### 3. **Factory Pattern**
- `GameFactory` handles object creation
- Centralizes game component instantiation
- Makes it easy to create different game configurations

### 4. **Strategy Pattern**
- Different view implementations can be swapped (CLI, GUI, etc.)
- Different player types can be implemented (Human, AI, etc.)

### 5. **Single Responsibility Principle (SRP)**
- Each class has a single, well-defined responsibility
- `Board` handles board state and validation
- `Game` manages game flow and rules
- `Player` handles player-specific logic

## Features

- **Clean Architecture**: Separation of concerns between model, view, and service layers
- **Extensible Design**: Easy to add new player types (AI, Network) or view types (GUI, Web)
- **Input Validation**: Robust input handling with user-friendly error messages
- **Game State Management**: Proper game state tracking and validation
- **Replayability**: Option to play multiple games

## How to Run

### Prerequisites
- Java 8 or higher
- PowerShell (Windows) or Terminal (Linux/Mac)

### Compilation
```powershell
# Navigate to the project directory
cd tictactoe

# Compile all Java files
javac -d bin src/com/nullhawk/tictactoe/**/*.java src/com/nullhawk/tictactoe/Main.java
```

### Execution
```powershell
# Run the game
java -cp bin com.nullhawk.tictactoe.Main
```

## Game Rules

1. The game is played on a 3x3 grid
2. Players take turns placing their symbol (X or O) on empty positions
3. Positions are numbered 1-9 (left to right, top to bottom)
4. First player to get 3 symbols in a row (horizontally, vertically, or diagonally) wins
5. If all positions are filled without a winner, the game is a draw

## Board Layout

```
 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9
```

## Future Enhancements

- **AI Player**: Implement computer opponent with different difficulty levels
- **Network Multiplayer**: Add support for playing over network
- **GUI Interface**: Create a graphical user interface
- **Game Statistics**: Track wins, losses, and draws
- **Custom Board Sizes**: Support for larger grids (4x4, 5x5, etc.)

## Code Quality

- **Comprehensive Documentation**: JavaDoc comments for all public methods
- **Error Handling**: Proper exception handling and user input validation
- **Clean Code**: Meaningful variable names and consistent formatting
- **Testability**: Classes are designed to be easily testable
- **Maintainability**: Clear separation of concerns and modular design

## Contributing

Feel free to contribute to this project by:
- Adding new features
- Improving the existing code
- Adding unit tests
- Enhancing documentation
- Reporting bugs or suggesting improvements
