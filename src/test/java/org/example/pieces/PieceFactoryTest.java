package org.example.pieces;

import org.example.exception.InvalidPostionException;
import org.example.exception.UnknownPiece;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {
    @Test
    public void testGetPiece() throws InvalidPostionException, UnknownPiece {
        Piece piece=PieceFactory.getPiece("Pawn",true,"B1");
        assertEquals(Pawn.class,piece.getClass());
        assertEquals(true,piece.isWhite());
        assertEquals("B1",piece.getPosition().toString());

        piece=PieceFactory.getPiece("King",false,"G8");
        assertEquals(King.class,piece.getClass());
        assertEquals(false,piece.isWhite());
        assertEquals("G8",piece.getPosition().toString());

        piece=PieceFactory.getPiece("Queen",true,"F4");
        assertEquals(Queen.class,piece.getClass());
        assertEquals(true,piece.isWhite());
        assertEquals("F4",piece.getPosition().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rock",  "Knight", "Horse"})
    public void testNoPieceFound(String piece) throws InvalidPostionException {
        assertThrows(UnknownPiece.class, () -> {
            PieceFactory.getPiece(piece,true,"F4");
        });
    }
}