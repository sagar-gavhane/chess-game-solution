package com.chessboard.pieces;

import com.chessboard.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(String position) {
        super("♛", position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();

        int row = position.charAt(1) - '0';
        char col = position.charAt(0);

        if (!ChessBoard.isValidPosition(row, col)) {
            return moves;
        }

        addStraightMoves(moves, row, col);
        addDiagonalMoves(moves, row, col);

        return moves;
    }

    private void addStraightMoves(List<String> moves, int row, char col) {
        for (int i = 1; i <= 8; i++) {
            if (i != row && ChessBoard.isValidPosition(i, col)) {
                moves.add("" + col + i);
            }

            if (col != (char) ('A' + i - 1) && ChessBoard.isValidPosition(row, (char) ('A' + i - 1))) {
                moves.add("" + (char) ('A' + i - 1) + row);
            }
        }
    }

    private void addDiagonalMoves(List<String> moves, int row, char col) {
        for (int i = 1; i < 8; i++) {
            if (ChessBoard.isValidPosition(row + i, (char) (col + i))) moves.add("" + (char) (col + i) + (row + i));
            if (ChessBoard.isValidPosition(row - i, (char) (col + i))) moves.add("" + (char) (col + i) + (row - i));
            if (ChessBoard.isValidPosition(row + i, (char) (col - i))) moves.add("" + (char) (col - i) + (row + i));
            if (ChessBoard.isValidPosition(row - i, (char) (col - i))) moves.add("" + (char) (col - i) + (row - i));
        }
    }
}
