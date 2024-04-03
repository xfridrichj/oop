package oop.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import oop.controller.VotePopController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteSurveyScene {
    private VotePopController votePopController;
    private Stage window;
    private Scene voteScene;

    private VBox root = new VBox(10);
    private HBox hboxForChoiceBox = new HBox(10);
    private HBox hboxForQuestion = new HBox(10);
    private VBox vboxForToggle = new VBox(10);

    private Label infoLable = new Label("Vyberte otázku:");
    private Label questionLabel = new Label();
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private Button finishButton = new Button("Odoslať");
    private ToggleButton toggleButton = new ToggleButton();
    private ToggleGroup toggleGroup = new ToggleGroup();

    private List<String> questionKeys;
    private List<String> optionsList = new ArrayList<>();
    private List<String> formatOptions = new ArrayList<>();

    private Map<String, List<String>> questionsWithOptions;
    private Map<String, String> selectedOptionMap;

    public VoteSurveyScene(Stage primaryStage, VotePopController votePopController) {
        this.window = primaryStage;
        this.votePopController = votePopController;

        questionsWithOptions = votePopController.getQuestionsWithOptions();
        questionKeys = new ArrayList<>(questionsWithOptions.keySet());
        selectedOptionMap = new HashMap<>();

        choiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= 0 && newValue.intValue() < questionKeys.size()) {
                String selectedQuestion = questionKeys.get(newValue.intValue());
                questionLabel.setText(selectedQuestion);

                optionsList.clear();
                optionsList.addAll(questionsWithOptions.get(selectedQuestion));

                hboxForQuestion.getChildren().clear();
                vboxForToggle.getChildren().clear();

                vboxForToggle.setAlignment(Pos.TOP_LEFT);

                for (String option : optionsList) {
                    ToggleButton toggleButton = new ToggleButton(option);
                    toggleButton.setMinWidth(460);
                    toggleButton.setToggleGroup(toggleGroup);
                    toggleButton.setOnAction(event -> {
                        selectedOptionMap.put(selectedQuestion, option);
                        //zapis volieb - model
                    });
                    toggleButton.setStyle("-fx-alignment: BASELINE-LEFT;");
                    vboxForToggle.getChildren().addAll(toggleButton);
                }
                hboxForQuestion.getChildren().add(vboxForToggle);
            }

        });
        //System.out.println("ok");


        questionLabel.setFont(Font.font("Arial",14));

        hboxForQuestion.setPadding(new Insets(0,50,10,50));

        hboxForChoiceBox.getChildren().addAll(infoLable,choiceBox,finishButton);

        root.setPadding(new Insets(20));
        root.getChildren().addAll(hboxForChoiceBox,questionLabel,hboxForQuestion);

        voteScene = new Scene(root, 600, 400);
        primaryStage.setTitle("Hlasovať v ankete");
        primaryStage.setScene(voteScene);
        primaryStage.show();
    }

    public Map<String, String> getSelectedOptionMap() {
        return selectedOptionMap;
    }

    public void setSelectedOptionMap(Map<String, String> selectedOptionMap) {
        this.selectedOptionMap = selectedOptionMap;
    }

    public ToggleButton getToggleButton() {
        return toggleButton;
    }

    public void setToggleButton(ToggleButton toggleButton) {
        this.toggleButton = toggleButton;
    }

    public VotePopController getVotePopController() {
        return votePopController;
    }

    public void setVotePopController(VotePopController votePopController) {
        this.votePopController = votePopController;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getVoteScene() {
        return voteScene;
    }

    public void setVoteScene(Scene voteScene) {
        this.voteScene = voteScene;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox<String> choiceBox) {
        this.choiceBox = choiceBox;
    }

    public Label getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(Label questionLabel) {
        this.questionLabel = questionLabel;
    }

    public List<String> getQuestionKeys() {
        return questionKeys;
    }

    public void setQuestionKeys(List<String> questionKeys) {
        this.questionKeys = questionKeys;
    }

    public List<String> getFormatOptions() {
        return formatOptions;
    }

    public void setFormatOptions(List<String> formatOptions) {
        this.formatOptions = formatOptions;
    }

    public HBox getHboxForQuestion() {
        return hboxForQuestion;
    }

    public void setHboxForQuestion(HBox hboxForQuestion) {
        this.hboxForQuestion = hboxForQuestion;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }

    public Map<String, List<String>> getQuestionsWithOptions() {
        return questionsWithOptions;
    }

    public void setQuestionsWithOptions(Map<String, List<String>> questionsWithOptions) {
        this.questionsWithOptions = questionsWithOptions;
    }

    public VBox getVboxForToggle() {
        return vboxForToggle;
    }

    public void setVboxForToggle(VBox vboxForToggle) {
        this.vboxForToggle = vboxForToggle;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    public Label getInfoLable() {
        return infoLable;
    }

    public void setInfoLable(Label infoLable) {
        this.infoLable = infoLable;
    }

    public HBox getHboxForChoiceBox() {
        return hboxForChoiceBox;
    }

    public void setHboxForChoiceBox(HBox hboxForChoiceBox) {
        this.hboxForChoiceBox = hboxForChoiceBox;
    }

    public Button getFinishButton() {
        return finishButton;
    }

    public void setFinishButton(Button finishButton) {
        this.finishButton = finishButton;
    }
}






/*package oop.view;

import oop.controller.VotePopController;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VoteSurveyScene {
    private VotePopController votePopController;
    private Stage window;
    private Scene voteScene;
    private VBox root = new VBox(10);
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    public VoteSurveyScene (Stage primaryStage, VotePopController votePopController){
        this.window = primaryStage;
        this.votePopController = votePopController;

        Map<String, Map<String, List<String>>> questionsWithOptions = votePopController.getQuestionsWithOptions();
        List<String> questionKeys = new ArrayList<>(questionsWithOptions.keySet());

        choiceBox.setItems(FXCollections.observableArrayList(questionKeys));
        choiceBox.setValue("-");
        root.setPadding(new Insets(10));
        root.getChildren().addAll(choiceBox);

        voteScene = new Scene(root,600,400);
        primaryStage.setTitle("Hlasovanie v ankete");
        primaryStage.setScene(voteScene);
        primaryStage.show();
    }

    public VotePopController getVotePopController() {
        return votePopController;
    }

    public void setVotePopController(VotePopController votePopController) {
        this.votePopController = votePopController;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getVoteScene() {
        return voteScene;
    }

    public void setVoteScene(Scene voteScene) {
        this.voteScene = voteScene;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox<String> choiceBox) {
        this.choiceBox = choiceBox;
    }

}*/
