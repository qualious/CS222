package chess;

public class DominationSolver {
    /**
     * Solves the domination problem for a board of the given dimension
     * using pieces of the given type. A board is "dominated" if all the cells
     * are either occupied or can be attacked by a piece on the board.
     * The problem must be solved using the minimum number of pieces.
     * The returned board is one of the possibly many solutions.
     * @param dimension a positive integer as the dimension of the board
     * @param piece the piece that will be cloned and put on the board for solving
     *              the problem.
     * @return a solution board, or null if a solution does not exist.
     * @throws IllegalArgumentException if the dimension is non-positive
     */

    public Board solve(int dimension, Piece piece) {
        if(dimension < 1){
            throw new IllegalArgumentException();
        }
        Board board = new Board(dimension);
        if (piece instanceof Bishop)
            return solveForBishop(board);
        else if (piece instanceof King)
            return solveForKing(board);
        else if (piece instanceof Knight)
            return solveForKnight(board);
        else if (piece instanceof Queen)
            return solveForQueen(board);
        else if (piece instanceof Rook)
            return solveForRook(board);
        else
            return null;
    }

    private Board solveForBishop(Board board){
        for (int i = 0; i < board.getDimension(); ++i)
            board.put(new Bishop(), i, board.getDimension()/2);
        return board;
    }

    private Board solveForKing(Board board){
        if(board.getDimension()%3 == 0) {
            for (int i = 1; i < board.getDimension(); i += 3) {
                for (int j = 1; j < board.getDimension(); j += 3) {
                    board.put(new King(), i, j);
                }
            }
        }else {
            for (int i = 0; i < board.getDimension(); i += 3) {
                for (int j = 0; j < board.getDimension(); j += 3) {
                    board.put(new King(), i, j);
                }
            }
        }
        return board;
    }

    private Board solveForKnight(Board board){
        if(board.getDimension() == 1){
            board.put(new Knight(),0,0);
            return board;
        }
        if(board.getDimension() < 5){
            for (int i = board.getDimension()/2-1; i < board.getDimension()/2+1; ++i){
                for (int j = board.getDimension()/2-1; j < board.getDimension()/2+1; ++j){
                    board.put(new Knight(),i,j);
                }
            }
            return board;
        }else {
            for (int i = 2; i <= board.getDimension()-1; i += 5) {
                for (int j = 0; j < board.getDimension(); ++j) {
                    board.put(new Knight(), i, j);
                }
            }
            try {
                for (int j = 0; j < board.getDimension(); ++j)
                    board.put(new Knight(),board.getDimension()-1,j);
            }catch (AlreadyOccupiedException ignore){}

            return board;
        }
    }

    private Board solveForQueen(Board board){
        if(board.getDimension() < 4) {
            board.put(new Queen(), board.getDimension() / 2, board.getDimension() / 2);
            return board;
        }
        else{
            board.put(new Queen(), 1, 1);
            if(board.getDimension() == 4) {
                board.put(new Queen(), 1, 2);
                return board;
            }
            else if (board.getDimension() == 5) {

                board.put(new Queen(), 2, 2);
                board.put(new Queen(), 3, 3);
                return board;
            }
            else if (board.getDimension() == 7) {
                for (int i = 3; i <= board.getDimension() - 2; i++) {
                    board.put(new Queen(), i, i);
                }
                return board;
            }
            else if(board.getDimension()%2 == 1) {
                board.put(new Queen(),board.getDimension()-2,board.getDimension()-2);
                for (int i = 3; i <= board.getDimension() - 4; i++) {
                    board.put(new Queen(), i, i);
                }
                return board;
            }
            else{
                for (int i = 3; i <= board.getDimension() - 1; i++) {
                    board.put(new Queen(), i, i);
                }
                return board;
            }
        }
    }

    private Board solveForRook(Board board){
        for (int i = 0; i < board.getDimension(); ++i)
            board.put(new Rook(), 0,i);
        return board;
    }
}
