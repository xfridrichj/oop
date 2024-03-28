package oop.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Voting {
    public static void display() {
        Stage windowV = new Stage();
        windowV.setTitle("Voting Window");

        Label label1 = new Label("Zadajte kod:");
        TextField codeField = new TextField();
        Button confirmCode = new Button("Potvrdiť");

        GridPane layout1 = new GridPane();
        layout1.setVgap(10);
        layout1.setHgap(10);
        layout1.add(label1, 0, 0);
        layout1.add(codeField, 1, 0);
        layout1.add(confirmCode, 1, 1);

        Scene preCodeScene = new Scene(layout1, 400, 250);

        windowV.setScene(preCodeScene);
        windowV.show();
    }
}
