package oop.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BeforeLoginScene{
    private Stage window;
    private Scene loginScene;
    private GridPane layout1 = new GridPane();
    private Button loginButton = new Button("Prihlásiť sa");;
    //private Button backButton = new Button("Späť");
    private Button closeButton = new Button("Ukončiť program");
    //private Button testButton = new Button();
    private Label welcomeLabel =  new Label("Vitajte v Anketaren!");
    private Label usernameLabel = new Label("Meno:");
    private Label passwordLabel = new Label("Heslo:");
    private TextField usernameField = new TextField();
    //private TextField passwordField = new TextField();
    private PasswordField passwordField = new PasswordField();

    public BeforeLoginScene(Stage primaryStage){
        this.window=primaryStage;
        window.setTitle("Anketaren");

        /*VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1,usernameField,passwordField,loginButton,closeButton);*/

        layout1.setPadding(new Insets(30,44,60,30));//t r b l
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);

        //objekty pozicie
        layout1.add(welcomeLabel,1,0);
        layout1.add(usernameLabel,0,1,1,1);
        layout1.add(passwordLabel,0,2,1,1);
        layout1.add(usernameField,1,1,1,1);
        layout1.add(passwordField,1,2,1,1);
        layout1.add(loginButton,1,4,1,1);
        layout1.add(closeButton,1,5,1,1);

        //layout1.add(testButton,2,2,1,1);

        //scena nastavenie
        loginScene = new Scene(layout1, 400, 250);
        window.setScene(loginScene);
        window.show();
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public GridPane getLayout1() {
        return layout1;
    }

    public void setLayout1(GridPane layout1) {
        this.layout1 = layout1;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }


    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
    }

    /*public Button getTestButton() {
        return testButton;
    }

    public void setTestButton(Button testButton) {
        this.testButton = testButton;
    }*/

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(Label welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(Label usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(Label passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

}