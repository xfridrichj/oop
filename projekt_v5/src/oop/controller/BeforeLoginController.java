package oop.controller;

import javafx.stage.Stage;
import oop.view.BeforeLoginScene;
import oop.view.AlertBoxUniv;
import oop.model.program.Model;

import oop.view.AfterLoginScene;

public class BeforeLoginController {
    private BeforeLoginScene beforeLoginScene;
    private Model model;
    private String currentUsername;
    private String currentPassword;

    public BeforeLoginController(BeforeLoginScene beforeLoginScene, Model model) {
        this.beforeLoginScene = beforeLoginScene;
        this.model = model;

        beforeLoginScene.getCloseButton().setOnAction(e -> beforeLoginScene.getWindow().close());
        beforeLoginScene.getLoginButton().setOnAction(e -> {
            currentUsername = beforeLoginScene.getUsernameField().getText();
            currentPassword = beforeLoginScene.getPasswordField().getText();
            setCurrentUsername(currentUsername);

            System.out.println(currentPassword);

            model.userAuth(currentUsername,currentPassword, beforeLoginScene,this,new AlertBoxUniv());
        });
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}