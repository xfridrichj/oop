package oop.model;

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
