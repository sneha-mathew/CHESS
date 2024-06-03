package org.example.pieces;

import org.example.PositionHelper;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {
    @Test
    public void testQueenPossibleMoves() throws InvalidPostionException {
        Piece piece=new Queen(true,new Position("A1"));
        assertEquals(List.of("A2", "A3", "A4", "A5", "A6", "A7", "A8", "B1", "B2",
                        "C1", "C3", "D1", "D4", "E1", "E5", "F1", "F6", "G1", "G7","H1", "H8"),
                PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Queen(false,new Position("A8"));
        assertEquals(List.of("A1","A2", "A3", "A4", "A5", "A6", "A7", "B7", "B8",
                        "C6", "C8", "D5", "D8", "E4", "E8", "F3", "F8", "G2", "G8","H1", "H8"),
                PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Queen(true,new Position("H1"));
        assertEquals(List.of("A1", "A8", "B1", "B7", "C1","C6", "D1", "D5","E1", "E4",
                        "F1", "F3", "G1", "G2", "H2", "H3", "H4", "H5", "H6", "H7", "H8"),
                PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Queen(false,new Position("H8"));
        assertEquals(List.of("A1", "A8", "B2", "B8", "C3", "C8", "D4", "D8", "E5", "E8",
                        "F6", "F8", "G7", "G8", "H1", "H2", "H3", "H4", "H5", "H6", "H7"),
                PositionHelper.getStringList(piece.getPossibleMoves()));

        piece=new Queen(true,new Position("F4"));
        assertEquals(List.of("A4", "B4", "B8", "C1", "C4","C7", "D2", "D4", "D6", "E3",
                        "E4", "E5", "F1", "F2", "F3", "F5", "F6","F7", "F8", "G3", "G4", "G5", "H2",
                        "H4", "H6"),
                PositionHelper.getStringList(piece.getPossibleMoves()));




    }
}