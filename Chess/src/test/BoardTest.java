import chess.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void testBoardConstructorZeroInput(){
        Board b = new Board();
        assertEquals(8, b.getDimension());
    }

    @Test
    void testBoardConstructorOneInput(){
        Board b = new Board(5);
        assertEquals(5, b.getDimension());
    }

    @Test
    void testBoardConstructorWrongInput(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(-1);
        });
    }

    @Test
    void testBoardConstructorWrongInput2(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(0);
        });

    }

    @Test
    void testGetPieceAt(){
        Board b = new Board();
        assertNull(b.getPieceAt(0,0));
        assertNull(b.getPieceAt(0,-1));
        assertNull(b.getPieceAt(-1,0));
    }

    @Test
    void testPut(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,2,3);
        assertEquals(bishop, b.getPieceAt(2,3));
    }

    @Test
    void testPut1(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,9,3);
        assertNull(b.getPieceAt(9,3));
    }

    @Test
    void testPut2(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,0,15);
        assertNull(b.getPieceAt(0,15));
    }

    @Test
    void testPut3(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,0,0);
        Bishop bishop2 = new Bishop();
        assertThrows(AlreadyOccupiedException.class, () -> {
            b.put(bishop2,0,0);
        });
    }

    @Test
    void testGetPieces(){
        Board b = new Board();
        List<Piece> pieces = b.getPieces();
        assertEquals(0,pieces.size());
    }

    @Test
    void testGetPieces1(){
        Board b = new Board();
        b.put(new Bishop(),0,1);
        b.put(new Bishop(),5,7);
        b.put(new Bishop(),2,1);
        List<Piece> pieces = b.getPieces();
        assertEquals(3,pieces.size());
    }

    @Test
    void testIsValid(){
        Board b = new Board();
        assertTrue(b.isValid());
    }

    @Test
    void testIsValid1(){
        Board b = new Board();
        b.put(new Bishop(),0,5);
        assertTrue(b.isValid());
    }

    @Test
    void testIsValid2(){
        Board b = new Board();
        b.put(new Bishop(),0,5);
        b.put(new Bishop(), 1,6);
        assertFalse(b.isValid());
    }

    @Test
    void testIsValid3(){
        Board b = new Board();
        b.put(new Queen(),0,0);
        b.put(new Queen(),1,7);
        assertTrue(b.isValid());
    }

    @Test
    void testIsValid4(){
        Board b = new Board();
        b.put(new Queen(),0,0);
        b.put(new Queen(),7,7);
        assertFalse(b.isValid());
    }

    @Test
    void testIsValid5(){
        Board b = new Board();
        b.put(new Queen(),0,3);
        b.put(new Queen(),1,6);
        b.put(new Queen(),2,2);
        b.put(new Queen(),3,7);
        b.put(new Queen(),4,1);
        b.put(new Queen(),5,4);
        b.put(new Queen(),6,0);
        b.put(new Queen(),7,5);
        assertTrue(b.isValid());
    }

    @Test
    void testClone(){
        Board b = new Board();
        Board b2 = b.clone();
        assertEquals(b, b2);
    }

    @Test
    void testEquals(){
        Board b = new Board();
        Board b2 = new Board();
        assertTrue(b.equals(b2));
    }

    @Test
    void testEquals1(){
        Board b = new Board();
        Board b2 = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,0,0);
        b2.put(bishop,0,0);
        assertTrue(b.equals(b2));
    }

    @Test
    void testEquals2(){
        Board b = new Board();
        Board b2 = new Board();
        b.put(new Bishop(),0,0);
        b2.put(new Bishop(),0,1);
        assertFalse(b.equals(b2));
    }

    @Test
    void testIsAvailable(){
        Board b = new Board();
        b.put(new Bishop(),0,0);
        assertFalse(b.isAvailable(0,0));
    }

    @Test
    void testIsAvailable1(){
        Board b = new Board();
        assertTrue(b.isAvailable(0,0));
    }

    @Test
    void testIsAvailable2(){
        Board b = new Board();
        b.put(new Bishop(),0,0);
        assertTrue(b.isAvailable(2,1));
    }

    @Test
    void testGetLastPiece(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,0,0);
        assertTrue(b.getLastPiece().equals(bishop));
    }

    @Test
    void testGetLastPiece1(){
        Board b = new Board();
        b.put(new King(),0,0);
        assertFalse(b.getLastPiece().equals(new Bishop()));
    }

    @Test
    void testGetLastPiece2(){
        Board b = new Board();
        assertNull(b.getLastPiece());
    }

    @Test
    void testRemoveLastPiece(){
        Board b = new Board();
        Bishop bishop = new Bishop();
        b.put(bishop,0,0);
        b.put(new King(),0,1);
        b.removeLastPiece();
        assertTrue(b.getLastPiece().equals(bishop));
    }

    @Test
    void testRemoveLastPiece1(){
        Board b = new Board();
        b.put(new King(),0,0);
        b.removeLastPiece();
        assertNull(b.getLastPiece());
    }

    @Test
    void testRemoveLastPiece3(){
        Board b = new Board();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            b.removeLastPiece();
        });
    }

    @Test
    void testIsCovered(){
        Board b = new Board();
        assertFalse(b.isCovered());
    }

    @Test
    void testIsCovered1(){
        Board b = new Board(2);     //(0,0),(0,1),(1,0),(1,1)
        b.put(new King(),0,0);
        b.put(new King(),0,1);
        b.put(new King(),1,0);
        b.put(new King(),1,1);
        assertTrue(b.isCovered());
    }

    @Test
    void testPrint(){
        Board b = new Board(1);
        String s = "+-+\n";
        s       += "| |\n";
        s       += "+-+\n";
        assertEquals(s, b.toString());
    }

    @Test
    void testPrint1(){
        Board b = new Board(1);
        b.put(new Queen(),0,0);
        String s = "+-+\n";
        s       += "|Q|\n";
        s       += "+-+\n";
        assertEquals(s, b.toString());
    }

}
