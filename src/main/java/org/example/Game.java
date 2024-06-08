package org.example;

import org.example.board.IPosition;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.example.exception.UnknownPiece;
import org.example.pieces.Piece;
import org.example.pieces.PieceFactory;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Mention the piece, the color and the position");
        Scanner sc = new Scanner(System.in);
        String pieceType = sc.next();
        String colour = sc.next();
        String pos = sc.next();
        processInput(pieceType, colour, pos);
    }

    private static void processInput(String pieceType, String colour, String pos) {
        try {
            List<IPosition> positionList = PieceFactory.getPiece(pieceType, ("white").equals(colour.toLowerCase()), pos).getPossibleMoves();
            System.out.println("The possible moves are " + PositionHelper.getStringList(positionList));
        } catch (UnknownPiece | InvalidPostionException e) {
            System.out.println(e.getMessage());
        }
    }
}
