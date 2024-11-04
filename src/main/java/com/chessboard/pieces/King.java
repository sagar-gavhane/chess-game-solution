package com.chessboard.pieces;

import com.chessboard.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(String position) {
        super("♚", position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char col = position.charAt(0);

        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            char newCol = (char) (col + colOffsets[i]);

            if (ChessBoard.isValidPosition(newRow, newCol)) {
                moves.add("" + newCol + newRow);
            }
        }

        return moves;
    }
}
