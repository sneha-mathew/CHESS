//package org.example.board;
//
//import org.example.Direction;
//import org.example.PositionHelper;
//import org.example.exception.InvalidPostionException;
//import org.example.moves.IMoveStrategy;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//public class PositionTest {
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
//    public void testValidPosition(String pos) throws InvalidPostionException {
//        Position position = new Position(pos);
//        assertEquals(pos, position.toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"I1", "A9", "1A", ""})
//    public void testInvalidPositions(String pos) {
//        assertThrows(InvalidPostionException.class, () -> new Position(pos));
//    }
//
//    @Test
//    public void testInvalidPositionNULL()  {
//        assertThrows(InvalidPostionException.class, () -> new Position(null));
//    }
//
//    @Test
//    public void testValidMoveUp() throws InvalidPostionException{
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.UP));
//        Position pos =  new Position("A1");
//        assertEquals("A2",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("H1");
//        assertEquals("H2",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("F4");
//        assertEquals("F5",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("F1");
//        assertEquals("F2",pos.move(moveStrategy).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A8", "F8", "H8"})
//    public void testNoMovesUp(String pos) throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.UP));
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(moveStrategy));
//    }
//
//    @Test
//    public void testMoveDown() throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.DOWN));
//        Position pos =  new Position("A8");
//        assertEquals("A7",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("F8");
//        assertEquals("F7",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("F4");
//        assertEquals("F3",pos.move(moveStrategy).orElseThrow().toString());
//
//        pos =  new Position("H8");
//        assertEquals("H7",pos.move(moveStrategy).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1",  "F1", "H1"})
//    public void testNoMoveDown(String pos) throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.DOWN));
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(moveStrategy));
//    }
//
//
//    @Test
//    public void testMoveRight() throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.RIGHT));
//        Position position =  new Position("A1");
//        assertEquals("B1",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("A8");
//        assertEquals("B8",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F1");
//        assertEquals("G1",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F8");
//        assertEquals("G8",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F4");
//        assertEquals("G4",position.move(moveStrategy).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"H1", "H8"})
//    public void testNoMoveRight(String pos) throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.RIGHT));
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(moveStrategy));
//    }
//
//    @Test
//    public void testMoveLeft() throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.LEFT));
//        Position position =  new Position("F1");
//        assertEquals("E1",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F8");
//        assertEquals("E8",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F4");
//        assertEquals("E4",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("H1");
//        assertEquals("G1",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("H8");
//        assertEquals("G8",position.move(moveStrategy).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1", "A8"})
//    public void testNoMoveLeft(String pos) throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.LEFT));
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(moveStrategy));
//    }
//
//    @Test
//    public void testMoveDiagDownRight() throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.DIAG_DOWN_RIGHT));
//        Position position =  new Position("A8");
//        assertEquals("B7",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F8");
//        assertEquals("G7",position.move(moveStrategy).orElseThrow().toString());
//
//        position =  new Position("F4");
//        assertEquals("G3",position.move(moveStrategy).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1", "F1", "H1", "H8"})
//    public void testNoMoveDiagDownRight(String pos) throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.DIAG_DOWN_RIGHT));
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(moveStrategy));
//    }
//
//    //@ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
//    @Test
//    public void testMoveDiagDownLeft() throws InvalidPostionException {
//        IMoveStrategy moveStrategy=(PositionHelper.getMoveStrategy(Direction.DIAG_DOWN_RIGHT));
//        Position position =  new Position("F8");
//        assertEquals("E7",position.move(Direction.DIAG_DOWN_LEFT).orElseThrow().toString());
//
//        position =  new Position("F4");
//        assertEquals("E3",position.move(Direction.DIAG_DOWN_LEFT).orElseThrow().toString());
//
//        position =  new Position("H8");
//        assertEquals("G7",position.move(Direction.DIAG_DOWN_LEFT).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1", "A8", "F1", "H1"})
//    public void testNoMoveDiagDownLeft(String pos) throws InvalidPostionException {
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(Direction.DIAG_DOWN_LEFT));
//    }
//
//    @Test
//    public void testMoveDiagUpLeft() throws InvalidPostionException {
//        Position pos =  new Position("F4");
//        assertEquals("E5",pos.move(Direction.DIAG_UP_LEFT).orElseThrow().toString());
//
//        pos =  new Position("F4");
//        assertEquals("E5",pos.move(Direction.DIAG_UP_LEFT).orElseThrow().toString());
//
//        pos =  new Position("H1");
//        assertEquals("G2",pos.move(Direction.DIAG_UP_LEFT).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A1", "A8", "F8", "H8"})
//    public void testNoMoveDiagUpLeft(String pos) throws  InvalidPostionException {
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(Direction.DIAG_UP_LEFT));
//    }
//    //@ValueSource(strings = {"A1", "A8", "F1", "F8", "F4", "H1", "H8"})
//    @Test
//    public void testMoveDiagUpRight() throws InvalidPostionException {
//        Position position =  new Position("A1");
//        assertEquals("B2",position.move(Direction.DIAG_UP_RIGHT).orElseThrow().toString());
//
//        position =  new Position("F1");
//        assertEquals("G2",position.move(Direction.DIAG_UP_RIGHT).orElseThrow().toString());
//
//        position =  new Position("F4");
//        assertEquals("G5",position.move(Direction.DIAG_UP_RIGHT).orElseThrow().toString());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A8", "F8",  "H1", "H8"})
//    public void testNoMoveDiagUpRight(String pos) throws InvalidPostionException {
//        Position position =  new Position(pos);
//        assertEquals(Optional.empty(), position.move(Direction.DIAG_UP_RIGHT));
//    }
//}
