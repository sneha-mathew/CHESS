package org.example.board;

import org.example.Direction;
import org.example.PositionHelper;
import org.example.exception.InvalidPostionException;
import org.example.moves.*;

import java.util.Optional;

public class Position implements IPosition{
    private char column;
    private char row;
    public Position(String pos) throws InvalidPostionException {
        if (validPosition(pos)) {
            column = pos.charAt(0);
            row = pos.charAt(1) ;
        } else
            throw new InvalidPostionException("The position "+pos+" is not a valid position.");
    }

    @Override
    public String toString() {
        return PositionHelper.getString(column,row);
    }

    public Optional<IPosition> move(Direction direction){
        IMoveStrategy moveStrategy=getMoveStrategy(direction);
        String newPosition=moveStrategy.proceed(PositionHelper.getString(column,row));
        return getPosition(newPosition);
    }
    private static Optional<IPosition> getPosition(String pos) {
        try {
            return Optional.of(new Position(pos));
        }catch (InvalidPostionException ex){
            return Optional.empty();
        }
    }
    private IMoveStrategy getMoveStrategy(Direction direction) {
        IMoveStrategy move = null;
        switch (direction){
            case UP: move=new UpStrategy();break;
            case DOWN: move=new DownMoveStrategy();break;
            case RIGHT: move=new RightStrategy();break;
            case LEFT: move=new LeftMoveStrategy();break;
            case DIAG_UP_LEFT: move=new DiagUpLeftMoveStrategy();break;
            case DIAG_UP_RIGHT: move=new DiagUpRightMoveStrategy();break;
            case DIAG_DOWN_RIGHT: move=new DiagDownRightMoveStrategy();break;
            case DIAG_DOWN_LEFT: move=new DiagDownLeftMoveStrategy();break;
        }
        return move;
    }
}