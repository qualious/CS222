import chess.Board;
import chess.Knight;
import chess.Piece;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest extends PieceTest {

    @Override
    protected Piece getPiece() {
        return new Knight();
    }


    @Test
    void testCanAttack1() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX();
        int y = kn.getY();
        assertFalse(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack2() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()+1;
        int y = kn.getY()+2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack3() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()+2;
        int y = kn.getY()+1;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack4() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()-1;
        int y = kn.getY()-2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack5() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()-2;
        int y = kn.getY()-1;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack6() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()+1;
        int y = kn.getY()-2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack7() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()+2;
        int y = kn.getY()-1;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack8() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()-1;
        int y = kn.getY()+2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack9() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()-2;
        int y = kn.getY()+1;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttack10() {
        Knight kn = new Knight();
        kn.setPosition(3,3);
        int x = kn.getX()-3;
        int y = kn.getY()-3;
        assertFalse(kn.canAttack(x,y));
    }

    @Test
    void testCanAttackTopLeftCornerTrue(){
        Knight kn = new Knight();
        kn.setPosition(0,0); //top left corner
        int x = kn.getX()+1;
        int y = kn.getY()+2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void  testCanAttackTopRightCornerTrue(){
        Knight kn = new Knight();
        Board board = new Board();
        kn.setPosition(board.getDimension()-1,0); //top right corner
        int x = kn.getX()-1;
        int y = kn.getY()+2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomLeftCornerTrue(){
        Knight kn = new Knight();
        Board board = new Board();
        kn.setPosition(0,board.getDimension()-1); //bottom left corner
        int x = kn.getX()+1;
        int y = kn.getY()-2;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomRightCornerTrue(){
        Knight kn = new Knight();
        Board board = new Board();
        kn.setPosition(board.getDimension()-1,board.getDimension()-1); //bottom right corner
        int x = kn.getX()-2;
        int y = kn.getY()-1;
        assertTrue(kn.canAttack(x,y));
    }

    @Test
    public void testGetSymbol() {
        Knight kn = new Knight();
        assertSame("N", kn.getSymbol());
    }
}
