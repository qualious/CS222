package geography;

import org.json.simple.*;

import java.io.*;
import java.util.*;

public class JSONReader {
    private static Country country;
    private static JSONArray towns;
    private static JSONArray roads;
    private static JSONArray populations;
    private static List<Region> regions;
    private static Querier querier;

    public static Country parseCountryFrom(String fileName) {
        try {
            getDataFromFile(fileName);
            addRegions();
            regions = country.getRegions();
            for (Object town : towns) {
                JSONObject thisObject = (JSONObject) town;
                String regionName = thisObject.get("region").toString();
                Town thisTown = createTown(thisObject);
                Province thisProvince = createProvince(thisObject);
                addDataToCountry(regionName,thisTown,thisProvince);
            }
            setRoads();
            return country;
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static void getDataFromFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
        country = new Country((String) jsonObject.get("name"));
        querier = new Querier(country);
        towns = (JSONArray) jsonObject.get("towns");
        roads = (JSONArray) jsonObject.get("roads");
        populations = (JSONArray) jsonObject.get("populations");
    }

    private static void addRegions(){
        for (Object thisTown : towns) {
            JSONObject thisObject = (JSONObject) thisTown;
            String regionName = thisObject.get("region").toString();
            if(!country.getRegions().contains(new Region(regionName)))
                country.add(new Region(regionName));
        }
    }

    private static Town createTown(JSONObject thisObject){
        String townName = thisObject.get("town").toString();
        return new Town(townName);
    }

    private static Province createProvince(JSONObject thisObject){
        String provinceName = thisObject.get("province").toString();
        int plateNo = ((Long)thisObject.get("plateNo")).intValue();
        return new Province(provinceName,plateNo);
    }

    private static void addDataToCountry(String regionName, Town thisTown, Province thisProvince){
        for (Region thisRegion: regions) {
            if (thisRegion.getName().equals(regionName)) {
                List<Province> provinces = thisRegion.getProvinces();
                if(provinces.contains(thisProvince))
                    provinces.get(provinces.indexOf(thisProvince)).add(thisTown);
                else {
                    thisTown.setProvince(thisProvince);
                    thisProvince.add(thisTown);
                    setPopulation(thisProvince);
                    thisProvince.setRegion(thisRegion);
                    thisRegion.add(thisProvince);
                }
            }
        }
    }

    private static void setPopulation(Province thisProvince){
        for (Object thisPopulation: populations) {
            String populationName = ((JSONObject) thisPopulation).get("province").toString();
            if (thisProvince.getName().equals(populationName)) {
                int provincePopulation = Integer.parseInt(((JSONObject) thisPopulation).get("pop").toString());
                thisProvince.setPopulation(provincePopulation);
            }
        }
    }

    private static void setRoads(){
        Province provinceA;
        Province provinceB;
        int distance;
        for (Object road : roads){
            String nameOfProvinceA = ((JSONObject) road).get("A").toString();
            provinceA = querier.getProvinceByName(nameOfProvinceA);
            String nameOfProvinceB = ((JSONObject) road).get("B").toString();
            provinceB = querier.getProvinceByName(nameOfProvinceB);
            distance = Integer.parseInt(((JSONObject) road).get("distance").toString());
            provinceA.add(new Road(provinceA, provinceB, distance));
            provinceB.add(new Road(provinceB, provinceA, distance));
        }
    }
}