package com.chessboard.pieces;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnTest {
    @Test
    void testPawnCreation() {
        // Test if pawn is created with correct symbol and position
        Pawn pawn = new Pawn("A2");
        assertEquals("♟", pawn.getSymbol());
        assertEquals("A2", pawn.getPosition());
    }

    @Test
    void testPawnForwardMove() {
        // Test normal forward movement from starting position
        Pawn pawn = new Pawn("B2");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains("B3"));
    }

    @Test
    void testPawnAtEdge() {
        // Test pawn at the last rank (should have no valid moves)
        Pawn pawn = new Pawn("C8");
        List<String> moves = pawn.getPossibleMoves();

        assertTrue(moves.isEmpty());
    }

    @Test
    void testPawnInMiddle() {
        // Test pawn in middle of board
        Pawn pawn = new Pawn("D4");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains("D5"));
    }

    @Test
    void testInvalidPosition() {
        // Test pawn with invalid starting position
        Pawn pawn = new Pawn("A9"); // Invalid position
        List<String> moves = pawn.getPossibleMoves();

        assertTrue(moves.isEmpty());
    }
}