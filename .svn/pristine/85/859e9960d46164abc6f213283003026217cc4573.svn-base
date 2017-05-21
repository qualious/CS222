import org.junit.jupiter.api.Test;
import sudoku.SudokuBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {
    @Test
    void testConstructor() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertEquals(2, board.getN());
        assertEquals(3, board.getM());
    }

    @Test
    void testConstructorNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SudokuBoard(-1,-3);
        });
    }

    @Test
    void testConstructorNonPositive2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SudokuBoard(1,-3);
        });
    }

    @Test
    void testConstructorNonPositive3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SudokuBoard(-1,3);
        });
    }

    @Test
    void testPlaceNegativeNumber() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            board.place(-5,1,1);
        });
    }

    @Test
    void testPlaceXOutOfBounds() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            board.place(5,12,1);
        });
    }

    @Test
    void testPlaceXandYOutOfBounds() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            board.place(5,12,32);
        });
    }

    @Test
    void testPlaceYOutOfBounds() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            board.place(5,1,17);
        });
    }


    @Test
    void testPlaceAlreadyExists() {
        SudokuBoard board = new SudokuBoard(2, 3);
        board.place(5,1,1);
        assertThrows(RuntimeException.class, () -> {
            board.place(5,1,1);
        });
    }

    @Test
    void testGet() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertEquals(0, board.get(1,1));
    }

    @Test
    void testGet2() {
        SudokuBoard board = new SudokuBoard(2, 3);
        board.place(5,1,1);
        assertEquals(5, board.get(1,1));
    }

    @Test
    void testErase() {
        SudokuBoard board = new SudokuBoard(2, 3);

        board.place(5,1,1);
        assertEquals(5, board.get(1,1));

        board.erase(1,1);
        assertEquals(0, board.get(1,1));
    }

    @Test
    void testIsLegal1() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertTrue(board.isLegal());
    }

    @Test
    void testIsLegalTwiceInColumn() {
        SudokuBoard board = new SudokuBoard(3, 3);
        board.place(5,1,1);
        board.place(5,1,2);
        assertFalse(board.isLegal());
    }

    @Test
    void testIsLegalTwiceInRow() {
        SudokuBoard board = new SudokuBoard(3, 3);
        board.place(5,1,1);
        board.place(5,2,1);
        assertFalse(board.isLegal());
    }

    @Test
    void testIsLegalTwiceInSubGrid() {
        SudokuBoard board = new SudokuBoard(2, 3);
        board.place(5,0,0);
        board.place(5,1,2);
        assertFalse(board.isLegal());
    }

    @Test
    void testIsLegalTrue() {
        SudokuBoard board = new SudokuBoard(2, 3);
        board.place(1, 0, 1);
        board.place(3, 0, 3);
        board.place(2, 1, 0);
        board.place(6, 1, 1);
        board.place(3, 2, 0);
        board.place(6, 2, 3);
        board.place(1, 2, 5);
        board.place(4, 3, 1);
        board.place(5, 4, 0);
        board.place(4, 4, 3);
        board.place(6, 5, 2);
        board.place(1, 5, 3);

        assertTrue(board.isLegal());
    }

    @Test
    void testIsSolvedEmpty() {
        SudokuBoard board = new SudokuBoard(2, 3);
        assertFalse(board.isSolved());
    }

    @Test
    void testIsSolvedNotComplete() {
        SudokuBoard board = new SudokuBoard(2, 3);
        board.place(5,1,1);
        board.place(8,2,1);
        assertFalse(board.isSolved());
    }

    @Test
    void testIsSolvedTrue() {
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
        board.place(3, 3, 3);

        assertTrue(board.isSolved());
    }

    @Test
    void testGetCandidateValues(){
        SudokuBoard board = new SudokuBoard(2, 2);

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
        board.place(3, 3, 3);

        List<Integer> candidateValues= board.getCandidateValuesFor(0,0);
        assertTrue(candidateValues.get(0).equals(1));
    }

    @Test
    void testGetCandidateValuesList(){
        SudokuBoard board = new SudokuBoard(2, 2);

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
        board.place(3, 3, 3);

        List<Integer> expectedCandidateValues = new ArrayList<>();
        expectedCandidateValues.add(0,1);
        expectedCandidateValues.add(1,2);
        expectedCandidateValues.add(2,3);
        expectedCandidateValues.add(3,4);

        List<Integer> candidateValues= board.getCandidateValuesFor(0,0);
        assertTrue(candidateValues.equals(expectedCandidateValues));
    }

    @Test
    void testGetCandidateValuesFilled(){
        SudokuBoard board = new SudokuBoard(2, 2);
        board.place(1, 0, 0);
        assertEquals(0,board.getCandidateValuesFor(0,0));
    }

    public static SudokuBoard get2by3Board() {
        // Construct the following board:
        //       0  1  2| 3  4  5
        //     ---------+---------
        // 0:  |  | 1|  | 3|  |  |
        // 1:  | 2| 6|  |  |  |  |
        //     ---------+---------
        // 2:  | 3|  |  | 6|  | 1|
        // 3:  |  | 4|  |  |  |  |
        //     ---------+---------
        // 4:  | 5|  |  | 4|  |  |
        // 5:  |  |  | 6| 1|  |  |
        //     ---------+---------
        SudokuBoard board = new SudokuBoard(2, 3);

        board.place(1, 0, 1);
        board.place(3, 0, 3);

        board.place(2, 1, 0);
        board.place(6, 1, 1);

        board.place(3, 2, 0);
        board.place(6, 2, 3);
        board.place(1, 2, 5);

        board.place(4, 3, 1);

        board.place(5, 4, 0);
        board.place(4, 4, 3);

        board.place(6, 5, 2);
        board.place(1, 5, 3);
        return board;
    }

    public static SudokuBoard getSolved2by2Board() {
        // Construct the following board:
        //       0  1| 2  3
        //     ------+-----
        // 0:  | 1| 2| 3| 4|
        // 1:  | 3| 4| 1| 2|
        //     ------+------
        // 2:  | 2| 3| 4| 1|
        // 3:  | 4| 1| 2| 3|
        //     ------------

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
        board.place(3, 3, 3);

        return board;
    }
}
