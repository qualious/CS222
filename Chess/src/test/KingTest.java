import chess.King;
import chess.Piece;
import chess.Board;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest extends PieceTest {

    @Override
    protected Piece getPiece() {
        return new King();
    }


    @Test
    void testCanAttack1() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX();
        int y = k.getY();
        assertFalse(k.canAttack(x,y));
    }

    @Test
    void testCanAttack2() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX()+1;
        int y = k.getY()+1;
        assertTrue(k.canAttack(x,y));
    }

    @Test
    void testCanAttack3() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX()-1;
        int y = k.getY()+1;
        assertTrue(k.canAttack(x,y));
    }

    @Test
    void testCanAttack4() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX()+1;
        int y = k.getY()-1;
        assertTrue(k.canAttack(x,y));
    }

    @Test
    void testCanAttack5() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX()-1;
        int y = k.getY()-1;
        assertTrue(k.canAttack(x,y));
    }

    @Test
    void testCanAttack6() {
        King k = new King();
        k.setPosition(3,3);
        int x = k.getX()-3;
        int y = k.getY()-3;
        assertFalse(k.canAttack(x,y));
    }

    @Test
    public void testGetSymbol() {
        King k = new King();
        assertSame("K", k.getSymbol());
    }

}
