package org.example.moves;

import org.example.PositionHelper;

public class MoveDiagDownLeft implements Move{
    @Override
    public String proceed(String position) {
        return PositionHelper.getString(decrement(position.charAt(0)), decrement(position.charAt(1)));
    }
}
