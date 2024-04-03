package oop.model.test_package;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Test2 extends Application {
    Stage window;
    Scene scene1, scene2;
    Button button1,button2;
    Label label1,label2;

    public void start(Stage primaryStage){
        window=primaryStage;

        //label 1 a button 1
        label1 = new Label("Vitaj");
        button1 = new Button();
        button1.setText("Chod do sceny 2");
        button1.setOnAction(e->window.setScene(scene2));

        //layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1,400,200);

        //label 2 a button 2
        label2 = new Label("druha scena");
        button2 = new Button();
        button2.setText("Zvladol si to, cod naspat");
        button2.setOnAction(e->window.setScene(scene1));

        //layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label2,button2);
        scene2 = new Scene(layout2, 400, 200);

        window.setScene(scene1);
        window.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
