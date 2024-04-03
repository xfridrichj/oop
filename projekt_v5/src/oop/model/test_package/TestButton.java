package oop.model.test_package;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class TestButton extends Application {
    public void start(Stage stage) {
        //Creating a graphic (image)
        Image img = new Image("UIControls/logo.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        //Creating a Button
        Button button = new Button();
        //Setting the location of the button
        button.setTranslateX(200);
        button.setTranslateY(25);
        //Setting the size of the button
        button.setPrefSize(80, 80);
        //Setting a graphic to the button
        button.setGraphic(view);
        //Setting the stage
        Group root = new Group(button);
        Scene scene = new Scene(root, 595, 170, Color.BEIGE);
        stage.setTitle("Button Graphics");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}