package geography;

import java.text.Collator;
import java.util.*;

public class Querier {
    private List<Region> regions = new ArrayList<>();

    public Querier(Country country) {
        this.regions = country.getRegions();
    }

    public int getPopulation() {
        int sum = 0;
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            sum += provinces.stream().filter(o -> o.getPopulation() > 0).mapToInt(Province::getPopulation).sum();
        }
        return sum;
    }

    public Province getMostPopulatedProvince() {
        return getProvinceByPopulation(getMaxPopulation());
    }

    private int getMaxPopulation(){
        int max = Integer.MIN_VALUE;
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            OptionalInt possibleMaxFromThisList = provinces.stream().filter(o -> o.getPopulation() > 0)
                    .mapToInt(Province::getPopulation).max();
            if (possibleMaxFromThisList.isPresent())
                if (max < possibleMaxFromThisList.getAsInt())
                    max = possibleMaxFromThisList.getAsInt();
        }
        return max;
    }


    public Province getLeastPopulatedProvince() {
        return getProvinceByPopulation(getMinPopulationProvince());
    }

    private int getMinPopulationProvince(){
        int min = Integer.MAX_VALUE;
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            OptionalInt possibleMinFromThisList = provinces.stream().filter(o -> o.getPopulation() > 0)
                    .mapToInt(Province::getPopulation).min();
            if (possibleMinFromThisList.isPresent())
                if (min > possibleMinFromThisList.getAsInt())
                    min = possibleMinFromThisList.getAsInt();
        }
        return min;
    }

    private Province getProvinceByPopulation(int population){
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            for (Province province : provinces)
                if (province.getPopulation() == population)
                    return province;
        }
        return null;
    }

    public Region getMostPopulatedRegion() {
        return getRegionByPopulation(getMaxPopulationRegion());
    }

    private int getMaxPopulationRegion(){
        int max = 0;
        for (Region region : regions) {
            if (region.getPopulation() > max)
                max = region.getPopulation();
        }
        return max;
    }

    public Region getLeastPopulatedRegion() {
        return getRegionByPopulation(getMinPopulationRegion());
    }

    private int getMinPopulationRegion(){
        int min = Integer.MAX_VALUE;
        for (Region region : regions) {
            if (region.getPopulation() < min)
                min = region.getPopulation();
        }
        return min;
    }


    private Region getRegionByPopulation(int population){
        for (Region region : regions) {
            if (region.getPopulation() == population)
                return region;
        }
        return null;
    }


    public int getNumTowns() {
        int numberOfTowns = 0;
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            for (Province province : provinces) {
                List<Town> towns = province.getTowns();
                numberOfTowns += (long) towns.size();
            }
        }
        return numberOfTowns;
    }

    public int getNumProvinces() {
        int numberOfProvinces = 0;
        for (Region region : regions) {
            List<Province> provinces = region.getProvinces();
            numberOfProvinces += (long) provinces.size();
        }
        return numberOfProvinces;
    }

    public List<Province> getProvincesInAlphabeticalOrder() {
        List<Province> allProvinces = getAllProvinces();
        Collator collator = Collator.getInstance(new Locale("tr_TR"));
        collator.setStrength(Collator.PRIMARY);
        allProvinces.sort(Comparator.comparing(Province::getName, collator));
        return allProvinces;
    }

    public Province getProvinceByName(String name) {
        List<Province> allProvinces = getAllProvinces();
        for (Province allProvince : allProvinces)
            if (allProvince.getName().equals(name))
                return allProvince;
        return null;
    }

    public Province getProvinceByPlateID(int id) {
        List<Province> allProvinces = getAllProvinces();

        for (Province allProvince : allProvinces)
            if (allProvince.getPlateID() == id)
                return allProvince;
        return null;
    }

    private List<Province> getAllProvinces (){
        List<Province> allProvinces = new ArrayList<>();
        for (Region region : regions)
            allProvinces.addAll(region.getProvinces());
        return allProvinces;
    }
}
