package org.example.moves;

import org.example.PositionHelper;

public class DiagDownRightMoveStrategy implements IMoveStrategy {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), decrement(position.charAt(1)));
    }
}
