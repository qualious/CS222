package sudoku;

public class Main {
    public static void main(String[] args) {
        SudokuBoard board = getSudokuBoard();

        System.out.println("Initial board: ");
        System.out.println(board);

        SudokuSolver solver = new SudokuSolver();
        solver.solve(board);

        System.out.println("Solution:");
        System.out.println(board);
    }

    private static SudokuBoard getSudokuBoard() {
        // Construct the following board:
        //       0  1| 2  3
        //     ------+-----
        // 0:  | 1|  | 3| 4|
        // 1:  | 3| 4|  | 2|
        //     ------+------
        // 2:  | 2|  |  | 1|
        // 3:  | 4| 1|  |  |
        //     ------------
        SudokuBoard board = new SudokuBoard(2,2);

        board.place(1, 0, 0);
        board.place(3, 0, 2);
        board.place(4, 0, 3);

        board.place(3, 1, 0);
        board.place(4, 1, 1);
        board.place(2, 1, 3);

        board.place(2, 2, 0);
        board.place(1, 2, 3);

        board.place(4, 3, 0);
        board.place(1, 3, 1);

        return board;
    }
}
