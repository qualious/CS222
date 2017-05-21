import chess.Board;
import chess.DominationSolver;
import chess.Queen;
import chess.Rook;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DominationSolverTest {

    @Test
    void testSolve() {
        DominationSolver dominationSolver = new DominationSolver();
        Board board = dominationSolver.solve(5, new Queen());
        assertSame(3,board.getPieces().size());
    }

    @Test
    void testSolve1() {
        DominationSolver dominationSolver = new DominationSolver();
        Board board = dominationSolver.solve(5, new Rook());
        assertSame(5,board.getPieces().size());
    }

    @Test
    void testSolveBadArgument() {
        DominationSolver dominationSolver = new DominationSolver();
        assertThrows(IllegalArgumentException.class, () -> {
            Board board = dominationSolver.solve(-1, new Rook());
        });
    }

}