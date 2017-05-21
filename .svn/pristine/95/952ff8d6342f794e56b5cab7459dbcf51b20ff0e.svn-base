import geography.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Ignore
public class QuerierTest {
    private static Country turkey;
    private static Querier querier;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        turkey = JSONReader.parseCountryFrom("data" + File.separator + "turkey.json");
        querier = new Querier(turkey);
    }

    @Test
    void testRegionCount() {
        assertEquals(7, turkey.getRegions().size());
    }

    @Test
    void testCountryName() {
        assertEquals("TÜRKİYE", turkey.getName());
    }

    @Test
    void testPopulation() {
        assertEquals(78771053, querier.getPopulation());
    }

    @Test
    void testMostPopulatedProvince() {
        Province p = querier.getMostPopulatedProvince();
        assertEquals("İSTANBUL", p.getName());
        assertEquals(34, p.getPlateID());
        assertEquals("MARMARA", p.getRegion().getName());
        assertEquals(14657434, p.getPopulation());
    }

    @Test
    void testLeastPopulatedProvince() {
        Province p = querier.getLeastPopulatedProvince();
        assertEquals("BAYBURT", p.getName());
        assertEquals(69, p.getPlateID());
        assertEquals("KARADENİZ", p.getRegion().getName());
        assertEquals(78550, p.getPopulation());
    }

    @Test
    void testMostPopulatedRegion() {
        Region r = querier.getMostPopulatedRegion();
        assertEquals("MARMARA", r.getName());
    }

    @Test
    void testLeastPopulatedRegion() {
        Region r = querier.getLeastPopulatedRegion();
        assertEquals("DOĞU ANADOLU", r.getName());
    }

    @Test
    void testNumTowns() {
        assertEquals(917, querier.getNumTowns());
    }

    @Test
    void testNumProvinces() {
        assertEquals(81, querier.getNumProvinces());
    }

    @Test
    void testAlphabeticalOrder() {
        List<Province> provinces = querier.getProvincesInAlphabeticalOrder();
        assertEquals("ADANA", provinces.get(0).getName());
        assertEquals("ZONGULDAK", provinces.get(provinces.size() - 1).getName());
    }

    @Test
    void testGetProvinceByName1() {
        Province p = querier.getProvinceByName("SAMSUN");
        assertEquals("SAMSUN", p.getName());
        assertEquals(55, p.getPlateID());
        assertEquals("KARADENİZ", p.getRegion().getName());
        assertEquals(1279884, p.getPopulation());
    }

    @Test
    void testGetProvinceByName2() {
        Province p = querier.getProvinceByName("KARS");
        assertEquals("KARS", p.getName());
        assertEquals(36, p.getPlateID());
        assertEquals("DOĞU ANADOLU", p.getRegion().getName());
        assertEquals(292660, p.getPopulation());
    }

    @Test
    void testGetProvinceByPlateID1() {
        Province p = querier.getProvinceByPlateID(55);
        assertEquals("SAMSUN", p.getName());
        assertEquals(55, p.getPlateID());
        assertEquals("KARADENİZ", p.getRegion().getName());
        assertEquals(1279884, p.getPopulation());
    }

    @Test
    void testGetProvinceByPlateID2() {
        Province p = querier.getProvinceByPlateID(36);
        assertEquals("KARS", p.getName());
        assertEquals(36, p.getPlateID());
        assertEquals("DOĞU ANADOLU", p.getRegion().getName());
        assertEquals(292660, p.getPopulation());
    }
}
