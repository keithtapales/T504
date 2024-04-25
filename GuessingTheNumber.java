import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class GuessingTheNumber extends Application {

    private int randomNumber;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guessing The Number");

        Label instructionLabel = new Label("Guess the number (between 1 and 100):");
        TextField guessTextField = new TextField();
        Button guessButton = new Button("Guess");
        Label resultLabel = new Label();
        Label attemptsLabel = new Label();

        generateRandomNumber();

        guessButton.setOnAction(event -> {
            try {
                int guess = Integer.parseInt(guessTextField.getText());
                checkGuess(guess, resultLabel);
                attempts++;
                attemptsLabel.setText("Attempts: " + attempts);
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(instructionLabel, guessTextField, guessButton, resultLabel, attemptsLabel);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private void checkGuess(int guess, Label resultLabel) {
        if (guess == randomNumber) {
            resultLabel.setText("Congratulations! You guessed the number.");
        } else if (guess < randomNumber) {
            resultLabel.setText("Try a higher number!");
        } else {
            resultLabel.setText("Try a lower number!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}