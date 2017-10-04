/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;

public class JavaFXApplication1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Window");
        
        GridPane root = new GridPane();
        

        
//        menuInterface(root);
//        alertInterface(root);
        barInterface(root);
//        checkBoxInterface(root);
//        textBoxInterface(root);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
    
    public static void menuInterface(GridPane input) {
        MenuWidget mw = new MenuWidget();
        input.add(mw, 0, 0);
        input.setHgrow(mw, Priority.ALWAYS);
        input.setVgrow(mw, Priority.ALWAYS);
    }
    
    public static void alertInterface(GridPane input) {
        AlertWidget a = new AlertWidget();
        input.add(a, 0, 0);
    }
    
    public static void barInterface(GridPane input) {
        BarWidget bw = new BarWidget();
        input.add(bw, 0, 0);
        input.setHgrow(bw, Priority.ALWAYS);
    }
    
    public static void textBoxInterface(GridPane input) {
        TextWidget textWidget = new TextWidget();
        input.add(textWidget, 0, 0);
        input.setHgrow(textWidget, Priority.ALWAYS);
    }
    
    public static void checkBoxInterface(GridPane input) {
        ClassWidget checkBoxWidget = new ClassWidget();
        input.add(checkBoxWidget, 0, 0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
