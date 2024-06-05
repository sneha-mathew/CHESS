package org.example.pieces;

import org.example.Direction;
import org.example.board.Position;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Queen extends Piece {
    public Queen(boolean isWhite, Position position) {
        super(isWhite,position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        List<Direction> directions= List.of(Direction.UP,Direction.DOWN,Direction.LEFT,Direction.RIGHT,
                Direction.DIAG_UP_LEFT,Direction.DIAG_UP_RIGHT, Direction.DIAG_DOWN_LEFT,Direction.DIAG_DOWN_RIGHT);
        return directions.stream()
                .flatMap(direction ->getMoves(getPosition(),direction).stream())
                .collect(Collectors.toList());
    }

    private List<Position> getMoves( Position position, Direction direction) {
        List<Position> possibleMoves=new ArrayList<>();
        Optional<Position> newPosition=position.move(direction);
        newPosition.ifPresent(e -> {
            possibleMoves.addAll(getMoves(e,direction));
            possibleMoves.add(e);
        });
        return possibleMoves;
    }
}
