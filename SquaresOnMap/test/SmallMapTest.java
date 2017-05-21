import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmallMapTest {
    private static List<Square> squaresOnSmallMap;

    @BeforeClass
    public static void loadMap() throws IOException {
        squaresOnSmallMap = Map.fromFile("data/sample-map.txt").getSquares();
    }

    @Test
    public void testNumSquaresOnSmallMap() throws IOException {
        assertEquals(4, squaresOnSmallMap.size());
    }

    @Test
    public void testSquareOnSmallMap_1_3_5() throws IOException {
        assertTrue(squaresOnSmallMap.contains(new Square(1, 3, 5)));
    }

    @Test
    public void testSquareOnSmallMap_1_3_8() throws IOException {
        assertTrue(squaresOnSmallMap.contains(new Square(1, 3, 8)));
    }

    @Test
    public void testSquareOnSmallMap_6_8_3() throws IOException {
        assertTrue(squaresOnSmallMap.contains(new Square(6, 8, 3)));
    }

    @Test
    public void testSquareOnSmallMap_3_8_3() throws IOException {
        assertTrue(squaresOnSmallMap.contains(new Square(3, 8, 3)));
    }
}
