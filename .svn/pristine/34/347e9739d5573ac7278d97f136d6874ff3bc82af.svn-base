import java.io.*;
import java.util.*;

public class Map {
    // TODO: Add constructor and other methods as you see fit.
    // Do NOT change the signature of the methods below.
    private List<Square> squareList = new ArrayList<>();
    private Point[][] map;
    private static List<Point> pointList = new ArrayList<>();


    Map(Point[][] map){
        this.map = map;
    }

    public static Map fromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Point[][] map = createMap(br.readLine());
        String line;
        while ((line = br.readLine()) != null) {
            Point point = createPoint(line);
            map[point.getX()][point.getY()] = point;
            pointList.add(point);
        }
        return new Map(map);
    }

    private static Point[][] createMap(String firstLine){
        String[] splited = firstLine.split("\\s+");
        Point[][] map;
        map = new Point[Integer.parseInt(splited[0])][Integer.parseInt(splited[1])];
        return map;
    }

    private static Point createPoint(String line){
        String[] splited = line.split("\\s+");
        Point point = new Point(Integer.parseInt(splited[0]),Integer.parseInt(splited[1]));
        return point;
    }

    public static class Point {
        int x,y;
        Point(int x, int y){
            this.x = x; this.y = y;
        }
        private int getX() { return x; }
        private int getY() { return y; }
        public String toString() { return "(" + x + ", " + y + ")"; }
    }

    public List<Square> getSquares() {
        for (int i = 0; i < pointList.size(); ++i){
            for (int j = 1 ; j < map.length - pointList.get(i).getX(); ++j) {
                try {
                    if (haveAcceptableSquare(i,j))
                        squareList.add(new Square(pointList.get(i).getX(), pointList.get(i).getY(), j));
                } catch (Exception ignore){}
            }
        }
        return squareList;
    }

    private boolean haveAcceptableSquare(int index, int searchLenght){
        return map[pointList.get(index).getX() + searchLenght][pointList.get(index).getY() + searchLenght] != null
                && map[pointList.get(index).getX() + 0][pointList.get(index).getY() + searchLenght] != null
                && map[pointList.get(index).getX() + searchLenght][pointList.get(index).getY() + 0] != null;
    }

    public Point[][] getMap() {
        return map;
    }

    public void printMap(){
        for (int i = 0; i < map.length; ++i)
            for (int j = 0; j < map[0].length; ++j)
                if(map[i][j] != null)
                    System.out.println(map[i][j] + " at -> " + i + " " + j);
    }

}
