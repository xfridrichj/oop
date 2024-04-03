package oop.model.test_package;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PasswordFieldExample extends Application {

    private String storedPassword;

    @Override
    public void start(Stage primaryStage) {
        // Create a PasswordField
        PasswordField passwordField = new PasswordField();

        // Listener to store the password
        passwordField.setOnKeyReleased(event -> {
            storedPassword = passwordField.getText();
        });

        // Create a layout and add the PasswordField to it
        StackPane root = new StackPane();
        root.getChildren().add(passwordField);

        // Create a scene and set it to the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Field Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

