package oop.model.test_package;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class TestScene extends Application{

    Button button;

    public void start(Stage primaryScene){
        primaryScene.setTitle("Survefy");
        button = new Button();
        button.setText("Klikni ma");


        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);

        Scene scene = new Scene(layout,500,400);

        primaryScene.setScene(scene);
        primaryScene.show();

    }
    public static void main(String [ ] args){
        launch(args);
    }
}

/*
* private void confirmOptions() {
    FileWriter writer = null;
    try {
        writer = new FileWriter("data.txt", true); // Open file for appending
        // Iterate through the keys of questionContentMap in reverse order
        for (int i = createSurveyScene.getQuestionContentMap().size() - 1; i >= 0; i--) {
            String question = (String) createSurveyScene.getQuestionContentMap().keySet().toArray()[i];
            VBox contentVBox = createSurveyScene.getQuestionContentMap().get(question);

            StringBuilder data = new StringBuilder();
            for (int j = 0; j < contentVBox.getChildren().size(); j += 2) {
                Label label = (Label) contentVBox.getChildren().get(j);
                TextField textField = (TextField) contentVBox.getChildren().get(j + 1);
                data.append(label.getText()).append(": ").append(textField.getText());
                if (j < contentVBox.getChildren().size() - 2) {
                    data.append("\n"); // Append newline character if not the last option
                }
            }

            // Write the question and its input from questionField only if it's not empty
            String questionText = questionTextMap.getOrDefault(question, "");
            if (!questionText.isEmpty()) {
                writer.write(questionText + ":\n");
            }
            writer.write(data.toString() + "\n");
        }
        System.out.println("Options saved");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (writer != null) {
            try {
                writer.close(); // Close the file writer
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/