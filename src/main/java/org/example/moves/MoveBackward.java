package org.example.moves;

import org.example.PositionHelper;

public class MoveBackward implements Move {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(position.charAt(0), decrement(position.charAt(1)));
    }
}
