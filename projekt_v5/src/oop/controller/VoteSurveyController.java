package oop.controller;

import javafx.collections.FXCollections;
import oop.model.program.Model;
import oop.view.VoteSurveyScene;

import java.util.Map;

public class VoteSurveyController {
    private VoteSurveyScene voteSurveyScene;
    private Model model;
    public VoteSurveyController (VoteSurveyScene voteSurveyScene, Model model){
        this.voteSurveyScene = voteSurveyScene;
        this.model = model;

        //formatovanie moznosti pre choicebox
        for (int i = 0; i < voteSurveyScene.getQuestionKeys().size(); i++) {
            voteSurveyScene.getFormatOptions().add("Otázka " + (i + 1));
        }
        voteSurveyScene.getChoiceBox().setItems(FXCollections.observableArrayList(voteSurveyScene.getFormatOptions()));
        voteSurveyScene.getChoiceBox().setValue("-");
        voteSurveyScene.getChoiceBox().setMinWidth(85);

        voteSurveyScene.getFinishButton().setOnAction(e->{
            for (String question : voteSurveyScene.getQuestionKeys()) {
                if (voteSurveyScene.getSelectedOptionMap().containsKey(question)) {
                    String selectedOption = voteSurveyScene.getSelectedOptionMap().get(question);
                    System.out.println("Question: " + question + ", Selected Option: " + selectedOption);

                } else {
                    System.out.println("No option selected for question: " + question);
                }
            }
            voteSurveyScene.getWindow().close()
        ;});
    }
}
