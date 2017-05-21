package geography;

import java.util.*;

public class Region {
    private String name;
    private List<Province> provinces;

    public Region(String name) {
        this.name = name;
        this.provinces = new LinkedList<>();
    }

    public void add(Province province) {
        provinces.add(province);
    }

    public String getName() {
        return name;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public int getPopulation(){
        return provinces.stream().filter(o -> o.getPopulation()  > 0).mapToInt(Province::getPopulation).sum();
    }

    public boolean equals(Object anObject) {
        if(anObject instanceof Region)
            return name.equals(((Region)anObject).name);
        return false;
    }

    public String toString() {
        return name;
    }
}
