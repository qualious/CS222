import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LargeMapTest {
    private static List<Square> squaresOnLargeMap;

    @BeforeClass
    public static void loadMap() throws IOException {
        squaresOnLargeMap = Map.fromFile("data/sample-map_80-200.txt").getSquares();
    }

    @Test
    public void testNumSquaresOnLargeMap() throws IOException {
        assertEquals(9, squaresOnLargeMap.size());
    }

    @Test
    public void testSquareOnLargeMap_20_130_40() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(20, 130, 40)));
    }

    @Test
    public void testSquareOnLargeMap_20_130_50() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(20, 130, 50)));
    }

    @Test
    public void testSquareOnLargeMap_40_150_20() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(40, 150, 20)));
    }

    @Test
    public void testSquareOnLargeMap_50_150_10() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(50, 150, 10)));
    }

    @Test
    public void testSquareOnLargeMap_50_150_20() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(50, 150, 20)));
    }

    @Test
    public void testSquareOnLargeMap_50_160_10() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(50, 160, 10)));
    }

    @Test
    public void testSquareOnLargeMap_60_150_10() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(60, 150, 10)));
    }

    @Test
    public void testSquareOnLargeMap_60_160_10() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(60, 160, 10)));
    }

    @Test
    public void testSquareOnLargeMap_60_170_10() throws IOException {
        assertTrue(squaresOnLargeMap.contains(new Square(60, 170, 10)));
    }
}
