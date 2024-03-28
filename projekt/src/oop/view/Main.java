package oop.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class Main extends Application {
    Stage window;
    Scene loginScene, postLoginScene;
    Button loginButton,backButton,closeButton,testButton;//scene 1
    Button createSurvey, voteInSurvey, ownSurveys;//scene 2
    Label label1,label2;//textove labels
    Label usernameLabel, passwordLabel;//informativne labels

    TextField usernameField, passwordField;

    @Override
    public void start(Stage primaryStage){
        window=primaryStage;
        window.setTitle("Anketaren");
        //--------------------------------------------------------------------------------------------------------------
        backButton = new Button();
        backButton.setText("Späť");
        backButton.setOnAction(e->window.setScene(loginScene));//toto zmenit nech sa vrati na predoslu scenu, urobit univerzalne nech viac vyuzitelne

        closeButton = new Button("Ukončiť program");
        closeButton.setOnAction(e-> window.close());

        //SCENA 1
        //l1 a loginButton a layout 1 -----------------------------------------------------------------------------------
        label1 = new Label("Vitajte v Anketaren!");
        loginButton = new Button("Prihlásiť sa");
        loginButton.setOnAction(e->window.setScene(postLoginScene));

        testButton = new Button();
        testButton.setOnAction(e->AlertBox.display("okno"));

        usernameField = new TextField();
        passwordField = new TextField();

        usernameLabel = new Label("Meno:");
        passwordLabel = new Label("Heslo:");

        /*VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1,usernameField,passwordField,loginButton,closeButton);*/

        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(30,44,60,30));//t r b l
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);

        layout1.add(label1,1,0);
        layout1.add(usernameLabel,0,1,1,1);
        layout1.add(passwordLabel,0,2,1,1);
        layout1.add(usernameField,1,1,1,1);
        layout1.add(passwordField,1,2,1,1);
        layout1.add(loginButton,1,4,1,1);
        layout1.add(closeButton,1,5,1,1);

        layout1.add(testButton,2,2,1,1);

        loginScene = new Scene(layout1, 400, 250);

        //SCENA 2
        //l2, backButton------------------------------------------------------------------------------------------------
        label2 = new Label("Ste prihlasený, Jakub");//username
        createSurvey = new Button("Vytvoriť anketu");
        createSurvey.setMaxWidth(160);

        voteInSurvey = new Button("Hlasovať v ankete");
        voteInSurvey.setMaxWidth(160);
        voteInSurvey.setOnAction(e -> Voting.display());

        ownSurveys = new Button("Spravovať ankety...");
        ownSurveys.setMaxWidth(160);

        VBox layout2 = new VBox();
        layout2.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(createSurvey,new Insets(10,20,10,20));
        VBox.setMargin(voteInSurvey,new Insets(10,20,10,20));
        VBox.setMargin(ownSurveys,new Insets(10,20,10,20));
        VBox.setMargin(backButton,new Insets(50,20,10,20));
        layout2.getChildren().addAll(label2,createSurvey,voteInSurvey,ownSurveys,backButton);
        postLoginScene = new Scene(layout2, 400,250);
        //--------------------------------------------------------------------------------------------------------------

        window.setScene(loginScene);
        window.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}