package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A Sudoku board is a grid that is made up from subgrids.
 * If the size of a subgrid is N-by-M, then the board's size is
 * M-by-N.
 *
 * For example, this is a (3,3) Sudoku board:
 *   https://upload.wikimedia.org/wikipedia/commons/f/ff/Sudoku-by-L2G-20050714.svg
 * whereas this is (2,3):
 *   http://logos.cs.uic.edu/109/assignments/Sudoku6x6_8.gif
 * and this one is (2,5):
 *   http://www.sachsentext.de/gif/1-2-3-4a.gif
 *
 * The goal in Sudoku is to fill the board with numbers from 1 to NxM
 * such that on each row, each column, and within each subgrid,
 * each number appears exactly once.
 */

public class SudokuBoard {
    private final int N;
    private final int M;
    private Integer[][] board;


    /**
     * Creates a Sudoku board where subgrids are of size N-by-M.
     *
     * @throws IllegalArgumentException if n or m is non-positive.
     */
    public SudokuBoard(int N, int M) {
        if(N < 0 || M < 0)
            throw new IllegalArgumentException();
        this.N = N;
        this.M = M;
        board = new Integer[N*M][N*M];
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    /**
     * Place number into cell at position (x, y),
     * where x is the row index, y is the column index.
     * The top-left corner of the board is (0,0).
     *
     * @throws IllegalArgumentException if number is not in the range [1, NxM]
     */
    public void place(int number, int x, int y) {
        if(x >= x *y || y >= x*y)
            throw new IllegalArgumentException();
        if(this.get(x,y) != 0)
            throw new RuntimeException();
        if(number < 1)
            throw new IllegalArgumentException();
        board[x][y] = number;
    }

    /**
     * Returns the value at the given location.
     * If the location has not been filled yet, returns 0.
     */
    public int get(int x, int y) {
        if(board[x][y] != 0)
            return board[x][y];
        else
            return 0;
    }

    /**
     * Erases the value of the cell at position (x, y).
     */
    public void erase(int x, int y) {
        board[x][y] = 0;
    }

    /**
     * Determines if this board is a legal Sudoku board.
     *
     * This method returns false if the "appears exactly once" rule
     * is violated. Otherwise it returns true.
     */
    public boolean isLegal() {
        //check row
        return checkRow(board,N,M) && checkColumn(board,N,M) && checkSub();
    }

    private boolean checkRow(Integer[][] sourceArray, int N, int M) {
        int frequency = -1;
        for (int i = 0; i < N*M; ++i) {
            List<Integer> row = Arrays.asList(sourceArray[i]);
            for (int j = 0; j < N*M; ++j) {
                frequency = Collections.frequency(row,row.get(j));
            }
            if (frequency > 1)
                return false;
        }
        return true;
    }
    private boolean checkColumn(Integer[][] sourceArray, int N, int M) {
        int frequency = -1;
        for (int i = 0; i < N*M; ++i) {
            List<Integer> column = getColumn(sourceArray, i);
            for (int j = 0; j < N*M; ++j) {
                frequency = Collections.frequency(column,column.get(j));
            }
            if (frequency > 1)
                return false;
        }
        return true;
    }

    private List<Integer> getRow(int i) {
        return Arrays.asList(board[i]);
    }

    private List<Integer> getColumn(Integer[][] sourceArray, int columnOfInterest) {
        List<Integer> colArray = new ArrayList<>();
        for(int i = 0; i < N*M; i++) {
            colArray.add(sourceArray[i][columnOfInterest]);
        }
        return colArray;
    }

    private boolean checkSub() {
        boolean isLegal = true;
        for (int i = 0; i < N*M; i+=N){
            for (int j = 0; j < N*M; j +=M){
                isLegal = checkRow(board,i,j) && checkColumn(board,i,j);
            }
            if (!isLegal)
                return false;
        }
        return true;
    }
    /**
     * Determines if the board is solved.
     * This is the case when all the cells are filled in, and the board is legal.
     */
    public boolean isSolved() {
        if(!this.isLegal())
            return false;
        else{
            for (int i = 0; i < N*M; i+=N){
                for (int j = 0; j < N*M; j +=M){
                    if(this.get(i,j) == 0)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the values that can be potentially placed
     * into cell (x,y). These values are found out by
     * checking the currently existing values on row x,
     * column y, and the subgrid that contains (x,y).
     * If the cell is already filled in, returns empty list.
     */
    public List<Integer> getCandidateValuesFor(int x, int y) {
        if(board[x][y] != 0)
            return new ArrayList<>();
        else{
            List<Integer> candidateValues = new ArrayList<>();
            Integer[] acceptedValues = {1,2,3,4,5,6,7,8,9};
            //TODO
            for (int i = 0; i < N*M; i+=N){
                for (int j = 0; j < N*M; j +=M){
                    if(acceptedValues[j] == getRow(i).get(j))
                        acceptedValues[j] = 0;
                }
            }
            candidateValues
            return candidateValues;
        }
    }


    /**
     * toString() method provided for your convenience.
     * YOU DO NOT NEED TO TOUCH OR TEST THE CODE BELOW.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < N * M; row++) {
            appendRowSeparator(builder);
            appendCellValues(builder, row);
        }
        appendRowSeparator(builder);
        return builder.toString();
    }

    private void appendCellValues(StringBuilder builder, int row) {
        for (int col = 0; col < N * M; col++) {
            int value = get(row, col);
            if (value == 0)
                builder.append(String.format("|  "));
            else
                builder.append(String.format("|%2d", value));
        }
        builder.append("|\n");
    }

    private void appendRowSeparator(StringBuilder builder) {
        for (int j = 0; j < N * M; j++) {
            builder.append("---");
        }
        builder.append("\n");
    }
}
