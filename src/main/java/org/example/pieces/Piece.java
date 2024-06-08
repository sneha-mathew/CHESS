package org.example.pieces;

import org.example.board.IPosition;
import org.example.board.Position;

import java.util.List;

public abstract class Piece {
    private boolean isWhite;
    private IPosition position;

    public Piece(boolean isWhite, IPosition position) {
        this.isWhite = isWhite;
        this.position = position;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public IPosition getPosition() {
        return position;
    }

    public abstract List<IPosition> getPossibleMoves();
}
