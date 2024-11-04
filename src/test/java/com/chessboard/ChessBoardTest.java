package com.chessboard;

import com.chessboard.pieces.King;
import com.chessboard.pieces.Pawn;
import com.chessboard.pieces.Piece;
import com.chessboard.pieces.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {
    private ChessBoard board;

    @BeforeEach
    void setUp() {
        board = new ChessBoard();
    }

    @Test
    void testBoardInitialization() {
        // Verify board is empty after initialization
        Map<String, Piece> pieces = board.getPieces();
        assertTrue(pieces.isEmpty());
    }

    @Test
    void testValidPiecePlacement() {
        King king = new King("E1");
        board.placePiece(king);

        Map<String, Piece> pieces = board.getPieces();
        assertEquals(1, pieces.size());
        assertEquals(king, pieces.get("E1"));
    }

    @Test
    void testMultiplePiecePlacement() {
        King king = new King("E1");
        Queen queen = new Queen("D1");
        Pawn pawn = new Pawn("E2");

        board.placePiece(king);
        board.placePiece(queen);
        board.placePiece(pawn);

        Map<String, Piece> pieces = board.getPieces();
        assertEquals(3, pieces.size());
        assertTrue(pieces.containsKey("E1"));
        assertTrue(pieces.containsKey("D1"));
        assertTrue(pieces.containsKey("E2"));
    }

    @Test
    void testInvalidPositionPlacement() {
        King king = new King("I9"); // Invalid position
        board.placePiece(king);

        Map<String, Piece> pieces = board.getPieces();
        assertTrue(pieces.isEmpty());
    }

    @Test
    void testPiecePlacementOverwrite() {
        // Place two pieces at the same position
        King king1 = new King("E1");
        King king2 = new King("E1");

        board.placePiece(king1);
        board.placePiece(king2);

        Map<String, Piece> pieces = board.getPieces();
        assertEquals(1, pieces.size());
        assertEquals(king2, pieces.get("E1")); // Should contain the last placed piece
    }

    @Test
    void testPositionValidation() {
        // Test various position validations
        assertTrue(ChessBoard.isValidPosition(1, 'A'));  // Bottom-left corner
        assertTrue(ChessBoard.isValidPosition(8, 'H'));  // Top-right corner
        assertTrue(ChessBoard.isValidPosition(4, 'D'));  // Center position

        assertFalse(ChessBoard.isValidPosition(0, 'A')); // Invalid row
        assertFalse(ChessBoard.isValidPosition(9, 'A')); // Invalid row
        assertFalse(ChessBoard.isValidPosition(1, '@')); // Invalid column
        assertFalse(ChessBoard.isValidPosition(1, 'I')); // Invalid column
    }

    @Test
    void testBoardEdgePiecePlacement() {
        // Test placing pieces on board edges
        Piece[] pieces = {
                new King("A1"),   // Bottom-left corner
                new Queen("H1"),  // Bottom-right corner
                new Pawn("A8"),   // Top-left corner
                new King("H8")    // Top-right corner
        };

        for (Piece piece : pieces) {
            board.placePiece(piece);
        }

        Map<String, Piece> placedPieces = board.getPieces();
        assertEquals(4, placedPieces.size());
        assertTrue(placedPieces.containsKey("A1"));
        assertTrue(placedPieces.containsKey("H1"));
        assertTrue(placedPieces.containsKey("A8"));
        assertTrue(placedPieces.containsKey("H8"));
    }

    @Test
    void testEmptyPositionRetrieval() {
        King king = new King("E1");
        board.placePiece(king);

        Map<String, Piece> pieces = board.getPieces();
        assertNull(pieces.get("E2")); // Empty position
        assertNotNull(pieces.get("E1")); // Occupied position
    }

    @Test
    void testPieceSymbolConsistency() {
        King king = new King("E1");
        Queen queen = new Queen("D1");

        board.placePiece(king);
        board.placePiece(queen);

        Map<String, Piece> pieces = board.getPieces();
        assertEquals("♚", pieces.get("E1").getSymbol());
        assertEquals("♛", pieces.get("D1").getSymbol());
    }

    @Test
    void testCompleteInitialSetup() {
        // Test placing a complete set of pieces
        Piece[] pieces = {
                new King("E1"),
                new Queen("D1"),
                new Pawn("E2"),
                new Pawn("D2"),
                new King("E8"),
                new Queen("D8"),
                new Pawn("E7"),
                new Pawn("D7")
        };

        for (Piece piece : pieces) {
            board.placePiece(piece);
        }

        Map<String, Piece> placedPieces = board.getPieces();
        assertEquals(8, placedPieces.size());
        // Verify each piece is in its correct position
        for (Piece piece : pieces) {
            assertTrue(placedPieces.containsKey(piece.getPosition()));
            assertEquals(piece.getSymbol(), placedPieces.get(piece.getPosition()).getSymbol());
        }
    }
}