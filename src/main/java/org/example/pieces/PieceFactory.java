package org.example.pieces;

import org.example.board.IPosition;
import org.example.board.Position;
import org.example.exception.InvalidPostionException;
import org.example.exception.UnknownPiece;

public class PieceFactory {
    public static Piece getPiece(String pieceType, boolean isWhite, String pos)
            throws UnknownPiece, InvalidPostionException {
        IPosition position= new Position(pos);
        switch (pieceType) {
            case "Pawn":
                return new Pawn(isWhite, position);
            case "Queen":
                return new Queen(isWhite, position);
            case "King":
                return new King(isWhite, position);
            default:
                throw new UnknownPiece(pieceType+" Unknown piece type");
        }

    }
}
