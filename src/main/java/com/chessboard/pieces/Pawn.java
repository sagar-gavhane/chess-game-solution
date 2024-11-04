package com.chessboard.pieces;

import com.chessboard.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(String position) {
        super("♟", position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char col = position.charAt(0);

        if (ChessBoard.isValidPosition(row + 1, col)) {
            moves.add("" + col + (row + 1));
        }

        return moves;
    }
}
