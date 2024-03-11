
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizController {

    @FXML
    private ToggleGroup Answers;

    @FXML
    private RadioButton ans1;

    @FXML
    private RadioButton ans2;

    @FXML
    private RadioButton ans3;

    @FXML
    private RadioButton ans4;

    @FXML
    private Label question;

    private Questions questions;

    private PossibleAnswer correctAnswer;

    private int numOfCorrectAnswers = 0;
    private boolean hasAnswered = false;

    public void initialize() {
        questions = new Questions();
        updateQuestion();
    }

    @FXML
    void answerSubmitted(ActionEvent event) {
        if (!hasAnswered) {
            checkQuestion((RadioButton) Answers.getSelectedToggle());
        }

    }

    @FXML
    void nextQuestionPressed(ActionEvent event) {
        if (questions.getQuestions().isEmpty()) {
            endRound();
        } else {
            hasAnswered = false;
            updateQuestion();
        }
    }

    private void endRound() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Round over!");
        alert.setHeaderText("Round over!");
        alert.setContentText("You got " + numOfCorrectAnswers + " out of 10 questions correct!\nThat's " + (numOfCorrectAnswers * 10) + "%!");
        alert.showAndWait();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(QuizMain.class.getResource("StartScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 340);
            Stage stage = new Stage();
            stage.setTitle("Quiz!");
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) ans1.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateQuestion() {
        Question nextQuestion = questions.getQuestions().get(0);
        question.setText(nextQuestion.getQuestion());
        ans1.setText(nextQuestion.getPossibleAnswers().get(0).getAnswer());
        ans2.setText(nextQuestion.getPossibleAnswers().get(1).getAnswer());
        ans3.setText(nextQuestion.getPossibleAnswers().get(2).getAnswer());
        ans4.setText(nextQuestion.getPossibleAnswers().get(3).getAnswer());
        questions.getQuestions().remove(0);
        for (PossibleAnswer possibleAnswer : nextQuestion.getPossibleAnswers()) {
            if (possibleAnswer.isCorrect()) {
                correctAnswer = possibleAnswer;
                break;
            }
        }
        resetRadioButtons();
    }

    private void resetRadioButtons() {
        for (Toggle toggle : Answers.getToggles()) {
            RadioButton radioButton = (RadioButton) toggle;
            radioButton.setStyle("-fx-background-color: #f3f3f3;");
        }
        for (Toggle toggle : Answers.getToggles()) {
            RadioButton radioButton = (RadioButton) toggle;
            radioButton.setSelected(false);
        }
    }

    private void checkQuestion(RadioButton selectedRadioButton) {
        if (selectedRadioButton != null) {
            RadioButton correctRadioAnswer = findCorrectAnswer();
            if (correctRadioAnswer.equals(selectedRadioButton)) {
                correctAnswer(correctRadioAnswer);
            } else {
                incorrectAnswer(selectedRadioButton, correctRadioAnswer);
            }
        } else {
            noAnswer();
        }
        hasAnswered = true;
    }

    private RadioButton findCorrectAnswer() {
        if (ans1.getText().equals(correctAnswer.getAnswer())) {
            return ans1;
        } else if (ans2.getText().equals(correctAnswer.getAnswer())) {
            return ans2;
        } else if (ans3.getText().equals(correctAnswer.getAnswer())) {
            return ans3;
        } else {
            return ans4;
        }
    }

    private void correctAnswer(RadioButton correctRadioAnswer) {
        numOfCorrectAnswers++;
        correctRadioAnswer.setStyle("-fx-background-color: green;");
    }

    private void incorrectAnswer(RadioButton selectedRadioButton, RadioButton correctRadioAnswer) {
        selectedRadioButton.setStyle("-fx-background-color: red;");
        correctRadioAnswer.setStyle("-fx-background-color: green;");
    }

    private void noAnswer() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No answer selected");
        alert.setContentText("Please select an answer");
        alert.showAndWait();
    }
}