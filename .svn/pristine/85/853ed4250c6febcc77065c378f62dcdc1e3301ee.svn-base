import chess.Board;
import chess.Piece;
import chess.Rook;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest extends PieceTest {

    @Override
    protected Piece getPiece() {
        return new Rook();
    }

    @Test
    void testCanAttack1() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX();
        int y = r.getY();
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack2() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()+1;
        int y = r.getY();
        assertTrue(r.canAttack(x,y));
    }

    @Test
    void testCanAttack3() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX();
        int y = r.getY()+1;
        assertTrue(r.canAttack(x,y));
    }

    @Test
    void testCanAttack4() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()-1;
        int y = r.getY()+1;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack5() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()+1;
        int y = r.getY()-1;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack6() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()-1;
        int y = r.getY()-1;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack7() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()-3;
        int y = r.getY()-3;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack8() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()-2;
        int y = r.getY()-3;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    void testCanAttack9() {
        Rook r = new Rook();
        r.setPosition(3,3);
        int x = r.getX()-2;
        int y = r.getY()-1;
        assertFalse(r.canAttack(x,y));
    }

    @Test
    public void testGetSymbol() {
        Rook r = new Rook();
        assertSame("R", r.getSymbol());
    }
}
