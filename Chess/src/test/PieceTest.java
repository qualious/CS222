import chess.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class PieceTest {
    protected abstract Piece getPiece();
    protected abstract void testGetSymbol();

    @Test
    public final void testSetPosition(){
        Piece piece = getPiece();
        piece.setPosition(3,4);
        assertEquals(3,piece.getX());
        assertEquals(4,piece.getY());
    }

    @Test
    public final void testClone(){
        Piece piece = getPiece();
        piece.setPosition(3,4);
        Piece piece2 = piece.clone();

        assertEquals(3,piece2.getX());
        assertEquals(4,piece2.getY());

        piece2.setPosition(4,5);

        assertEquals(4,piece2.getX());
        assertEquals(5,piece2.getY());

        assertEquals(3,piece.getX());
        assertEquals(4,piece.getY());
    }
}
