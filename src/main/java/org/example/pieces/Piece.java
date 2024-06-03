package org.example.pieces;

import org.example.board.Position;

import java.util.List;

public abstract class Piece {
    private boolean isWhite;
    private Position position;

    public Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public Position getPosition() {
        return position;
    }

    public abstract List<Position> getPossibleMoves();
}
