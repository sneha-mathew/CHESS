package org.example.moves;

import org.example.PositionHelper;

public class DiagUpLeftMoveStrategy implements IMoveStrategy {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(decrement(position.charAt(0)), increment(position.charAt(1)));
    }
}
