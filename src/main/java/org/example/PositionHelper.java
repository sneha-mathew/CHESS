package org.example;

import org.example.board.Position;

import java.util.List;
import java.util.stream.Collectors;

public class PositionHelper {
    public static List<String> getStringList(List<Position> listPosition) {
        return listPosition.stream().map(s -> s.toString()).sorted().collect(Collectors.toList());
    }
}
