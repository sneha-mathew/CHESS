package org.example.board;

import org.example.Direction;
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

    public Optional<Position> move(Direction direction ){
        Move move = null;
        switch (direction){
            case UP: move=new MoveUp();break;
            case DOWN: move=new MoveDown();break;
            case RIGHT: move=new MoveRight();break;
            case LEFT: move=new MoveLeft();break;
            case DIAG_UP_LEFT: move=new MoveDiagUpLeft();break;
            case DIAG_UP_RIGHT: move=new MoveDiagUpRight();break;
            case DIAG_DOWN_RIGHT: move=new MoveDiagDownRight();break;
            case DIAG_DOWN_LEFT: move=new MoveDiagDownLeft();break;
        }
        String newPosition=move.proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }
    private static Optional<Position> getPosition(String pos) {
        try {
            return Optional.of(new Position(pos));
        }catch (InvalidPostionException ex){
            return Optional.empty();
        }
    }
}