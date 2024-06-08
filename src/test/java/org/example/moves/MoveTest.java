package org.example.moves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    String pos="K8";

    @Test
    void testAllMoves() {
        IMoveStrategy move=new DownMoveStrategy();
        assertEquals("K7",move.proceed(pos));

        move=new UpStrategy();
        assertEquals("K9",move.proceed(pos));

        move=new LeftMoveStrategy();
        assertEquals("J8",move.proceed(pos));

        move=new RightStrategy();
        assertEquals("L8",move.proceed(pos));

        move=new DiagUpLeftMoveStrategy();
        assertEquals("J9",move.proceed(pos));

        move=new DiagUpRightMoveStrategy();
        assertEquals("L9",move.proceed(pos));

        move=new DiagDownLeftMoveStrategy();
        assertEquals("J7",move.proceed(pos));

        move=new DiagDownRightMoveStrategy();
        assertEquals("L7",move.proceed(pos));
    }
}