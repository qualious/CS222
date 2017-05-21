package chess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Reducer {

    private Board board;
    private int accumulatedScore = 0;
    private List<Piece> pieces = new ArrayList<>();

    public Reducer(Board board) {
        if(board == null)
            throw new IllegalArgumentException();
        this.board = board;
        this.pieces = board.getPieces();
    }

    public void reduceOnce() {
        List<Piece> modifiedPieces = new ArrayList<>();

        for (Piece piece: pieces) {
            modifiedPieces.add(piece);
        }
        modifiedPieces.sort(Comparator.comparing(Piece::getValue));

        while (!modifiedPieces.isEmpty()) {
            Piece maxValued = modifiedPieces.get(modifiedPieces.size()-1);
            for (Piece piece : pieces) {
                if (piece.canAttack(maxValued.getX(), maxValued.getY())) {
                    replaceIndeces(piece, maxValued);
                    return;
                }
            }
            modifiedPieces.remove(modifiedPieces.size()-1);
        }
    }

    private void replaceIndeces(Piece replacer, Piece replacement){
        board.removePieceAt(replacer.getX(), replacer.getY());
        board.removePieceAt(replacement.getX(), replacement.getY());
        board.put(replacer, replacement.getX(), replacement.getY());
        accumulatedScore += replacement.getValue();
    }

    public Board getBoard() {
        return board;
    }

    public int getAccummulatedScore() {
        return accumulatedScore;
    }
}
