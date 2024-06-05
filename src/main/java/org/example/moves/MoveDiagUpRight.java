package org.example.moves;

import org.example.PositionHelper;

public class MoveDiagUpRight implements Move {
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), increment(position.charAt(1)));
    }
}
