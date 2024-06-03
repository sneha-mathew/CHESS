package org.example.board;

public class PositionValidator {
    public static boolean validPosition(String pos) {
        return pos != null && pos.length() == 2 && colValid(pos) && rowValid(pos);
    }

    private static boolean colValid(String pos) {
        return pos.charAt(0) >= 'A' && pos.charAt(0) <= 'H';
    }
    private static boolean rowValid(String pos) {
        return pos.charAt(1) >= '1' &&  pos.charAt(1) <= '8';
    }
}
