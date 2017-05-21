package geography;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private Province portA;
    private Province portB;
    private int length;
    private static List<Road> roads = new ArrayList<>();

    public Road(Province portA, Province portB, int length) {
        this.portA = portA;
        this.portB = portB;
        this.length = length;
        roads.add(this);
    }

    static Road getRoad(Province portA, Province portB){
        for (Road road : roads)
            if (road.getPortA() == portA && road.getPortB() == portB)
                return road;
        return null;
    }

    public Province getPortA() {
        return portA;
    }

    public Province getPortB() {
        return portB;
    }

    public int getLength() {
        return length;
    }

    public String toString(){
        return portA.getName() + " -> " + portB.getName() + " (" + length + " km) " ;
    }
}
