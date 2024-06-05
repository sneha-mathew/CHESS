package org.example.moves;

import org.example.PositionHelper;

public class MoveUp implements Move {

    @Override
    public String proceed(String position) {
        return PositionHelper.getString(position.charAt(0), increment(position.charAt(1)));
    }



}
