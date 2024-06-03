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

}
