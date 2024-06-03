package org.example.pieces;

import org.example.PositionHelper;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    @Test
    public void testKingPossibleMoves() throws InvalidPostionException {
        Piece piece=new King(true,new Position("A1"));
        assertEquals(List.of("A2","B1","B2"), PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new King(true,new Position("A8"));
        assertEquals(List.of("A7","B7","B8"), PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new King(true,new Position("H1"));
        assertEquals(List.of("G1","G2","H2"), PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new King(true,new Position("H8"));
        assertEquals(List.of("G7","G8","H7"), PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new King(true,new Position("F4"));
        assertEquals(List.of("E3","E4","E5","F3","F5","G3","G4","G5"), PositionHelper.getStringList(piece.getPossibleMoves()));

    }
}