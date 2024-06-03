package org.example.board;

import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PositionTest {

    @ParameterizedTest
    @ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
    public void testValidPosition(String pos) throws InvalidPostionException {
        Position position = new Position(pos);
        assertEquals(pos, position.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"I1", "A9", "1A", ""})
    public void testInvalidPositions(String pos) {
        assertThrows(InvalidPostionException.class, () -> new Position(pos));
    }

    @Test
    public void testInvalidPositionNULL()  {
        assertThrows(InvalidPostionException.class, () -> new Position(null));
    }

    @Test
    public void testValidMoveForward() throws InvalidPostionException{
        Position pos =  new Position("A1");
        assertEquals("A2",pos.moveForward().orElseThrow().toString());

        pos =  new Position("H1");
        assertEquals("H2",pos.moveForward().orElseThrow().toString());

        pos =  new Position("F4");
        assertEquals("F5",pos.moveForward().orElseThrow().toString());

        pos =  new Position("F1");
        assertEquals("F2",pos.moveForward().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A8", "F8", "H8"})
    public void testNoMovesForward(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveForward());
    }

    @Test
    public void testMoveBackward() throws InvalidPostionException {
        Position pos =  new Position("A8");
        assertEquals("A7",pos.moveBackward().orElseThrow().toString());

        pos =  new Position("F8");
        assertEquals("F7",pos.moveBackward().orElseThrow().toString());

        pos =  new Position("F4");
        assertEquals("F3",pos.moveBackward().orElseThrow().toString());

        pos =  new Position("H8");
        assertEquals("H7",pos.moveBackward().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1",  "F1", "H1"})
    public void testNoMoveBackward(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveBackward());
    }


    @Test
    public void testMoveRight() throws InvalidPostionException {
        Position position =  new Position("A1");
        assertEquals("B1",position.moveRight().orElseThrow().toString());

        position =  new Position("A8");
        assertEquals("B8",position.moveRight().orElseThrow().toString());

        position =  new Position("F1");
        assertEquals("G1",position.moveRight().orElseThrow().toString());

        position =  new Position("F8");
        assertEquals("G8",position.moveRight().orElseThrow().toString());

        position =  new Position("F4");
        assertEquals("G4",position.moveRight().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"H1", "H8"})
    public void testNoMoveRight(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveRight());
    }

    @Test
    public void testMoveLeft() throws InvalidPostionException {
        Position position =  new Position("F1");
        assertEquals("E1",position.moveLeft().orElseThrow().toString());

        position =  new Position("F8");
        assertEquals("E8",position.moveLeft().orElseThrow().toString());

        position =  new Position("F4");
        assertEquals("E4",position.moveLeft().orElseThrow().toString());

        position =  new Position("H1");
        assertEquals("G1",position.moveLeft().orElseThrow().toString());

        position =  new Position("H8");
        assertEquals("G8",position.moveLeft().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1", "A8"})
    public void testNoMoveLeft(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveLeft());
    }

    @Test
    public void testMoveDiagDownRight() throws InvalidPostionException {
        Position position =  new Position("A8");
        assertEquals("B7",position.moveDiagDownRight().orElseThrow().toString());

        position =  new Position("F8");
        assertEquals("G7",position.moveDiagDownRight().orElseThrow().toString());

        position =  new Position("F4");
        assertEquals("G3",position.moveDiagDownRight().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1", "F1", "H1", "H8"})
    public void testNoMoveDiagDownRight(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveDiagDownRight());
    }

    //@ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
    @Test
    public void testMoveDiagDownLeft() throws InvalidPostionException {
        Position position =  new Position("F8");
        assertEquals("E7",position.moveDiagDownLeft().orElseThrow().toString());

        position =  new Position("F4");
        assertEquals("E3",position.moveDiagDownLeft().orElseThrow().toString());

        position =  new Position("H8");
        assertEquals("G7",position.moveDiagDownLeft().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1", "A8", "F1", "H1"})
    public void testNoMoveDiagDownLeft(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveDiagDownLeft());
    }

    @Test
    public void testMoveDiagUpLeft() throws InvalidPostionException {
        Position pos =  new Position("F4");
        assertEquals("E5",pos.moveDiagUpLeft().orElseThrow().toString());

        pos =  new Position("F4");
        assertEquals("E5",pos.moveDiagUpLeft().orElseThrow().toString());

        pos =  new Position("H1");
        assertEquals("G2",pos.moveDiagUpLeft().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A1", "A8", "F8", "H8"})
    public void testNoMoveDiagUpLeft(String pos) throws  InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveDiagUpLeft());
    }
    //@ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
    @Test
    public void testMoveDiagUpRight() throws InvalidPostionException {
        Position position =  new Position("A1");
        assertEquals("B2",position.moveDiagUpRight().orElseThrow().toString());

        position =  new Position("F1");
        assertEquals("G2",position.moveDiagUpRight().orElseThrow().toString());

        position =  new Position("F4");
        assertEquals("G5",position.moveDiagUpRight().orElseThrow().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A8", "F8",  "H1", "H8"})
    public void testNoMoveDiagUpRight(String pos) throws InvalidPostionException {
        Position position =  new Position(pos);
        assertEquals(Optional.empty(), position.moveDiagUpRight());
    }
}
