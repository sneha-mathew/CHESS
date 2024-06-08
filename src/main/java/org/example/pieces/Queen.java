package org.example.pieces;

import org.example.Direction;
import org.example.PositionHelper;
import org.example.board.IPosition;
import org.example.board.Position;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Queen extends Piece {
    public Queen(boolean isWhite, IPosition position) {
        super(isWhite,position);
    }

    @Override
    public List<IPosition> getPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        List<Direction> directions= List.of(Direction.UP,Direction.DOWN,Direction.LEFT,Direction.RIGHT,
                Direction.DIAG_UP_LEFT,Direction.DIAG_UP_RIGHT, Direction.DIAG_DOWN_LEFT,Direction.DIAG_DOWN_RIGHT);
        return directions.stream()
                .flatMap(direction ->getMoves(getPosition(),direction).stream())
                .collect(Collectors.toList());
    }

    private List<IPosition> getMoves(IPosition position, Direction direction) {
        List<IPosition> possibleMoves=new ArrayList<>();
        Optional<IPosition> newPosition=position.move(direction);
        newPosition.ifPresent(e -> {
            possibleMoves.addAll(getMoves(e,direction));
            possibleMoves.add(e);
        });
        return possibleMoves;
    }
}
