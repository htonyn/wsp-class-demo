package javafxapplication1;

import java.io.File;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.util.Optional;
import javafx.stage.FileChooser.ExtensionFilter;

public class AlertWidget extends GridPane {
    public AlertWidget() {
        Button windowB = new Button("Window");
        add(windowB, 0, 0);
        Button alertB = new Button("Alert");
        add(alertB, 1, 0);
        alertB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Welcome Back!", ButtonType.OK);
                a.initOwner(getOwnerWindow());
                Optional<ButtonType> result = a.showAndWait();
                
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    System.out.println("Yay windowed programming!");
                }
            }
        });
        
        Button saveB = new Button("Save");
        add(saveB, 2, 0);
        saveB.setOnAction(
            (event) -> {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Choose a File");
                chooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Source Files", "*.java", "*.py"),
                    new ExtensionFilter("All Files", "*")
                );
                List<File> fs =  (List) chooser.showSaveDialog(getOwnerWindow());
                if (fs != null) {
                    for (File f: fs) {
                        System.out.println(f.getName());
                    }
                } else {
                    System.out.println("Nothing was selected");
                }
            }
        );
    }
    private Window getOwnerWindow() {
        Scene parentScene = this.getScene();
        if (parentScene != null) {
            return parentScene.getWindow();
        }
        return null;
    }
}