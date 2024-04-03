package oop.model.program;

import javafx.stage.Stage;
import oop.controller.BeforeLoginController;
import oop.controller.CreativeSurveyController;
import oop.controller.VotePopController;
import oop.view.AlertBoxUniv;
import oop.view.BeforeLoginScene;
import oop.view.CreateSurveyScene;
import oop.view.VoteSurveyScene;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ModelInterface {
    void userAuth(String username, String password, BeforeLoginScene beforeLoginScene,
                  BeforeLoginController beforeLoginController, AlertBoxUniv alertBoxUniv);
    void logOff();
    String behaviorChoiceBox(CreateSurveyScene createSurveyScene,
                             CreativeSurveyController creativeSurveyController, Map<String, String> questionTextMap);
    void initQuestionContentMap(CreateSurveyScene createSurveyScene);
    //void showOptions(CreateSurveyScene createSurveyScene,String question);
    int codeGenerator();
    void writingFile(int code, BeforeLoginController beforeLoginController,
                     CreateSurveyScene createSurveyScene, Map<String, String> questionTextMap);
    void codeFinder(int code, Stage primaryStage, Map<String, List<String>> questionsWithOptions, Map<String,
            String> optionsToQuestions, VotePopController votePopController);
    void storingVotes(int code, VotePopController votePopController, VoteSurveyScene voteSurveyScene);
    void usernameFinder(String username);
    void ownSurveyFinder(ArrayList<String> codesList);
    void managing();
}
