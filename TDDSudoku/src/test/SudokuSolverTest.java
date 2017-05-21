import org.junit.jupiter.api.Test;
import sudoku.SudokuBoard;
import sudoku.SudokuSolver;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuSolverTest {
    @Test
    void testSolve1() {
        SudokuSolver solver = new SudokuSolver();
        SudokuBoard board = new SudokuBoard(2, 2);

        board.place(1, 0, 0);
        board.place(2, 0, 1);
        board.place(3, 0, 2);
        board.place(4, 0, 3);

        board.place(3, 1, 0);
        board.place(4, 1, 1);
        board.place(1, 1, 2);
        board.place(2, 1, 3);

        board.place(2, 2, 0);
        board.place(3, 2, 1);
        board.place(4, 2, 2);
        board.place(1, 2, 3);

        board.place(4, 3, 0);
        board.place(1, 3, 1);
        board.place(2, 3, 2);
        //board.place(3, 3, 3);

        assertSame(3,solver.solve(board).get(3,3));
    }

    @Test
    void testSolve2() {
        SudokuSolver solver = new SudokuSolver();
        SudokuBoard board = new SudokuBoard(2, 2);

        //board.place(1, 0, 0);
        board.place(2, 0, 1);
        board.place(3, 0, 2);
        board.place(4, 0, 3);

        board.place(3, 1, 0);
        board.place(4, 1, 1);
        board.place(1, 1, 2);
        board.place(2, 1, 3);

        board.place(2, 2, 0);
        board.place(3, 2, 1);
        board.place(4, 2, 2);
        board.place(1, 2, 3);

        board.place(4, 3, 0);
        board.place(1, 3, 1);
        board.place(2, 3, 2);
        //board.place(3, 3, 3);

        assertSame(1,solver.solve(board).get(0,0));
    }
}
