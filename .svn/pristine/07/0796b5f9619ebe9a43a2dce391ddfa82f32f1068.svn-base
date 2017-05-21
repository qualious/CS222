package chess;

import java.util.*;

public class Board {
    private int dimension;
    private Piece[][] board;
    private List<Piece> pieces = new ArrayList<>();

    // Create an 8-by-8 board
    public Board() {
        dimension = 8;
        board = new Piece[dimension][dimension];
    }

    // Create an n-by-n board
    public Board(int dimension) {
        if(dimension < 1)
            throw new IllegalArgumentException();
        this.dimension = dimension;
        board = new Piece[dimension][dimension];
    }

    public void put(Piece piece, int x, int y) {
        try {
            if(board[x][y] != null)
                throw new AlreadyOccupiedException("Piece already exists at location (" + x +
                                                                                    "," + y +").");
            piece.setPosition(x,y);
            board[x][y] = piece;
            pieces.add(piece);
        }catch (IndexOutOfBoundsException  e){
            System.err.println("Out of bonds exception when trying to put the piece: " + e.getMessage());
        }
    }

    public Piece getPieceAt(int x, int y) {
        try {
            return board[x][y];
        }catch (IndexOutOfBoundsException  e){
            return null;
        }
    }

    /**
     * Returns whether this board is "valid" or not.
     * For a board to be valid, no piece should be able to attack another.
     *
     * @return true if the board is valid; false, otherwise.
     */
    public boolean isValid() {
        for (int i = 0; i < pieces.size(); ++i){
            for (int j = 0; j < pieces.size(); ++j){
                if(i != j && pieces.get(i).canAttack(pieces.get(j).getX(),pieces.get(j).getY()))
                    return false;
            }
        }
        return true;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    // Sample output fof toString():
    //
    // ---------
    // |R| | |R|
    // +-+-+-+-+
    // | | | | |
    // +-+-+-+-+
    // | |Q| |B|
    // +-+-+-+-+
    // | | |K| |
    // ---------
    public String toString() {
        String boardGUI = "";
        boardGUI = addBorder(boardGUI);
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                boardGUI = addSymbol(boardGUI, i, j);
            }
            boardGUI = addBorder(boardGUI);
        }
        boardGUI = boardGUI.substring(1,boardGUI.length() - 1);
        return boardGUI;
    }
    private String addSymbol(String boardGUI, int i, int j){
        try {
            board[i][j].getSymbol();
            boardGUI += board[i][j].getSymbol() + "|";
        } catch (NullPointerException e) {
            boardGUI += " |";
        }
        return boardGUI;
    }

    private String addBorder(String boardGUI){
        boardGUI += "\n+";
        for (int k = 0; k < dimension; ++k)
            boardGUI += "-+";
        boardGUI += "\n|"; //11 for 5
        return boardGUI;
    }

    public int getDimension() {
        return dimension;
    }

    public Board clone() {
        Board cloneBoard = new Board(this.getDimension());
        cloneBoard.setBoard(getBoard());
        cloneBoard.setPieces(this.getPieces());
        return cloneBoard;
    }

    private void setBoard (Piece [][] board){
        this.board = board;
    }

    private void setPieces (List<Piece> pieces){
        this.pieces = pieces;
    }

    // A board is equal to another board if they contain the same
    // type of pieces on the same locations
    public boolean equals(Object that) {
        Piece [][] thisBoard = this.getBoard();
        Piece [][] thatBoard = ((Board)that).getBoard();
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                if(!Arrays.deepEquals(thisBoard,thatBoard))
                    return false;
            }
        }
        return true;
    }

    public Piece[][] getBoard(){
        return board;
    }


    // Return true if x,y is not occupied and TODO: cannot be attacked by any piece
    public boolean isAvailable(int x, int y) {
        try {
            board[x][y].getSymbol();
            return false;
        }catch (NullPointerException e){
            return true;
        }
    }

    // Return the most recent piece put on this board
    public Piece getLastPiece() {
        if(pieces.isEmpty())
            return null;
        else
            return pieces.get(pieces.size()-1);
    }

    public void removeLastPiece() {
        if(pieces.size() < 1)
            throw new ArrayIndexOutOfBoundsException();
        board[pieces.get(pieces.size()-1).getX()][pieces.get(pieces.size()-1).getY()] = null;
        pieces.remove(pieces.size()-1);
    }

    protected void removePieceAt(int x, int y){
        board[x][y] = null;
        for (Iterator<Piece> iter = pieces.listIterator(); iter.hasNext();) {
            Piece piece = iter.next();
            if (piece.getX() == x && piece.getY() == y) {
                iter.remove();
            }
        }
    }

    // A board is covered if all the cells are unavailable
    public boolean isCovered() {
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                try {
                    board[i][j].getSymbol();
                } catch (NullPointerException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
