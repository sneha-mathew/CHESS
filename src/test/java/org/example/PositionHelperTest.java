package org.example;

import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionHelperTest {
    @Test
    public void testGetStringList() throws InvalidPostionException {
        Position pos=new Position("A8");
        Position pos1=new Position("A3");
        Position pos2=new Position("H8");
        Position pos3=new Position("F8");
        Position pos4=new Position("F4");
        List<Position> positionList= List.of(pos,pos1,pos2,pos3,pos4);
        assertEquals(List.of("A3","A8","F4","F8","H8"),PositionHelper.getStringList(positionList));
    }
}