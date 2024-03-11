
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class StartScreenController {

    @FXML
    private Button startButton;

    @FXML
    void exitPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Thanks for playing!");
        alert.setContentText("Thanks for playing!");
        alert.showAndWait();
        System.exit(0);
    }

    @FXML
    void startRound(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(QuizMain.class.getResource("Quiz.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = new Stage();
            stage.setTitle("The amazing trivia game!");
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage)startButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showRules(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rules");
        alert.setHeaderText("Rules");
        alert.setContentText("You will be asked 10 questions.\n\n" +
                "You will have 4 possible answers to choose from.\n\n" +
                "You will have to select the correct answer to get a point.\n\n" +
                "You will be able to see your score at the end of the game.\n\n" +
                "To submit your answer, click on the answer you want to submit and then click on the \"Submit Answer\" button.\n\n" +
                "To move on to the next question, click on the \"Next Question\" button.\n\n" +
                "Good luck!");
        alert.showAndWait();
    }
}