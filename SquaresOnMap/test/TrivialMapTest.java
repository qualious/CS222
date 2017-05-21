import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrivialMapTest {
    private static List<Square> squares;

    @BeforeClass
    public static void loadMap() throws IOException {
        squares = Map.fromFile("data/trivial-map.txt").getSquares();
    }

    @Test
    public void testNumSquaresOnTrivialMap() throws IOException {
        assertEquals(1, squares.size());
    }

    @Test
    public void testSquareOnTrivialMap_2_3_3() throws IOException {
        assertTrue(squares.contains(new Square(2, 2, 3)));
    }
}
