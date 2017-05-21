import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Figure {
    private static final int FILE_NOT_FOUND_EXCEPTION = 1;
    private static ArrayList<Figure> figureArrayList = new ArrayList<>();
    private String name;
    private String gender;
    private int age;
    private String eyeColor;
    private boolean isBald;
    private boolean isCleanShaven;
    private boolean isBareHeaded;
    private boolean isBespectacled;

    private Figure(List<String> features) {
        name = features.get(0);
        gender = features.get(1);
        age = Integer.parseInt(features.get(2));
        eyeColor = features.get(3);
        isBald = renderHair(features.get(4));
        isCleanShaven = renderBeard(features.get(5));
        isBareHeaded = renderHat(features.get(6));
        isBespectacled = renderGlasses(features.get(7));
    }

    public static ArrayList<Figure> generateFigures(String fileName) {
        try {
            for (Scanner scanner = new Scanner(new File(fileName)); scanner.hasNext(); ) {
                String nextLine = scanner.nextLine();
                List<String> features = Arrays.asList(nextLine.split(",[ ]*"));
                figureArrayList.add(new Figure(features));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found exception!");
            System.exit(FILE_NOT_FOUND_EXCEPTION);
        }
        return figureArrayList;
    }

    private static boolean renderHair(String source) {
        return source.equals("bald");
    }

    private static boolean renderBeard(String source) {
        return source.equals("has beard");
    }

    private static boolean renderHat(String source) {
        return source.equals("has hat");
    }

    private static boolean renderGlasses(String source) {
        return source.equals("has glasses");
    }

    String getName() {
        return name;
    }

    boolean getGender() {
        return (gender.equals("M"));
    }

    int getAge() {
        return age;
    }

    String getEyeColor() {
        return eyeColor;
    }

    boolean getHairStatus() {
        return isBald;
    }

    boolean getBeardStatus() {
        return isCleanShaven;
    }

    boolean getHatStatus() {
        return isBareHeaded;
    }

    boolean getGlassStatus() {
        return isBespectacled;
    }

    public String toString() {
        return name + "(" +
                gender + ", " +
                age + ", " +
                eyeColor + ", " +
                (isBald ? "bald" : "not bald") + ", " +
                (isCleanShaven ? "no beard" : "has beard") + ", " +
                (isBareHeaded ? "no hat" : "has hat") + ", " +
                (isBespectacled ? "with glasses" : "no glasses") + ")";
    }

}