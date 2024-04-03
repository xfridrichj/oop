package oop.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CreateSurveyScene {
    private int index = 1;
    private Stage window;
    private Scene creativeScene;
    private VBox root;
    private HBox buttonsRow;
    private HBox buttonsRow2;
    private Map<String, VBox> questionContentMap;
    private ChoiceBox<String> choiceBox;
    private Button addButton = new Button("Pridať možnosť");
    private Button confirmButton = new Button("Potvrdiť");
    private Button completeButton = new Button("Dokončiť");
    private TextField questionField = new TextField();

    public CreateSurveyScene(Stage primaryStage) {
        this.window = primaryStage;
        root = new VBox(10);
        root.setPadding(new Insets(10));

        questionField.setPromptText("Zadajte otázku:");
        questionField.setMinWidth(300);

        choiceBox = new ChoiceBox<>();
        choiceBox.setItems(FXCollections.observableArrayList(
                "Otázka 1", "Otázka 2", "Otázka 3", "Otázka 4", "Otázka 5",
                "Otázka 6", "Otázka 7", "Otázka 8", "Otázka 9", "Otázka 10"));
        buttonsRow = new HBox(10);
        buttonsRow.getChildren().addAll(choiceBox, questionField);

        buttonsRow2 = new HBox(10);
        buttonsRow2.getChildren().addAll(addButton, confirmButton, completeButton);

        //buttonsRow.getChildren().addAll(addButton, confirmButton, completeButton);

        root.getChildren().addAll(buttonsRow,buttonsRow2);
        creativeScene = new Scene(root, 600, 600);
        primaryStage.setTitle("Vytvoriť anketu");
        primaryStage.setScene(creativeScene);
        primaryStage.show();

        questionContentMap = new HashMap<>();
        for (String question : choiceBox.getItems()) {
            VBox questionContent = new VBox(10);
            questionContentMap.put(question, questionContent);
        }
    }

    public HBox getButtonsRow2() {
        return buttonsRow2;
    }

    public void setButtonsRow2(HBox buttonsRow2) {
        this.buttonsRow2 = buttonsRow2;
    }

    public TextField getQuestionField() {
        return questionField;
    }

    public void setQuestionField(TextField questionField) {
        this.questionField = questionField;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getCreativeScene() {
        return creativeScene;
    }

    public void setCreativeScene(Scene creativeScene) {
        this.creativeScene = creativeScene;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public Map<String, VBox> getQuestionContentMap() {
        return questionContentMap;
    }

    public void setQuestionContentMap(Map<String, VBox> questionContentMap) {
        this.questionContentMap = questionContentMap;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox<String> choiceBox) {
        this.choiceBox = choiceBox;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public Button getCompleteButton() {
        return completeButton;
    }

    public void setCompleteButton(Button completeButton) {
        this.completeButton = completeButton;
    }

    public HBox getButtonsRow() {
        return buttonsRow;
    }

    public void setButtonsRow(HBox buttonRow) {
        this.buttonsRow = buttonRow;
    }
}