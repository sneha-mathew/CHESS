package org.example.pieces;

import org.example.Direction;
import org.example.board.Position;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class King extends Piece {
    public King(boolean isWhite, Position position) {
        super(isWhite,position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Direction> directions= List.of(Direction.UP,Direction.DOWN,Direction.LEFT,Direction.RIGHT,
                Direction.DIAG_UP_LEFT,Direction.DIAG_UP_RIGHT, Direction.DIAG_DOWN_LEFT,Direction.DIAG_DOWN_RIGHT);
        return directions.stream().map(direction ->getPosition().move(direction))
               .filter(Optional::isPresent)
               .map(Optional::get)
                .collect(Collectors.toList());
    }
}
