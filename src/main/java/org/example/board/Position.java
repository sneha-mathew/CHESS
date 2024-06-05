package org.example.board;

import org.example.PositionHelper;
import org.example.exception.InvalidPostionException;
import org.example.moves.*;

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
        return PositionHelper.getString(column,row);
    }

    public Optional<Position> moveForward()  {
        String newPosition=new MoveForward().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveBackward()  {
        String newPosition=new MoveBackward().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveRight()  {
        String newPosition=new MoveRight().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveLeft() {
        String newPosition=new MoveLeft().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveDiagUpRight()  {
        String newPosition=new MoveDiagUpRight().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveDiagUpLeft() {
        String newPosition=new MoveDiagUpLeft().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveDiagDownRight()  {
        String newPosition=new MoveDiagDownRight().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    public Optional<Position> moveDiagDownLeft() {
        String newPosition=new MoveDiagDownLeft().proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }

    private char increment(char c) {
        return (char) (c + 1);
    }
    private char decrement(char c) {
        return (char) (c - 1);
    }
    private Optional<Position> move(char column, char row) {
        return getPosition("" + column + row);
    }

    private static Optional<Position> getPosition(String pos) {
        try {
            return Optional.of(new Position(pos));
        }catch (InvalidPostionException ex){
            return Optional.empty();
        }
    }
}