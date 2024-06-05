package org.example.moves;

import org.example.PositionHelper;

public class MoveRight implements Move {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), position.charAt(1));
    }
}
