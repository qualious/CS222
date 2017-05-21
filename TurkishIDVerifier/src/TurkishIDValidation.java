import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TurkishIDValidation {
    private static final int EXIT_INVALID_INPUT = -1;
    private static final long INVALID_BASE = 100000000;
    private static final int START_FROM_FIRST_INDEX = 0;
    private static final int START_FROM_SECOND_INDEX = 1;
    private static final int INCREMENT_BY_ONE = 1;
    private static final int INCREMENT_BY_TWO = 2;
    private static List<Integer> allDigits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        try {
            long baseNumber = Long.parseLong(input);
            validateNumber(baseNumber);
            allDigits = getDigits(baseNumber);
            Integer lastTwoDigits = getLastTwoDigits();
            System.out.println("Full ID number is " + input + lastTwoDigits + ".");
        }catch (Exception e) {
            System.err.println("Invalid entry! Please try again!");
            System.exit(EXIT_INVALID_INPUT);
        }
    }

    private static List<Integer> getDigits(long baseNumber) {
        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> digits = new ArrayList<>();
        while (baseNumber > 0) {
            stack.push( (int)baseNumber % 10 );
            baseNumber = baseNumber / 10;
        }
        while (!stack.isEmpty()) {
            digits.add(stack.pop());
        }
        return digits;
    }

    private static void validateNumber(long baseNumber) {
        if((int)Math.log10(baseNumber)+1 != 9 || baseNumber == INVALID_BASE) {
            System.out.println("Bad input. Bye.\n");
            System.exit(EXIT_INVALID_INPUT);
        }
    }

    private static int getLastTwoDigits() {
        int sumOFOddIndexedNumbers = getSumOfIndecesInAllDigits(START_FROM_FIRST_INDEX,INCREMENT_BY_TWO);
        int sumOfEvenIndexedNumbers = getSumOfIndecesInAllDigits(START_FROM_SECOND_INDEX,INCREMENT_BY_TWO);
        int firstDigitOfValidation = getFirstDigitOfValidation(sumOFOddIndexedNumbers,sumOfEvenIndexedNumbers);
        int secondDigitOfValidation = getSecondDigitOfValidation(firstDigitOfValidation);
        return firstDigitOfValidation * 10 + secondDigitOfValidation;
    }

    private static int getSumOfIndecesInAllDigits(int startingIndex, int increase) {
        int sum = 0;
        for (int i = startingIndex; i < allDigits.size(); i = i + increase)
            sum += allDigits.get(i);
        return sum;
    }

    private static int getFirstDigitOfValidation(int sumOFOddIndexedNumbers, int sumOfEvenIndexedNumbers) {
        return getFirstDigitOfNumber((sumOFOddIndexedNumbers * 7 - sumOfEvenIndexedNumbers));
    }

    private static int getSecondDigitOfValidation(int firstDigitOfValidation){
        return getFirstDigitOfNumber(getSumOfIndecesInAllDigits(START_FROM_FIRST_INDEX,INCREMENT_BY_ONE)
                + firstDigitOfValidation);
    }

    private static int getFirstDigitOfNumber(int number) {
        return number % 10;
    }
}