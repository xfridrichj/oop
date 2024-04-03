package oop.view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class AlertBoxUniv {
    public static void display(String title){
        Stage windowV = new Stage();
        windowV.initModality(Modality.APPLICATION_MODAL);
        windowV.setMinWidth(300);

        Label label1 = new Label(title);

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label1);

        Scene scene = new Scene(layout,300,100);

        windowV.setScene(scene);
        windowV.showAndWait();

    }
}
