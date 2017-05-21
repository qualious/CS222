import java.util.ArrayList;

public class FigureListModifier {

    public static ArrayList<Figure> cleanTheList(ArrayList<Figure> figureArrayList, int questionNumber, boolean input) {
        switch (questionNumber) {
            case 1:
                figureArrayList = cleanGender(figureArrayList, input);
                break;
            case 3:
                figureArrayList = cleanEyeColor(figureArrayList, input);
                break;
            case 4:
                figureArrayList = cleanHair(figureArrayList, input);
                break;
            case 5:
                figureArrayList = cleanBeard(figureArrayList, input);
                break;
            case 6:
                figureArrayList = cleanHat(figureArrayList, input);
                break;
            case 7:
                figureArrayList = cleanGlasses(figureArrayList, input);
                break;
        }
        return figureArrayList;
    }

    public static ArrayList<Figure> cleanAge(ArrayList<Figure> figureArrayList, int input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getAge() < input)
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanGender(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getGender() == input)
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanEyeColor(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        String eyeColor;
        if(input)
            eyeColor = "brown eyes";
        else
            eyeColor = "black eyes green eyes blue eyes";

        for (Figure figure : figureArrayList) {
            if (eyeColor.contains(figure.getEyeColor()))
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanHair(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getHairStatus() == input)
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanBeard(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (!figure.getBeardStatus() == input)
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanHat(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (!figure.getHatStatus() == input)
                desiredList.add(figure);
        }
        return desiredList;
    }

    private static ArrayList<Figure> cleanGlasses(ArrayList<Figure> figureArrayList, boolean input) {
        ArrayList<Figure> desiredList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getGlassStatus() == input)
                desiredList.add(figure);
        }
        return desiredList;
    }
}
