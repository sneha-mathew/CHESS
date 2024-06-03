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

}