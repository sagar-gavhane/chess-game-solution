package com.chessboard.pieces;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {
    @Test
    void testKingCreation() {
        King king = new King("E1");
        assertEquals("♚", king.getSymbol());
        assertEquals("E1", king.getPosition());
    }

    @Test
    void testInvalidPositionCreation() {
        King king = new King("Z9");
        assertTrue(king.getPossibleMoves().isEmpty());
    }

    @Test
    void testCenterMoves() {
        King king = new King("D4");
        List<String> expectedMoves = Arrays.asList(
                "C3", "D3", "E3",
                "C4", "E4",
                "C5", "D5", "E5"
        );
        List<String> actualMoves = king.getPossibleMoves();

        assertEquals(8, actualMoves.size());
        assertTrue(new HashSet<>(actualMoves).containsAll(expectedMoves));
    }

    @Test
    void testMovePattern() {
        King king = new King("E4");
        List<String> moves = king.getPossibleMoves();

        // Verify diagonal moves
        assertTrue(moves.contains("D3")); // Bottom-left
        assertTrue(moves.contains("F3")); // Bottom-right
        assertTrue(moves.contains("D5")); // Top-left
        assertTrue(moves.contains("F5")); // Top-right

        // Verify orthogonal moves
        assertTrue(moves.contains("E3")); // Bottom
        assertTrue(moves.contains("E5")); // Top
        assertTrue(moves.contains("D4")); // Left
        assertTrue(moves.contains("F4")); // Right
    }

    @Test
    void testBottomEdge() {
        King king = new King("D1");
        List<String> moves = king.getPossibleMoves();
        assertEquals(5, moves.size());
        assertTrue(moves.containsAll(Arrays.asList("C1", "E1", "C2", "D2", "E2")));
    }

    @Test
    void testTopEdge() {
        King king = new King("D8");
        List<String> moves = king.getPossibleMoves();
        assertEquals(5, moves.size());
        assertTrue(moves.containsAll(Arrays.asList("C8", "E8", "C7", "D7", "E7")));
    }

    @Test
    void testLeftEdge() {
        King king = new King("A4");
        List<String> moves = king.getPossibleMoves();
        assertEquals(5, moves.size());
        assertTrue(moves.containsAll(Arrays.asList("A3", "A5", "B3", "B4", "B5")));
    }

    @Test
    void testTopLeftCorner() {
        King king = new King("A8");
        List<String> moves = king.getPossibleMoves();
        assertEquals(3, moves.size());
        assertTrue(moves.containsAll(Arrays.asList("A7", "B7", "B8")));
    }

    @Test
    void testBottomRightCorner() {
        King king = new King("H1");
        List<String> moves = king.getPossibleMoves();
        assertEquals(3, moves.size());
        assertTrue(moves.containsAll(Arrays.asList("G1", "G2", "H2")));
    }
}