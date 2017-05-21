import java.util.ArrayList;
import java.util.List;

public class QandAList {
    private List<Object> answerList =  new ArrayList<>();
    private List<Integer> questionList =  new ArrayList<>();
    private Integer numberOfQuestionsAnswered;

    public QandAList(List<Object> answerList, List<Integer> questionList,
                     int numberOfQuestionsAnswered) {

        this.answerList = answerList;
        this.questionList = questionList;
        this.numberOfQuestionsAnswered = numberOfQuestionsAnswered;
    }

    public List<Object> getAnswerList() {
        return answerList;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public Integer getNumberOfQuestionsAnswered(){
        return numberOfQuestionsAnswered;
    }

    @Override
    public String toString() {
        return "\n" + questionList.toString() + answerList.toString()+ " = " + numberOfQuestionsAnswered + "\n";
    }
}
