package org.example.moves;

import org.example.PositionHelper;

public class RightStrategy implements IMoveStrategy {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), position.charAt(1));
    }
}
