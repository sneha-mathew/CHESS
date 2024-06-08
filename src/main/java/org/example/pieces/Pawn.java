package org.example.pieces;

import org.example.Direction;
import org.example.PositionHelper;
import org.example.board.IPosition;
import org.example.board.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, IPosition position) {
        super(isWhite,position);
    }

    @Override
    public List<IPosition> getPossibleMoves() {
        List<IPosition> possibleMoves = new ArrayList<>();
        Direction direction = isWhite() ? Direction.UP:Direction.DOWN ;
        Optional<IPosition> move =   getPosition().move(direction);
        move.ifPresent(possibleMoves::add);
        return possibleMoves;
    }
}
