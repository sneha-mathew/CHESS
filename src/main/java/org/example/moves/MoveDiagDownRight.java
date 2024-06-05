package org.example.moves;

import org.example.PositionHelper;

public class MoveDiagDownRight implements Move{
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(increment(position.charAt(0)), decrement(position.charAt(1)));
    }
}
