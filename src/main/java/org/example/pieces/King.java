package org.example.pieces;

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
        List<Optional<Position>> optionalList = List.of(
                getPosition().moveBackward(),
                getPosition().moveForward(),
                getPosition().moveLeft(),
                getPosition().moveRight(),
                getPosition().moveDiagUpLeft(),
                getPosition().moveDiagUpRight(),
                getPosition().moveDiagDownLeft(),
                getPosition().moveDiagDownRight());
        return   optionalList.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
