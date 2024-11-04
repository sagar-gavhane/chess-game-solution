package com.chessboard.pieces;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {
    @Test
    void testQueenCreation() {
        Queen queen = new Queen("D4");
        assertEquals("♛", queen.getSymbol());
        assertEquals("D4", queen.getPosition());
    }

    @Test
    void testCenterPositionMoves() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        // Should have 27 possible moves from center position
        // 7 horizontal + 7 vertical + 13 diagonal moves
        assertEquals(27, moves.size());

        // Check some specific moves in all directions
        List<String> expectedMoves = Arrays.asList(
                "D1", "D2", "D3", "D5", "D6", "D7", "D8", // Vertical
                "A4", "B4", "C4", "E4", "F4", "G4", "H4", // Horizontal
                "A1", "B2", "C3", "E5", "F6", "G7", "H8", // Diagonal
                "A7", "B6", "C5", "E3", "F2", "G1"        // Other diagonal
        );
        assertTrue(new HashSet<>(moves).containsAll(expectedMoves));
    }

    @Test
    void testCornerPosition() {
        Queen queen = new Queen("A1");
        List<String> moves = queen.getPossibleMoves();

        // Should have 21 possible moves from corner
        // 7 horizontal + 7 vertical + 7 diagonal
        assertEquals(21, moves.size());

        // Check specific moves
        List<String> expectedMoves = Arrays.asList(
                "A2", "A3", "A4", "A5", "A6", "A7", "A8", // Vertical
                "B1", "C1", "D1", "E1", "F1", "G1", "H1", // Horizontal
                "B2", "C3", "D4", "E5", "F6", "G7", "H8"  // Diagonal
        );
        assertTrue(new HashSet<>(moves).containsAll(expectedMoves));
    }

    @Test
    void testEdgePosition() {
        Queen queen = new Queen("A4");
        List<String> moves = queen.getPossibleMoves();

        // Should have 21 possible moves from edge
        assertEquals(21, moves.size());

        // Verify horizontal movement
        assertTrue(moves.containsAll(Arrays.asList("B4", "C4", "D4", "E4", "F4", "G4", "H4")));

        // Verify vertical movement
        assertTrue(moves.containsAll(Arrays.asList("A1", "A2", "A3", "A5", "A6", "A7", "A8")));
    }

    @Test
    void testDiagonalMoves() {
        Queen queen = new Queen("E4");
        List<String> moves = queen.getPossibleMoves();

        // Check diagonal moves
        List<String> diagonalMoves = Arrays.asList(
                "B1", "C2", "D3", "F5", "G6", "H7", // Main diagonal
                "B7", "C6", "D5", "F3", "G2", "H1"  // Other diagonal
        );
        assertTrue(new HashSet<>(moves).containsAll(diagonalMoves));
    }

    @Test
    void testInvalidStartingPosition() {
        Queen queen = new Queen("I9");
        List<String> moves = queen.getPossibleMoves();
        assertTrue(moves.isEmpty());
    }

    @Test
    void testTopEdgePosition() {
        Queen queen = new Queen("D8");
        List<String> moves = queen.getPossibleMoves();

        // Verify no moves go beyond the top edge
        for (String move : moves) {
            assertTrue(Character.getNumericValue(move.charAt(1)) <= 8);
        }
    }

    @Test
    void testBottomEdgePosition() {
        Queen queen = new Queen("E1");
        List<String> moves = queen.getPossibleMoves();

        // Verify moves exist in all valid directions
        assertTrue(moves.contains("E2")); // Up
        assertTrue(moves.contains("F1")); // Right
        assertTrue(moves.contains("D1")); // Left
        assertTrue(moves.contains("F2")); // Diagonal up-right
        assertTrue(moves.contains("D2")); // Diagonal up-left
    }

    @Test
    void testHorizontalMoves() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        // Test all horizontal moves
        List<String> horizontalMoves = Arrays.asList("A4", "B4", "C4", "E4", "F4", "G4", "H4");
        assertTrue(moves.containsAll(horizontalMoves));
        assertEquals(7, horizontalMoves.size());
    }

    @Test
    void testMoveCount() {
        // Test move counts from different positions
        assertEquals(21, new Queen("A1").getPossibleMoves().size()); // Corner
        assertEquals(27, new Queen("D4").getPossibleMoves().size()); // Center
        assertEquals(21, new Queen("A4").getPossibleMoves().size()); // Edge
        assertEquals(21, new Queen("H8").getPossibleMoves().size()); // Opposite corner
    }
}