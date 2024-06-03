package org.example.board;

import org.example.exception.InvalidPostionException;
import java.util.Optional;

public class Position {
    private char column;
    private char row;
    public Position(String pos) throws InvalidPostionException {
        if (PositionValidator.validPosition(pos)) {
            column = pos.charAt(0);
            row = pos.charAt(1) ;
        } else
            throw new InvalidPostionException("The position "+pos+" is not a valid position.");
    }

    @Override
    public String toString() {
        return String.valueOf(column)+String.valueOf(row);
    }

    public Optional<Position> moveForward()  {
        return move(column,increment(row));
    }

    public Optional<Position> moveBackward()  {
        return move(column,decrement(row));
    }

    public Optional<Position> moveRight()  {
        return move( increment(column),row);
    }

    public Optional<Position> moveLeft() {
        return move( decrement(column),row);
    }

    public Optional<Position> moveDiagUpRight()  {
        return move(increment(column),increment(row));
    }

    public Optional<Position> moveDiagUpLeft() {
        return move( decrement(column),increment(row));
    }

    public Optional<Position> moveDiagDownRight()  {
        return move( increment(column),decrement(row));
    }

    public Optional<Position> moveDiagDownLeft() {
        return move( decrement(column),decrement(row));
    }

    private char increment(char c) {
        return (char) (c + 1);
    }
    private char decrement(char c) {
        return (char) (c - 1);
    }
    private Optional<Position> move(char column, char row) {
        try {
            return Optional.of(new Position("" + column + row));
        }catch (InvalidPostionException ex){
            return  Optional.empty();
        }
    }
}