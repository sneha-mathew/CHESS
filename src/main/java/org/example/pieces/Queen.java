package org.example.pieces;

import org.example.board.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Queen extends Piece {
    public Queen(boolean isWhite, Position position) {
        super(isWhite,position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(recursiveBackward(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveForward(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveLeft(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveRight(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveDiagUpLeft(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveDiagUpRight(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveDiagDownLeft(new ArrayList<>(),getPosition()));
        possibleMoves.addAll(recursiveDiagDownRight(new ArrayList<>(),getPosition()));
        return possibleMoves;
    }

    private List<Position> recursiveBackward(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveBackward();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveBackward(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveForward(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveForward();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveForward(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveLeft(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveLeft();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveLeft(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveRight(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveRight();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveRight(possibleMoves,move.get());});
        return possibleMoves;
    }

    private List<Position> recursiveDiagUpRight(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveDiagUpRight();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveDiagUpRight(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveDiagUpLeft(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveDiagUpLeft();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveDiagUpLeft(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveDiagDownLeft(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveDiagDownLeft();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveDiagDownLeft(possibleMoves,move.get());});
        return possibleMoves;
    }
    private List<Position> recursiveDiagDownRight(List<Position> possibleMoves, Position position) {
        Optional<Position> move=position.moveDiagDownRight();
        move.ifPresent(e ->{ possibleMoves.add(e); recursiveDiagDownRight(possibleMoves,move.get());});
        return possibleMoves;
    }
}
