package org.example.pieces;

import org.example.board.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, Position position) {
        super(isWhite,position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        Optional<Position> move = isWhite() ? getPosition().moveForward() : getPosition().moveBackward();
        move.ifPresent(possibleMoves::add);
        return possibleMoves;
    }
}
