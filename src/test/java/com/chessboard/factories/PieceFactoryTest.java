package com.chessboard.factories;

import com.chessboard.pieces.King;
import com.chessboard.pieces.Pawn;
import com.chessboard.pieces.Piece;
import com.chessboard.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {
    @Test
    void testCreatePawn() {
        Piece piece = PieceFactory.createPiece("pawn", "E2");

        assertNotNull(piece);
        assertTrue(piece instanceof Pawn);
        assertEquals("E2", piece.getPosition());
        assertEquals("♟", piece.getSymbol());
    }

    @Test
    void testCreateKing() {
        Piece piece = PieceFactory.createPiece("king", "E1");

        assertNotNull(piece);
        assertTrue(piece instanceof King);
        assertEquals("E1", piece.getPosition());
        assertEquals("♚", piece.getSymbol());
    }

    @Test
    void testCreateQueen() {
        Piece piece = PieceFactory.createPiece("queen", "D1");

        assertNotNull(piece);
        assertTrue(piece instanceof Queen);
        assertEquals("D1", piece.getPosition());
        assertEquals("♛", piece.getSymbol());
    }

    @Test
    void testCaseInsensitivity() {
        // Test different case variations
        Piece pawn1 = PieceFactory.createPiece("PAWN", "E2");
        Piece pawn2 = PieceFactory.createPiece("pawn", "E3");
        Piece pawn3 = PieceFactory.createPiece("Pawn", "E4");

        assertTrue(pawn1 instanceof Pawn);
        assertTrue(pawn2 instanceof Pawn);
        assertTrue(pawn3 instanceof Pawn);
    }

    @Test
    void testInvalidPieceType() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PieceFactory.createPiece("bishop", "C1")
        );

        assertEquals("Unknown piece type: bishop", exception.getMessage());
    }

    @Test
    void testNullPieceType() {
        assertThrows(
                NullPointerException.class,
                () -> PieceFactory.createPiece(null, "E1")
        );
    }

    @Test
    void testCreateMultiplePieces() {
        // Test creating multiple pieces of different types
        Piece[] pieces = {
                PieceFactory.createPiece("king", "E1"),
                PieceFactory.createPiece("queen", "D1"),
                PieceFactory.createPiece("pawn", "E2")
        };

        assertTrue(pieces[0] instanceof King);
        assertTrue(pieces[1] instanceof Queen);
        assertTrue(pieces[2] instanceof Pawn);
    }

    @Test
    void testPositionHandling() {
        // Test various position formats
        Piece piece1 = PieceFactory.createPiece("pawn", "A1");
        Piece piece2 = PieceFactory.createPiece("pawn", "H8");
        Piece piece3 = PieceFactory.createPiece("pawn", "D4");

        assertEquals("A1", piece1.getPosition());
        assertEquals("H8", piece2.getPosition());
        assertEquals("D4", piece3.getPosition());
    }

    @Test
    void testEmptyPieceType() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PieceFactory.createPiece("", "E1")
        );

        assertEquals("Unknown piece type: ", exception.getMessage());
    }

    @Test
    void testWhitespaceHandling() {
        // Test piece type with leading/trailing whitespace
        Piece piece1 = PieceFactory.createPiece(" pawn ", "E2");
        Piece piece2 = PieceFactory.createPiece("\tking\n", "E1");

        assertTrue(piece1 instanceof Pawn);
        assertTrue(piece2 instanceof King);
        assertEquals("E2", piece1.getPosition());
        assertEquals("E1", piece2.getPosition());
    }

}