package org.example.moves;

import org.example.PositionHelper;

public class DiagUpRightMoveStrategy implements IMoveStrategy {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), increment(position.charAt(1)));
    }
}
