import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private final ArrayList<PossibleAnswer> possibleAnswers;
    private final String question;

    public Question(String question, ArrayList<PossibleAnswer> possibleAnswers) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        Collections.shuffle(this.possibleAnswers);
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<PossibleAnswer> getPossibleAnswers() {
        return possibleAnswers;
    }
}