import java.util.ArrayList;
import java.util.Scanner;

public class GuessWho {
    private static int numberOfQuestionsAsked = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Figure> figureArrayList;

    public static void main(String[] args) {
        printAllFigures();
        printQuestions();
        while (true) {
            System.out.println();
            System.out.print("?> ");
            int choice = getInput();
            answerTheQuestion(choice);
            ++numberOfQuestionsAsked;
            decideAnswer();
        }
    }

    private static void printAllFigures() {
        System.out.println("Welcome to \"Guess Who?\"");
        System.out.print("Enter file name: ");
        String fileName = "GuessWho/resources/" + scanner.next();
        figureArrayList = Figure.generateFigures(fileName);
        System.out.println("Figures:");
        for (Figure figure : figureArrayList) {
            System.out.println(figure);
        }
    }

    private static void printQuestions() {
        System.out.println("What's your question? Make your choice.");
        System.out.println("1. Is the secret figure male?");
        System.out.println("2. Is the secret figure younger than __ ages?");
        System.out.println("3. Does the secret figure have brown eyes?");
        System.out.println("4. Is the secret figure bald?");
        System.out.println("5. Does the secret figure have beard?");
        System.out.println("6. Does the secret figure have a hat?");
        System.out.println("7. Does the secret figure have glasses?");
    }

    private static int getInput() {
        int input = 0;
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
        } else {
            //ignore the scanner and go to the default case since input stays at 0.
            scanner.nextLine();
        }
        return input;
    }

    private static void answerTheQuestion(int choice) {
        switch (choice) {
            case 1:
                decideAnswerForGender();
                break;
            case 2:
                decideAnswerForAge();
                break;
            case 3:
                decideAnswerForEyeColor();
                break;
            case 4:
                decideAnswerForHair();
                break;
            case 5:
                decideAnswerForBeard();
                break;
            case 6:
                decideAnswerForHat();
                break;
            case 7:
                decideAnswerForGlasses();
                break;
            default:
                System.out.print("Please enter a number between 1 and 7!");
                break;
        }
    }

    private static void decideAnswerForGender() {
        ArrayList<Figure> maleList = new ArrayList<>();
        ArrayList<Figure> femaleList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getGender())
                maleList.add(figure);
            else
                femaleList.add(figure);
        }
        replaceExistingFigureList(maleList, femaleList);
    }

    private static void decideAnswerForAge() {
        System.out.print("Enter the age to check if the figure is younger\n>");
        int age = scanner.nextInt();
        ArrayList<Figure> youngerList = new ArrayList<>();
        ArrayList<Figure> olderList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getAge() < age)
                youngerList.add(figure);
            else
                olderList.add(figure);
        }
        replaceExistingFigureList(youngerList, olderList);
    }

    private static void decideAnswerForEyeColor() {
        ArrayList<Figure> brownEyesList = new ArrayList<>();
        ArrayList<Figure> otherEyesList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getEyeColor().equals("brown eyes"))
                brownEyesList.add(figure);
            else
                otherEyesList.add(figure);
        }
        replaceExistingFigureList(brownEyesList, otherEyesList);
    }

    private static void decideAnswerForHair() {
        ArrayList<Figure> baldList = new ArrayList<>();
        ArrayList<Figure> notBaldList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (figure.getHairStatus())
                baldList.add(figure);
            else
                notBaldList.add(figure);
        }
        replaceExistingFigureList(baldList, notBaldList);
    }

    private static void decideAnswerForBeard() {
        ArrayList<Figure> cleanShavenList = new ArrayList<>();
        ArrayList<Figure> beardedList = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (!figure.getBeardStatus())
                cleanShavenList.add(figure);
            else
                beardedList.add(figure);
        }
        replaceExistingFigureList(cleanShavenList, beardedList);
    }

    private static void decideAnswerForHat() {
        ArrayList<Figure> notWearingHat = new ArrayList<>();
        ArrayList<Figure> wearingHat = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (!figure.getHatStatus())
                notWearingHat.add(figure);
            else
                wearingHat.add(figure);
        }
        replaceExistingFigureList(notWearingHat, wearingHat);
    }

    private static void decideAnswerForGlasses() {
        ArrayList<Figure> notWearingGlasses = new ArrayList<>();
        ArrayList<Figure> wearingGlasses = new ArrayList<>();
        for (Figure figure : figureArrayList) {
            if (!figure.getGlassStatus())
                notWearingGlasses.add(figure);
            else
                wearingGlasses.add(figure);
        }
        replaceExistingFigureList(notWearingGlasses, wearingGlasses);
    }

    private static void replaceExistingFigureList(ArrayList<Figure> firstList, ArrayList<Figure> secondList) {
        if (firstList.size() > secondList.size()) {
            figureArrayList = firstList;
            System.out.println("Yes.");
        } else {
            figureArrayList = secondList;
            System.out.println("No.");
        }
    }

    private static void decideAnswer() {
        if (figureArrayList.size() == 1) {
            System.out.println("Congrats! You found it in " + numberOfQuestionsAsked + " steps! It was " +
                    figureArrayList.get(0).getName() + "!\nBye.");
            System.exit(0);
        }
    }
}