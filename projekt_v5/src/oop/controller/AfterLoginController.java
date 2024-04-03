package oop.controller;


import javafx.stage.Stage;
import oop.model.program.Model;
import oop.view.AfterLoginScene;
import oop.view.CreateSurveyScene;
import oop.view.VotePop;
public class AfterLoginController {
    private AfterLoginScene afterLoginScene;
    private Model model;
    //private BeforeLoginController beforeLoginController;
    public AfterLoginController(AfterLoginScene afterLoginScene, Model model,BeforeLoginController beforeLoginController) {
        this.afterLoginScene = afterLoginScene;
        this.model = model;

        //System.out.println(beforeLoginController.getCurrentUsername());
        afterLoginScene.getCreateSurvey().setMaxWidth(160);
        afterLoginScene.getCreateSurvey().setOnAction(e -> {
            Stage creativeStage = new Stage();
            new CreativeSurveyController(new CreateSurveyScene(creativeStage),model,beforeLoginController);//model
            //afterLoginScene.getWindow().close();
        });

        afterLoginScene.getVoteInSurvey().setMaxWidth(160);
        afterLoginScene.getVoteInSurvey().setOnAction(e -> {
            Stage votePopStage = new Stage();
            new VotePopController(new VotePop(votePopStage),model, votePopStage);//model
        });

        afterLoginScene.getManageSurveys().setMaxWidth(160);
        afterLoginScene.getManageSurveys().setOnAction(e-> {
            model.usernameFinder(beforeLoginController.getCurrentUsername());
            //Stage managingStage = new Stage();
        });

        afterLoginScene.getLogOffButton().setOnAction(e ->
            afterLoginScene.getWindow().close());
    }

}