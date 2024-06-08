package org.example;

import org.example.board.IPosition;
import org.example.board.Position;
import org.example.moves.*;

import java.util.List;
import java.util.stream.Collectors;

public class PositionHelper {
    public static List<String> getStringList(List<IPosition> listPosition) {
        return listPosition.stream().map(s -> s.toString()).sorted().collect(Collectors.toList());
    }
    public static String getString(char col, char row) {
        return new StringBuilder()
                .append(col)
                .append(row)
                .toString();
    }

}
