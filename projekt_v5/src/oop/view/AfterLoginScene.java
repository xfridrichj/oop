package oop.view;

import oop.controller.BeforeLoginController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AfterLoginScene {
    private BeforeLoginController beforeLoginController;
    private Stage window;
    private Scene postLoginScene;
    private VBox layout2 = new VBox();
    private Button logOffButton = new Button("Odhlásiť sa");
    private Button createSurvey = new Button("Vytvoriť anketu");
    private Button voteInSurvey = new Button("Hlasovať v ankete");
    private Button manageSurveys =  new Button("Spravovať ankety...");
    private Label loggedLabel = new Label();

    public AfterLoginScene(Stage primaryStage, String username) {
        this.window = primaryStage;
        layout2.setAlignment(Pos.TOP_CENTER);

        loggedLabel.setText("Ste prihlasený, "+username);
        VBox.setMargin(createSurvey, new Insets(10, 20, 10, 20));
        VBox.setMargin(voteInSurvey, new Insets(10, 20, 10, 20));
        VBox.setMargin(manageSurveys, new Insets(10, 20, 10, 20));
        VBox.setMargin(logOffButton, new Insets(50, 20, 10, 20));
        layout2.getChildren().addAll(loggedLabel, createSurvey, voteInSurvey, manageSurveys, logOffButton);

        postLoginScene = new Scene(layout2, 400, 250);
        window.setScene(postLoginScene);
        window.show();
    }

    public BeforeLoginController getBeforeLoginController() {
        return beforeLoginController;
    }

    public void setBeforeLoginController(BeforeLoginController beforeLoginController) {
        this.beforeLoginController = beforeLoginController;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getPostLoginScene() {
        return postLoginScene;
    }

    public void setPostLoginScene(Scene postLoginScene) {
        this.postLoginScene = postLoginScene;
    }

    public VBox getLayout2() {
        return layout2;
    }

    public void setLayout2(VBox layout2) {
        this.layout2 = layout2;
    }

    public Button getLogOffButton() {
        return logOffButton;
    }

    public void setLogOffButton(Button logOffButton) {
        this.logOffButton = logOffButton;
    }

    public Button getCreateSurvey() {
        return createSurvey;
    }

    public void setCreateSurvey(Button createSurvey) {
        this.createSurvey = createSurvey;
    }

    public Button getVoteInSurvey() {
        return voteInSurvey;
    }

    public void setVoteInSurvey(Button voteInSurvey) {
        this.voteInSurvey = voteInSurvey;
    }

    public Button getManageSurveys() {
        return manageSurveys;
    }

    public void setManageSurveys(Button manageSurveys) {
        this.manageSurveys = manageSurveys;
    }

    public Label getLoggedLabel() {
        return loggedLabel;
    }

    public void setLoggedLabel(Label loggedLabel) {
        this.loggedLabel = loggedLabel;
    }
}
