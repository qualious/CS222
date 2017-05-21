package geography;
import java.util.*;

public class RoutePlanner {
    private static List<Region> regions;

    public RoutePlanner(Country country) {
        regions = country.getRegions();
        ProvinceNode.clearNodeList();
    }

    public List<Road> getRoute (Province source, Province destination) {
        List<Road> roads;
        List<Province> provinces;
        List<ProvinceNode> provinceNodes;
        List<ProvinceNode> routeNodes;
        List<Road> solutionRoad;

        roads = connectAllRoads();
        provinces = setProvincesOfConnectedRoads(roads);
        provinceNodes = createRoadGraph(roads, provinces);
        routeNodes = setAllRouteDistancesOnGraph(provinceNodes, source, destination);
        solutionRoad = getSolutionRoute(routeNodes);
        return solutionRoad;
    }

    private List<Road> connectAllRoads() {
        List<Road> roads = new ArrayList<>();
        for (Region region : regions){
            List<Province> provinces = region.getProvinces();
            for (Province province : provinces){
                roads.addAll(province.getOutgoingRoads());
            }
        }
        return roads;
    }

    private List<Province> setProvincesOfConnectedRoads(List<Road> roads) {
        List<Province> provinces = new ArrayList<>();
        for (Road road : roads) {
            if (!provinces.contains(road.getPortA()))
                provinces.add(road.getPortA());
            if (!provinces.contains(road.getPortB()))
                provinces.add(road.getPortB());
        }
        return provinces;
    }

    private List<ProvinceNode> createRoadGraph(List<Road> roads, List<Province> provinces) {
        List<ProvinceNode> provinceNodes = new ArrayList<>();
        createNodes(provinces, provinceNodes);
        addDestinationsToNodes(roads, provinceNodes);
        return provinceNodes;
    }

    private void createNodes(List<Province> provinces, List<ProvinceNode> provinceNodes) {
        for (Province province: provinces)
            provinceNodes.add(new ProvinceNode(province));
    }

    private void addDestinationsToNodes(List<Road> roads, List<ProvinceNode> provinceNodes) {
        for (Road road : roads){
            for (ProvinceNode provinceNode : provinceNodes){
                if (provinceNode.getProvince().equals(road.getPortA())){
                    provinceNode.addDestination(ProvinceNode.getNode(road.getPortB()), road.getLength());
                }
            }
        }
    }

    private List<ProvinceNode> setAllRouteDistancesOnGraph(List<ProvinceNode> provinceNodes, Province source, Province destination) {
        List<ProvinceNode> routeNodes = new ArrayList<>();
        for (ProvinceNode province : provinceNodes){
            if (province.getProvince().equals(source))
                getShortestPathFromSource(province);
        }

        ProvinceNode destinationProvinceNode = null;
        for (ProvinceNode province : provinceNodes){
            if (province.getProvince().equals(destination)) {
                destinationProvinceNode = province;
                routeNodes = province.getShortestPath();
            }
        }
        routeNodes.add(destinationProvinceNode);

        return routeNodes;
    }

    private static void getShortestPathFromSource(ProvinceNode source) {
        source.setDistance(0);
        Set<ProvinceNode> knownMinDistanceRoutes = new HashSet<>();
        Set<ProvinceNode> unknownMinDistanceRoutes = new HashSet<>();
        unknownMinDistanceRoutes.add(source);
        while (!unknownMinDistanceRoutes.isEmpty()) {
            ProvinceNode thisNode = getLowestDistanceOf(unknownMinDistanceRoutes);
            unknownMinDistanceRoutes.remove(thisNode);
            for (Map.Entry<ProvinceNode, Integer> neighborPairs : thisNode.getNeighborNodes().entrySet()) {
                ProvinceNode neighborNode = neighborPairs.getKey();
                Integer distance = neighborPairs.getValue();
                if (!knownMinDistanceRoutes.contains(neighborNode)) {
                    adjustVisitedDistance(thisNode, neighborNode, distance);
                    unknownMinDistanceRoutes.add(neighborNode);
                }
            }
            knownMinDistanceRoutes.add(thisNode);
        }
    }

    private static ProvinceNode getLowestDistanceOf(Set<ProvinceNode> unvisitedNodes) {
        ProvinceNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (ProvinceNode provinceNode : unvisitedNodes) {
            int nodeDistance = provinceNode.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = provinceNode;
            }
        }
        return lowestDistanceNode;
    }

    private static void adjustVisitedDistance(ProvinceNode thisNode, ProvinceNode thatNode, Integer distance) {
        Integer sourceDistance = thisNode.getDistance();
        if (sourceDistance + distance < thatNode.getDistance()) {
            thatNode.setDistance(sourceDistance + distance);
            LinkedList<ProvinceNode> shortestPath = new LinkedList<>(thisNode.getShortestPath());
            shortestPath.add(thisNode);
            thatNode.setShortestPath(shortestPath);
        }
    }

    private List<Road> getSolutionRoute(List<ProvinceNode> routeNodes) {
        List<Road> solutionRoad = new ArrayList<>();
        List<Province> solutionProvinces = new ArrayList<>();
        for (ProvinceNode provinceNode : routeNodes)
            solutionProvinces.add(provinceNode.getProvince());

        for (int i = 0; i < solutionProvinces.size()-1; ++i){
            solutionRoad.add(Road.getRoad(solutionProvinces.get(i),solutionProvinces.get(i+1)));
        }
        return solutionRoad;
    }
}

class ProvinceNode {

    private Province province;
    private List<ProvinceNode> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<ProvinceNode, Integer> neighborProvinces = new HashMap<>();
    static private List<ProvinceNode> allProvinces = new ArrayList<>();

    ProvinceNode(Province province) {
        this.province = province;
        allProvinces.add(this);
    }

    Map<ProvinceNode, Integer> getNeighborNodes() {
        return neighborProvinces;
    }

    void setDistance(int distance) {
        this.distance = distance;
    }


    static ProvinceNode getNode(Province province){
        for (ProvinceNode provinceNode : allProvinces)
            if (provinceNode.province.equals(province))
                return provinceNode;
        return null;
    }

    void addDestination(ProvinceNode destination, int distance) {
        neighborProvinces.put(destination, distance);
    }

    List<ProvinceNode> getShortestPath() {
        return shortestPath;
    }

    void setShortestPath(List<ProvinceNode> shortestPath) {
        this.shortestPath = shortestPath;
    }

    int getDistance() {
        return distance;
    }

    public Province getProvince() {
        return province;
    }

    static void clearNodeList() {
        allProvinces.clear();
    }
}



