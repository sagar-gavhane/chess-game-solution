# Chess Game

This chess game project was developed as part of a hiring assignment to meet the specified requirements provided by the
company. The game implements a functional chessboard, core chess pieces (King, Queen, Pawn, etc.), and movement logic
adhering to standard chess rules. The structure is built using Java and Maven, demonstrating clean code practices,
object-oriented principles, and an extendable design. The project aims to showcase problem-solving skills, adherence to
requirements, and proficiency in Java development.

## Project Structure

This project is organized as a standard Maven project. Below is a brief overview of the directory structure:

```text
├── pom.xml
src
├── main
│   └── java
│       └── com
│           └── chessboard
│               ├── ChessBoard.java
│               ├── ChessGame.java
│               ├── factories
│               │   └── PieceFactory.java
│               └── pieces
│                   ├── King.java
│                   ├── Pawn.java
│                   ├── Piece.java
│                   └── Queen.java
└── test
    └── java
        └── com
            └── chessboard
                ├── ChessBoardTest.java
                ├── factories
                │   └── PieceFactoryTest.java
                └── pieces
                    ├── KingTest.java
                    ├── PawnTest.java
                    └── QueenTest.java
```

- src/main/java: Contains the main source code for the chess game.
- src/test/java: Contains test cases for unit testing.
- pom.xml: Maven configuration file.

## Classes Overview

### ChessBoard

Manages the game board, initializes pieces, and enforces game rules.
Handles the positioning of pieces and updates the board after each move.

### Piece

Abstract base class for all chess pieces.
Contains basic functionality common to all pieces, such as tracking position and color.

### King

Represents the King piece in chess.
Contains logic for the specific movement and capturing rules of the King.

### Pawn

Represents the Pawn piece in chess.
Includes movement logic for pawn-specific rules, such as moving one square forward or capturing diagonally.

### Queen

Represents the Queen piece in chess.
Implements movement rules allowing it to move vertically, horizontally, or diagonally.

### PieceFactory

Factory class to create instances of chess pieces based on input type (e.g., King, Queen).
Simplifies the creation and instantiation of pieces during board setup.

## Installation

### Prerequisites

Java Development Kit (JDK) 17 or above.
Maven 3.6 or above.

### Steps

Clone the repository:

```bash
git clone https://github.com/sagar-gavhane/chess-game-solution.git
cd chess-game
```

### Running Tests in IntelliJ

Instead of running tests through the command line, you can also run them directly in IntelliJ:

Right-click on the test class or method in the editor.
Select Run 'AppTest' or Run 'All Tests'.

## Acknowledgments

Thank you for taking the time to explore this chess game project. I appreciate your interest and feedback. If you have
any questions or suggestions, please feel free to reach out. Happy coding!