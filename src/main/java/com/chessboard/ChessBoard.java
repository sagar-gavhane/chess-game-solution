package com.chessboard;

import com.chessboard.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private final String[][] board = new String[8][8];
    private final Map<String, Piece> pieces = new HashMap<>(); // <position, piece>

    public ChessBoard() {
        initializeBoard();
    }

    public static boolean isValidPosition(int row, char col) {
        return row >= 1 && row <= 8 && col >= 'A' && col <= 'H';
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = " . ";
            }
        }
    }

    public void placePiece(Piece piece) {
        String position = piece.getPosition();
        int row = position.charAt(1) - '0';
        char col = position.charAt(0);

        if (isValidPosition(row, col)) {
            pieces.put(position, piece);
            board[row - 1][col - 'A'] = " " + piece.getSymbol() + " ";
            System.out.println(piece.getClass().getSimpleName() + " placed at " + position);
        } else {
            System.out.println("Invalid position: " + position);
        }
    }

    public Map<String, Piece> getPieces() {
        return pieces;
    }

    public void print() {
        System.out.println("Current board status:");

        for (int row = 7; row >= 0; row--) { // Print from row 8 to 1 for chess notation
            for (int col = 0; col < 8; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(" " + (row + 1)); // Row labels
        }

        System.out.println(" A  B  C  D  E  F  G  H"); // Column labels
    }
}
