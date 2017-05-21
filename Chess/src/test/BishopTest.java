import chess.Bishop;
import chess.Board;
import chess.Piece;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTest { //extends PieceTest {

//    @Override
//    protected Piece getPiece() {
//        return new Bishop();
//    }


    @Test
    void testCanAttack1() {
        Bishop b = new Bishop();
        b.setPosition(3,3);
        int x = b.getX();
        int y = b.getY();
        assertFalse(b.canAttack(x,y));
    }

    @Test
    void testCanAttack2() {
        Board board = new Board();
        Bishop b = new Bishop();
        b.setPosition(3,3);
        int x = b.getX()+1;
        int y = b.getY()+1;
        if(board.isAvailable(x,y))
            assertTrue(b.canAttack(x,y));
        else
            assertFalse(b.canAttack(x,y));
    }

    @Test
    void testCanAttack3() {
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(3,3);
        int x = b.getX()-1;
        int y = b.getY()+1;
        if(board.isAvailable(x,y))
            assertTrue(b.canAttack(x,y));
        else
            assertFalse(b.canAttack(x,y));
    }

    @Test
    void testCanAttack4() {
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(3,3);
        int x = b.getX()+1;
        int y = b.getY()-1;
        if(board.isAvailable(x,y))
            assertTrue(b.canAttack(x,y));
        else
            assertFalse(b.canAttack(x,y));
    }

    @Test
    void testCanAttack5() {
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(3,3);
        int x = b.getX()-1;
        int y = b.getY()-1;
        if(board.isAvailable(x,y))
            assertTrue(b.canAttack(x,y));
        else
            assertFalse(b.canAttack(x,y));
    }


    @Test
    void testCanAttack6() {
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(3,3);
        int x = b.getX()-3;
        int y = b.getY()-3;
        if(board.isAvailable(x,y))
            assertTrue(b.canAttack(x,y));
        else
            assertFalse(b.canAttack(x,y));
    }

    @Test
    void testCanAttackTopLeftCornerTrue(){
        Bishop b = new Bishop();
        b.setPosition(0,0); //top left corner
        int x = b.getX()+1;
        int y = b.getY()+1;
        assertTrue(b.canAttack(x,y));
    }

    @Test
    void  testCanAttackTopRightCornerTrue(){
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(board.getDimension()-1,0); //top right corner
        int x = b.getX()-1;
        int y = b.getY()+1;
        assertTrue(b.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomLeftCornerTrue(){
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(0,board.getDimension()-1); //bottom left corner
        int x = b.getX()+1;
        int y = b.getY()-1;
        assertTrue(b.canAttack(x,y));
    }

    @Test
    void testCanAttackBottomRightCornerTrue(){
        Bishop b = new Bishop();
        Board board = new Board();
        b.setPosition(board.getDimension()-1,board.getDimension()-1); //bottom right corner
        int x = b.getX()-1;
        int y = b.getY()-1;
        assertTrue(b.canAttack(x,y));
    }

    @Test
    public void testGetSymbol() {
        Bishop b = new Bishop();
        assertSame("B", b.getSymbol());
    }

}
