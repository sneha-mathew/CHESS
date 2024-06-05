package org.example.moves;

import org.example.PositionHelper;
import org.example.board.Position;

public class MoveForward implements Move {

    @Override
    public String proceed(String position) {
        return PositionHelper.getString(position.charAt(0), increment(position.charAt(1)));
    }



}
