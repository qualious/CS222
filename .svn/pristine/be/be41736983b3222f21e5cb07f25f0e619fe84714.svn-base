import geography.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RoutePlannerTest {
    private static Country turkey;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        turkey = JSONReader.parseCountryFrom("data" + File.separator + "turkey.json");
    }

    // A utility function
    private static Province getProvince(String regionName, String provinceName) {
        for (Region region: turkey.getRegions()) {
            if (region.getName().equals(regionName)) {
                for (Province province : region.getProvinces()) {
                    if (province.getName().equals(provinceName)) {
                        return province;
                    }
                }
            }
        }
        return null;
    }

    @Test
    void testSingleProvince1() {
        Province province = getProvince("MARMARA", "İSTANBUL");
        List<Road> roads = province.getOutgoingRoads();
        assertEquals(3, roads.size());
        for (Road road: roads) {
            if (road.getPortA().getName().equals("KIRKLARELİ")) {
                assertEquals(211, road.getLength());
            } else if (road.getPortA().getName().equals("TEKİRDAĞ")) {
                assertEquals(132, road.getLength());
            } else if (road.getPortA().getName().equals("KOCAELİ")) {
                assertEquals(111, road.getLength());
            }
        }
    }

    @Test
    void testSingleProvince2() {
        Province province = getProvince("KARADENİZ", "SAMSUN");
        List<Road> roads = province.getOutgoingRoads();
        assertEquals(5, roads.size());
        for (Road road: roads) {
            if (road.getPortA().getName().equals("AMASYA")) {
                assertEquals(131, road.getLength());
            } else if (road.getPortA().getName().equals("ÇORUM")) {
                assertEquals(172, road.getLength());
            } else if (road.getPortA().getName().equals("ORDU")) {
                assertEquals(152, road.getLength());
            } else if (road.getPortA().getName().equals("SİNOP")) {
                assertEquals(163, road.getLength());
            } else if (road.getPortA().getName().equals("TOKAT")) {
                assertEquals(230, road.getLength());
            }
        }
    }

    @Test
    void testShortestPathFromIstanbulToIstanbul() {
        RoutePlanner planner = new RoutePlanner(turkey);
        Province source = getProvince("MARMARA", "İSTANBUL");
        Province destination = getProvince("MARMARA", "İSTANBUL");
        List<Road> route = planner.getRoute(source, destination);
        assertTrue(route.isEmpty());
    }
    
    @Test
    void testShortestPathFromIstanbulToTekirdag() {
        RoutePlanner planner = new RoutePlanner(turkey);
        Province source = getProvince("MARMARA", "İSTANBUL");
        Province destination = getProvince("MARMARA", "TEKİRDAĞ");
        List<Road> route = planner.getRoute(source, destination);
        assertEquals(1, route.size());
        assertSame(destination, route.get(0).getPortB());
        assertEquals(132, route.get(0).getLength());
    }

    @Test
    void testShortestPathFromSamsunToTokat() {
        RoutePlanner planner = new RoutePlanner(turkey);
        Province source = getProvince("KARADENİZ", "SAMSUN");
        Province destination = getProvince("KARADENİZ", "TOKAT");
        List<Road> route = planner.getRoute(source, destination);
        assertEquals(1, route.size());
        assertSame(destination, route.get(0).getPortB());
        assertEquals(230, route.get(0).getLength());
    }

    @Test
    void testShortestPathFromIstanbulToBursa() {
        RoutePlanner planner = new RoutePlanner(turkey);
        Province source = getProvince("MARMARA", "İSTANBUL");
        Province destination = getProvince("MARMARA", "BURSA");
        List<Road> route = planner.getRoute(source, destination);
        assertEquals(2, route.size());
        assertEquals("KOCAELİ", route.get(0).getPortB().getName());
        assertEquals(111, route.get(0).getLength());
        assertSame(destination, route.get(1).getPortB());
        assertEquals(132, route.get(1).getLength());
    }

    @Test
    void testShortestPathFromEdirneToArdahan() {
        RoutePlanner planner = new RoutePlanner(turkey);
        Province source = getProvince("MARMARA", "EDİRNE");
        Province destination = getProvince("DOĞU ANADOLU", "ARDAHAN");
        List<Road> route = planner.getRoute(source, destination);
        assertEquals(15, route.size());

        assertEquals("TEKİRDAĞ", route.get(0).getPortB().getName());
        assertEquals(140, route.get(0).getLength());
        assertEquals("İSTANBUL", route.get(1).getPortB().getName());
        assertEquals(132, route.get(1).getLength());
        assertEquals("KOCAELİ", route.get(2).getPortB().getName());
        assertEquals(111, route.get(2).getLength());
        assertEquals("SAKARYA", route.get(3).getPortB().getName());
        assertEquals(37, route.get(3).getLength());
        assertEquals("BOLU", route.get(4).getPortB().getName());
        assertEquals(114, route.get(4).getLength());
        assertEquals("KARABÜK", route.get(5).getPortB().getName());
        assertEquals(134, route.get(5).getLength());
        assertEquals("KASTAMONU", route.get(6).getPortB().getName());
        assertEquals(114, route.get(6).getLength());
        assertEquals("SİNOP", route.get(7).getPortB().getName());
        assertEquals(183, route.get(7).getLength());
        assertEquals("SAMSUN", route.get(8).getPortB().getName());
        assertEquals(163, route.get(8).getLength());
        assertEquals("ORDU", route.get(9).getPortB().getName());
        assertEquals(152, route.get(9).getLength());
        assertEquals("GİRESUN", route.get(10).getPortB().getName());
        assertEquals(44, route.get(10).getLength());
        assertEquals("TRABZON", route.get(11).getPortB().getName());
        assertEquals(137, route.get(11).getLength());
        assertEquals("RİZE", route.get(12).getPortB().getName());
        assertEquals(75, route.get(12).getLength());
        assertEquals("ARTVİN", route.get(13).getPortB().getName());
        assertEquals(159, route.get(13).getLength());
        assertEquals("ARDAHAN", route.get(14).getPortB().getName());
        assertEquals(117, route.get(14).getLength());
    }
}
