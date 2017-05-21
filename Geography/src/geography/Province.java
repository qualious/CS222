package geography;

import java.util.*;

public class Province {
    private String name;
    private int plateID;
    private int population;
    private List<Town> towns;
    private Region region;
    private List<Road> outgoingRoads;

    public Province(String name, int plateID) {
        this.name = name;
        this.plateID = plateID;
        this.towns = new LinkedList<>();
        this.outgoingRoads = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getPlateID() {
        return plateID;
    }

    public int getPopulation() {
        return population;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public List<Road> getOutgoingRoads() {
        return outgoingRoads;
    }

    public Region getRegion() {
        return region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void add(Town town) {
        towns.add(town);
    }

    public void add(Road road) {
        outgoingRoads.add(road);
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public boolean equals(Object anObject) {
        if(anObject instanceof Province)
            return name.equals(((Province)anObject).name);
        return false;
    }

    public String toString() {
        return name;
    }
}
