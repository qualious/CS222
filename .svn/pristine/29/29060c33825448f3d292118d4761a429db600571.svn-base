import chess.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReducerTest {
    @Test
    void testReducerConstructor() {
        Board b = new Board();
        Reducer reducer = new Reducer(b);
        assertEquals(b,reducer.getBoard());
    }

    @Test
    void testReduceOnce() {
        Board board = new Board();
        board.put(new Queen(),1,1);
        Reducer reducer = new Reducer(board);
        reducer.reduceOnce();
        assertEquals(1,board.getPieces().size());
    }

    @Test
    void testReduceOnce1() {
        Board b = new Board();
        b.put(new Bishop(), 0,0);
        b.put(new Queen(), 3,3);
        b.put(new Queen(), 6,6);

        Reducer reducer = new Reducer(b);
        reducer.reduceOnce();
        reducer.reduceOnce();

        assertEquals(18,reducer.getAccummulatedScore());
        assertEquals(1, reducer.getBoard().getPieces().size());
    }

}
