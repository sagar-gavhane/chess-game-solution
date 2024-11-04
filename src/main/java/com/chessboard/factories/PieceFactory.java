package com.chessboard.factories;

import com.chessboard.pieces.King;
import com.chessboard.pieces.Pawn;
import com.chessboard.pieces.Piece;
import com.chessboard.pieces.Queen;

public class PieceFactory {
    private PieceFactory() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Piece createPiece(String pieceType, String position) {
        switch (pieceType.toLowerCase().trim()) {
            case "pawn":
                return new Pawn(position);
            case "king":
                return new King(position);
            case "queen":
                return new Queen(position);
            default:
                throw new IllegalArgumentException("Unknown piece type: " + pieceType);
        }
    }
}
