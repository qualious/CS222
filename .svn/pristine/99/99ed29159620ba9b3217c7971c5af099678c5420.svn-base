import java.util.*;

import static java.lang.StrictMath.ceil;

public class Bot {
    private static Scanner scanner = new Scanner(System.in);
    private static int numberOfQAnswered = 0;
    private static int questionIndexIterator = 0;
    private static int questionSizeIterator = 2;
    private static TestBed testBed;
    private static List<QandAList> questionsAndAnswers;
    private static ArrayList<Figure> figureArrayList = new ArrayList<>();
    private static List<Integer> askedQuestions = new ArrayList<>();

    public static void main(String[] args) {
      System.out.print("Enter file name: ");
      String fileName = "resources/" + scanner.next();
        testBed = new TestBed(fileName);
        questionsAndAnswers = testBed.randomlyAnswerQuestions();
        figureArrayList = TestBed.getFigureArrayList();
        sortByNumberOfQuestionsAnswered();
        while(figureArrayList.size() > 1) {
            int mostFrequentQuestion = checkMostFrequent(mostFrequent(getQuestions()));
            askedQuestions.add(mostFrequentQuestion);
            askQuestionAndAnswerIt(mostFrequentQuestion);
            ++numberOfQAnswered;
            decideAnswer();
            ++questionSizeIterator;
        }
    }

    private static void sortByNumberOfQuestionsAnswered(){
        questionsAndAnswers.sort(Comparator.comparing(QandAList::getNumberOfQuestionsAnswered));
    }

    /* gets TestBed questions from questionLists according to questionIndexIterator
    *  smaller list gets 5 fold power in order to make it favorable in asking decision */
    private static List<Integer> getQuestions(){
        int sizeOfFirstList = questionsAndAnswers.get(0).getQuestionList().size();
        List<Integer> questions = new ArrayList<>();
        for (QandAList questionsAndAnswer : questionsAndAnswers) {
            if (questionsAndAnswer.getQuestionList().size() == sizeOfFirstList)
                for (int k = 0; k < 5; ++k)
                    questions.add(questionsAndAnswer.getQuestionList().get(questionSizeIterator - 2));
            if (questionsAndAnswer.getQuestionList().size() == sizeOfFirstList + 1)
                questions.add(questionsAndAnswer.getQuestionList().get(questionSizeIterator - 2));
        }
        return questions;
    }

    private static int mostFrequent(List<Integer> sourceArray) {
        Map<Integer, Integer> questionsAndFrequencies = new HashMap<>();
        for (int questionKey : sourceArray) {
            Integer frequency = questionsAndFrequencies.get(questionKey);
            questionsAndFrequencies.put(questionKey, (frequency == null) ? 1 : frequency + 1);
        }
        int max = -1;
        int mostFrequent = -1;
        for (Map.Entry<Integer, Integer> qAndFrequency : questionsAndFrequencies.entrySet()) {
            if (qAndFrequency.getValue() > max) {
                mostFrequent = qAndFrequency.getKey();
                max = qAndFrequency.getValue();
            }
        }
        return mostFrequent;
    }

    private static int checkMostFrequent(int mostFrequentQuestion){
        if(mostFrequentQuestion == -1){
            List<Integer> haventAskedYet = new ArrayList<>(testBed.getQuestions());
            haventAskedYet.removeAll(askedQuestions);
            Random rand = new Random();
            mostFrequentQuestion = haventAskedYet.get(rand.nextInt(haventAskedYet.size()));
        }
        return mostFrequentQuestion;
    }

    private static void removeNonFrequent(int mostFrequent, Object answer){
        for (Iterator<QandAList> iteretor = questionsAndAnswers.listIterator(); iteretor.hasNext(); ) {
            QandAList a = iteretor.next();
            if (a.getQuestionList().get(questionIndexIterator) != mostFrequent
                    ||  a.getAnswerList().get(questionIndexIterator) != answer) {
                iteretor.remove();
            }
        }
        questionIndexIterator++;
    }

    private static void askQuestionAndAnswerIt(int mostFrequentQuestion){
        System.out.println(mostFrequentQuestion + "?");
        if(mostFrequentQuestion != 2)
            System.out.print("Your answer: ");
        String answer = scanner.next();
        if (mostFrequentQuestion == 2) {
            figureArrayList = FigureListModifier.cleanAge(figureArrayList, Integer.parseInt(answer));
            removeNonFrequent(mostFrequentQuestion, Integer.parseInt(answer));
        }
        else{
            figureArrayList = FigureListModifier.cleanTheList(figureArrayList, mostFrequentQuestion, answer.equals("Yes"));
            removeNonFrequent(mostFrequentQuestion, answer.equalsIgnoreCase("Yes"));
        }
    }

    private static void decideAnswer() {
        if(figureArrayList.size() < 1){
            System.out.println("That's impossible. You're a liar!\n");
            System.exit(0);
        }
        if(figureArrayList.size() == 1){
            System.out.printf("I found it in "+ numberOfQAnswered +" steps! It is " + figureArrayList.get(0).getName() + "!");
            System.exit(0);
        }
    }
}
