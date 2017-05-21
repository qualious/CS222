import chess.Board;
import chess.Piece;
import chess.Queen;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest extends PieceTest {

    @Override
    protected Piece getPiece() {
        return new Queen();
    }

    @Test
    void testCanAttack1() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX();
        int y = q.getY();
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack2() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+1;
        int y = q.getY()+1;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttack3() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-1;
        int y = q.getY()+1;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttack4() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+1;
        int y = q.getY()-1;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttack5() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-1;
        int y = q.getY()-1;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttack6() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-3;
        int y = q.getY()-3;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttack7() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+1;
        int y = q.getY()+2;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack8() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+2;
        int y = q.getY()+1;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack9() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-1;
        int y = q.getY()-2;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack10() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-2;
        int y = q.getY()-1;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack11() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+1;
        int y = q.getY()-2;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack12() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()+2;
        int y = q.getY()-1;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack13() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-1;
        int y = q.getY()+2;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack14() {
        Queen q = new Queen();
        q.setPosition(3,3);
        int x = q.getX()-2;
        int y = q.getY()+1;
        assertFalse(q.canAttack(x,y));
    }

    @Test
    void testCanAttack15() {
        Queen q = new Queen();
        q.setPosition(6,6);
        int x = q.getX()+3;
        int y = q.getY()+3;
        assertTrue(q.canAttack(x,y));
    }


    @Test
    void testCanAttackTopLeftCornerTrue(){
        Queen q = new Queen();
        q.setPosition(0,0); //top left corner
        int x = q.getX()+3;
        int y = q.getY()+3;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void  testCanAttackTopRightCornerTrue(){
        Queen q = new Queen();
        Board board = new Board();
        q.setPosition(board.getDimension()-1,0); //top right corner
        int x = q.getX()-3;
        int y = q.getY()+3;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomLeftCornerTrue(){
        Queen q = new Queen();
        Board board = new Board();
        q.setPosition(0,board.getDimension()-1); //bottom left corner
        int x = q.getX()+3;
        int y = q.getY()-3;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomRightCornerTrue(){
        Queen q = new Queen();
        Board board = new Board();
        q.setPosition(board.getDimension()-1,board.getDimension()-1); //bottom right corner
        int x = q.getX()-3;
        int y = q.getY()-3;
        assertTrue(q.canAttack(x,y));
    }

    @Test
    public void testGetSymbol() {
        Queen q = new Queen();
        assertSame("Q", q.getSymbol());
    }
}
