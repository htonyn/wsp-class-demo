package javafxapplication1;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

import javafx.event.*;

// Command
// Edit: Cut
// ActionListener <ActionEvent> { }

class MenuWidget extends VBox {
    public MenuWidget() {
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("File");
        
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        
        GridPane pane = new GridPane();
        VBox.setVgrow(pane, Priority.ALWAYS);
        
        pane.setStyle("-fx-grid-lines-visible: true; -fx-strike: black;");
        
        Button b = new Button("I am a Button");
        // VBox vs GridPane
        // Keeping an item at the top of the window is easier with a VBox than
        // using a GridPane. Cannot use setVGrow?
        pane.add(b, 0, 1);
        saveItem.setOnAction(
            (ActionEvent event) -> {
                System.out.println("Save clicked!");
            }
        );
        
        SeparatorMenuItem sep = new SeparatorMenuItem();
        Menu recents = new Menu("Recent Items");
        
        menu.getItems().addAll(openItem, saveItem, sep, recents);
        bar.getMenus().addAll(menu);
        MenuItem liesItem = new MenuItem("Lies");
        MenuItem secretItem = new MenuItem("Secrets");
        recents.getItems().addAll(liesItem, secretItem);
        
        this.getChildren().addAll(bar);
        this.getChildren().add(pane);
    }
}