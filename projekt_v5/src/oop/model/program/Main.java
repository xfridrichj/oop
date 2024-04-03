package oop.model.program;

import oop.view.BeforeLoginScene;
import oop.controller.BeforeLoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    static Model model = new Model();
    public static void main(String [] args){
        launch(args);
    }
    public void start(Stage primaryStage){
        new BeforeLoginController(new BeforeLoginScene(primaryStage), model);
    }
}
