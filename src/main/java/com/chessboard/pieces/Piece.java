package com.chessboard.pieces;

import java.util.List;

public abstract class Piece {
    protected String position;
    protected String symbol;

    protected Piece(String symbol, String position) {
        this.symbol = symbol;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract List<String> getPossibleMoves();
}
