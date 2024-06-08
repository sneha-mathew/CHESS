package org.example.moves;

import org.example.PositionHelper;

public class LeftMoveStrategy implements IMoveStrategy {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(decrement(position.charAt(0)), position.charAt(1));
    }
}
