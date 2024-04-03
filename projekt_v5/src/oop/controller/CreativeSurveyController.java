package oop.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import oop.model.program.Model;
import oop.view.CreateSurveyScene;
import oop.view.AlertBoxCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CreativeSurveyController {
    private CreateSurveyScene createSurveyScene;
    private Model model;
    private Map<String, String> questionTextMap;

    BeforeLoginController beforeLoginController;

    public CreativeSurveyController(CreateSurveyScene createSurveyScene, Model model,BeforeLoginController beforeLoginController) {
        this.createSurveyScene = createSurveyScene;
        this.model = model;
        this.beforeLoginController = beforeLoginController;
        this.questionTextMap = new HashMap<>();
        int code = model.codeGenerator();

        System.out.println(beforeLoginController.getCurrentUsername());

        createSurveyScene.getAddButton().setDisable(true);//disable pre lepsiu manipulaciu
        createSurveyScene.getConfirmButton().setDisable(true);

        createSurveyScene.getChoiceBox().setValue("-");
        createSurveyScene.getChoiceBox().setOnAction(e -> {
            /*String selectedQuestion = createSurveyScene.getChoiceBox().getValue();//toto iba kontroluje ci bolo nieco vybrate, blockuje buttony
            if (selectedQuestion != null) {//ak bolo nieco vybrate
                createSurveyScene.getAddButton().setDisable(false);
                createSurveyScene.getConfirmButton().setDisable(false);

                createSurveyScene.getQuestionField().setText(questionTextMap.getOrDefault(selectedQuestion, ""));
            }
            else {
                createSurveyScene.getAddButton().setDisable(true);
                createSurveyScene.getConfirmButton().setDisable(true);
            }*/
            showOptions(model.behaviorChoiceBox(createSurveyScene,this,questionTextMap));
            //showOptions(selectedQuestion);
        });

        createSurveyScene.getAddButton().setOnAction(e -> {//ked sa klikni add button
            String selectedQuestion = createSurveyScene.getChoiceBox().getValue();
            if (createSurveyScene.getQuestionContentMap() == null || createSurveyScene.getQuestionContentMap().isEmpty()) {
                //initQuestionContentMap();//model
                model.initQuestionContentMap(createSurveyScene);
            }
            addNewOption(selectedQuestion);//model
        });
        createSurveyScene.getConfirmButton().setOnAction(e -> model.writingFile(code,beforeLoginController,createSurveyScene, questionTextMap));
        //createSurveyScene.getConfirmButton().setOnAction(e -> confirmOptions(code));

        createSurveyScene.getCompleteButton().setOnAction(e -> {
            AlertBoxCode.display(code);
            createSurveyScene.getWindow().close();//optional
        });

        //TextField listener
        createSurveyScene.getQuestionField().textProperty().addListener((observable, oldValue, newValue) -> {
            String selectedQuestion = createSurveyScene.getChoiceBox().getValue();
            if (selectedQuestion != null) {
                questionTextMap.put(selectedQuestion, newValue);
            }
        });
    }

    /*private void initQuestionContentMap() {//spracovava otazky a otazkove polia
        createSurveyScene.setQuestionContentMap(new HashMap<>());
        for (String question : createSurveyScene.getChoiceBox().getItems()) {
            VBox questionContent = new VBox(10);
            createSurveyScene.getQuestionContentMap().put(question, questionContent);
        }
    }*/

    private void showOptions(String question) {
        VBox root = createSurveyScene.getRoot();
        root.getChildren().removeIf(node -> node instanceof VBox);
        VBox selectedQuestionContent = createSurveyScene.getQuestionContentMap().get(question);
        root.getChildren().add(selectedQuestionContent);
    }

    private void addNewOption(String question) {
        VBox questionContent = createSurveyScene.getQuestionContentMap().get(question);

        Label label = new Label("Možnosť " + createSurveyScene.getIndex());
        TextField textField = new TextField();
        textField.setPromptText("Zadajte možnosť:");

        questionContent.getChildren().addAll(label, textField);
        createSurveyScene.setIndex(createSurveyScene.getIndex()+1);
        showOptions(question);
    }

    /*public static int codeGenerator() {
        Random rand = new Random();
        return rand.nextInt(90000)+10000;//aby boli 5ciferne vzdy
    }*/

    /*private void confirmOptions(int code) {
        FileWriter writer = null;
        try {
            //vlastne formatovania vpisania do fileu
            writer = new FileWriter("data.txt", true);
            writer.write("*\n");
            writer.write("@" + beforeLoginController.getCurrentUsername() + "@\n");
            writer.write("#" + code + "\n");

            //reverse order
            for (int i = createSurveyScene.getQuestionContentMap().size() - 1; i >= 0; i--) {
                String question = (String) createSurveyScene.getQuestionContentMap().keySet().toArray()[i];
                VBox contentVBox = createSurveyScene.getQuestionContentMap().get(question);

                StringBuilder data = new StringBuilder();
                for (int j = 0; j < contentVBox.getChildren().size(); j += 2) {
                    Label label = (Label) contentVBox.getChildren().get(j);
                    TextField textField = (TextField) contentVBox.getChildren().get(j + 1);
                    data.append(textField.getText());
                    if (j < contentVBox.getChildren().size() - 2) {
                        data.append("\n");
                    }
                }

                String questionText = questionTextMap.getOrDefault(question, "");
                if (!questionText.isEmpty()) {
                    writer.write("$\n"+questionText+"\n");
                }
                writer.write("%\n"+data+"\n%\n");
            }
            writer.write("/\n\n");
            System.out.println("anketa ulozena");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close(); //close
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}



/*
*     private void confirmOptions() {
        FileWriter writer = null; // Declare FileWriter outside try block
        try {
            writer = new FileWriter("data.txt", true); // Open the file for writing in append mode
            // Iterate through the keys of questionContentMap in reverse order
            for (int i = createSurveyScene.getQuestionContentMap().size() - 1; i >= 0; i--) {
                String question = (String) createSurveyScene.getQuestionContentMap().keySet().toArray()[i];
                VBox contentVBox = createSurveyScene.getQuestionContentMap().get(question);

                StringBuilder data = new StringBuilder();
                for (int j = 0; j < contentVBox.getChildren().size(); j += 2) {
                    Label label = (Label) contentVBox.getChildren().get(j);
                    TextField textField = (TextField) contentVBox.getChildren().get(j + 1);
                    data.append(label.getText()).append(": ").append(textField.getText());
                    if (j < contentVBox.getChildren().size() - 2) {
                        data.append("\n"); // Append newline character if not the last option
                    }
                }
                // Write the question and its input from questionField only if it's not empty
                String questionText = questionTextMap.getOrDefault(question, "");
                if (!questionText.isEmpty()) {
                    writer.write(questionText + ":\n");
                }
                writer.write(data.toString() + "\n");
            }
            System.out.println("Options saved");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close(); // Close the FileWriter
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/