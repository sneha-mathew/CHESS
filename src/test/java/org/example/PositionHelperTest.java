package org.example;

import org.example.board.IPosition;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionHelperTest {
    @Test
    public void testGetStringList() throws InvalidPostionException {
        IPosition pos=new Position("A8");
        IPosition pos1=new Position("A3");
        IPosition pos2=new Position("H8");
        IPosition pos3=new Position("F8");
        IPosition pos4=new Position("F4");
        List<IPosition> positionList= List.of(pos,pos1,pos2,pos3,pos4);
        assertEquals(List.of("A3","A8","F4","F8","H8"),PositionHelper.getStringList(positionList));
    }
}