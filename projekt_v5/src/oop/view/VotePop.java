package oop.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VotePop {
    private Stage window;
    private Scene votePopScene;
    private Label label1 = new Label("Zadajte kód ankety:");
    private TextField codeField = new TextField();
    private Button confirmCodeButton = new Button("Potvrdiť");

    private GridPane layout;
    public VotePop(Stage primaryStage) {
        this.window = primaryStage;
        //Stage window = new Stage();
        window.setTitle("Hlasovanie v ankete");

        layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(10);
        layout.setHgap(10);
        layout.add(label1, 0, 0);
        layout.add(codeField, 1, 0);
        layout.add(confirmCodeButton, 1, 1);

        votePopScene = new Scene(layout, 400, 250);

        window.setScene(votePopScene);
        window.show();
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getVotePopScene() {
        return votePopScene;
    }

    public void setVotePopScene(Scene votePopScene) {
        this.votePopScene = votePopScene;
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public TextField getCodeField() {
        return codeField;
    }

    public void setCodeField(TextField codeField) {
        this.codeField = codeField;
    }

    public Button getConfirmCodeButton() {
        return confirmCodeButton;
    }

    public void setConfirmCodeButton(Button confirmCodeButton) {
        this.confirmCodeButton = confirmCodeButton;
    }

    public GridPane getLayout() {
        return layout;
    }

    public void setLayout(GridPane layout) {
        this.layout = layout;
    }
}
