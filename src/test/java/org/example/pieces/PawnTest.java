package org.example.pieces;

import org.example.PositionHelper;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    public void testWhitePawnPossibleMoves() throws InvalidPostionException {
        Piece piece=new Pawn(true,new Position("B1"));
        assertEquals(List.of("B2"), PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Pawn(true,new Position("H8"));
        assertEquals(List.of(),PositionHelper.getStringList(piece.getPossibleMoves()));
    }
    @Test
    public void testBlackPawnPossibleMoves() throws InvalidPostionException {
        Piece piece=new Pawn(false,new Position("B1"));
        assertEquals(List.of(),PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Pawn(false,new Position("H8"));
        assertEquals(List.of("H7"),PositionHelper.getStringList(piece.getPossibleMoves()));
    }

}