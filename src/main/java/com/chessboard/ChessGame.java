package com.chessboard;

import com.chessboard.factories.PieceFactory;
import com.chessboard.pieces.Piece;

import java.util.List;

public class ChessGame {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        String input = "Pawn,E4";
        String[] split = input.split(",");

        String pieceType = split[0];
        String position = split[1];

        Piece piece = PieceFactory.createPiece(pieceType, position);
        chessBoard.placePiece(piece);

        chessBoard.print();

        System.out.println(piece.getClass().getSimpleName() + "'s possible moves:");
        List<String> possibleMoves = piece.getPossibleMoves();

        System.out.println(possibleMoves);
    }
}
