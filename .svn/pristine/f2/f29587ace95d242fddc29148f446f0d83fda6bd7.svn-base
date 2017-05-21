import java.util.*;
import java.util.stream.IntStream;


class TestBed {
    private static final int  RUN_THE_TEST = 2500;
    private static int numberOfQuestionsAnswered = 0;
    private ArrayList<Figure> figureArrayList;
    private static ArrayList<Figure> figureArrayListBackUp;
    private List<QandAList> questionAndAnswers = new ArrayList<>();

    private List<Integer> questions = Arrays.asList(1,3,4,5,6,7);
    private List<Object> answers = new ArrayList<>();
    private List<Integer> askedQuestions = new ArrayList<>();


    TestBed(String fileName){
        figureArrayList = Figure.generateFigures(fileName);
        figureArrayListBackUp = figureArrayList;
    }

    List<QandAList> randomlyAnswerQuestions(){
        for (int i = 0; i < RUN_THE_TEST; ++i){
            Collections.shuffle(questions);
            for (int questionNumber : questions) {
                askedQuestions.add(questionNumber);
                randomlyAskQuestion(questionNumber);
                ++numberOfQuestionsAnswered;
                if(addQandAList())
                    break;
            }
            figureArrayList = figureArrayListBackUp;
        }
        return questionAndAnswers;
    }

    private void randomlyAskQuestion(int questionNumber){
        if(questionNumber == 2){
            int[] ages = IntStream.rangeClosed(30, 60).toArray();
            Integer input = ages[new Random().nextInt(ages.length)];
            figureArrayList = FigureListModifier.cleanAge(figureArrayList, input);
            answers.add(input);
        }
        else {
            boolean input = Math.random() < 0.5;
            figureArrayList = FigureListModifier.cleanTheList(figureArrayList, questionNumber, input);
            answers.add(input);
        }
    }

    private boolean addQandAList () {
        if(figureArrayList.size() < 1){
            numberOfQuestionsAnswered = 0;
            answers = new ArrayList<>();
            askedQuestions = new ArrayList<>();
            return true;
        }
        if(figureArrayList.size() == 1){
            if(!isDuplicateEntry())
                questionAndAnswers.add(new QandAList(answers,
                                           askedQuestions, numberOfQuestionsAnswered));
            answers = new ArrayList<>();
            askedQuestions = new ArrayList<>();
            numberOfQuestionsAnswered = 0;
            return true;
        }
        return false;
    }

    private boolean isDuplicateEntry(){
        for (QandAList questionAndAnswer : questionAndAnswers) {
            if (questionAndAnswer.getAnswerList().equals(answers)
                    && questionAndAnswer.getQuestionList().equals(askedQuestions)) {
                return true;
            }
        }
        return false;
    }

    List<Integer> getQuestions() {
        return questions;
    }

    static ArrayList<Figure> getFigureArrayList() {
        return figureArrayListBackUp;
    }
}
