package org.example.moves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    String pos="K8";

    @Test
    void testAllMoves() {
        Move move=new MoveDown();
        assertEquals("K7",move.proceed(pos));

        move=new MoveUp();
        assertEquals("K9",move.proceed(pos));

        move=new MoveLeft();
        assertEquals("J8",move.proceed(pos));

        move=new MoveRight();
        assertEquals("L8",move.proceed(pos));

        move=new MoveDiagUpLeft();
        assertEquals("J9",move.proceed(pos));

        move=new MoveDiagUpRight();
        assertEquals("L9",move.proceed(pos));

        move=new MoveDiagDownLeft();
        assertEquals("J7",move.proceed(pos));

        move=new MoveDiagDownRight();
        assertEquals("L7",move.proceed(pos));
    }
}