import java.util.ArrayList;
import java.util.Collections;

public class Questions {
    private final ArrayList<Question> questions;

    public Questions() {
        questions = new ArrayList<>();
        ArrayList<PossibleAnswer> possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Sydney", false));
        possibleAnswers.add(new PossibleAnswer("Melbourne", false));
        possibleAnswers.add(new PossibleAnswer("Canberra", true));
        possibleAnswers.add(new PossibleAnswer("Brisbane", false));
        questions.add(new Question("What is the capital city of Australia?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("1905", false));
        possibleAnswers.add(new PossibleAnswer("1923", false));
        possibleAnswers.add(new PossibleAnswer("1931", false));
        possibleAnswers.add(new PossibleAnswer("1912", true));
        questions.add(new Question("In which year did the Titanic sink?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Mars", false));
        possibleAnswers.add(new PossibleAnswer("Jupiter", true));
        possibleAnswers.add(new PossibleAnswer("Saturn", false));
        possibleAnswers.add(new PossibleAnswer("Venus", false));
        questions.add(new Question("What is the largest planet in our solar system?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("William Wordsworth", false));
        possibleAnswers.add(new PossibleAnswer("William Faulkner", false));
        possibleAnswers.add(new PossibleAnswer("William Shakespeare", true));
        possibleAnswers.add(new PossibleAnswer("Jane Austin", false));
        questions.add(new Question("Who wrote the play \"Romeo and Juliet\"?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Hydrogen", true));
        possibleAnswers.add(new PossibleAnswer("Helium", false));
        possibleAnswers.add(new PossibleAnswer("Carbon", false));
        possibleAnswers.add(new PossibleAnswer("Oxygen", false));
        questions.add(new Question("Which element has the chemical symbol \"H\"?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Mount Kilimanjaro", false));
        possibleAnswers.add(new PossibleAnswer("Mount Everest", true));
        possibleAnswers.add(new PossibleAnswer("Mount McKinley", false));
        possibleAnswers.add(new PossibleAnswer("Mount Fuji", false));
        questions.add(new Question("What is the tallest mountain in the world?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Vincent van Gogh", false));
        possibleAnswers.add(new PossibleAnswer("Leonardo da Vinci", true));
        possibleAnswers.add(new PossibleAnswer("Pablo Picasso", false));
        possibleAnswers.add(new PossibleAnswer("Michelangelo", false));
        questions.add(new Question("Who painted the Mona Lisa?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("France", false));
        possibleAnswers.add(new PossibleAnswer("Italy", true));
        possibleAnswers.add(new PossibleAnswer("England", false));
        possibleAnswers.add(new PossibleAnswer("Spain", false));
        questions.add(new Question("In which country did the Renaissance originate?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Seoul", false));
        possibleAnswers.add(new PossibleAnswer("Beijing", false));
        possibleAnswers.add(new PossibleAnswer("Tokyo", true));
        possibleAnswers.add(new PossibleAnswer("Bangkok", false));
        questions.add(new Question("What is the capital city of Japan?", possibleAnswers));
        possibleAnswers = new ArrayList<>();
        possibleAnswers.add(new PossibleAnswer("Venus", false));
        possibleAnswers.add(new PossibleAnswer("Mars", true));
        possibleAnswers.add(new PossibleAnswer("Jupiter", false));
        possibleAnswers.add(new PossibleAnswer("Saturn", false));
        questions.add(new Question("Which planet is known as the \"Red Planet\"?", possibleAnswers));

        Collections.shuffle(questions);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
