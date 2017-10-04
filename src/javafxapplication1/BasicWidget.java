/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.scene.control.*;
import javafx.scene.layout.*; // GridPane and priority comes from here
import javafx.scene.text.*;

import javafx.stage.Stage;

public class BasicWidget extends GridPane {
    public BasicWidget() {
        Label l = new Label("A Label");
        add(l, 0, 0);

        Region r = new Region();
        GridPane.setHgrow(r, Priority.ALWAYS);
        GridPane.setVgrow(r, Priority.ALWAYS);
        add(r, 1, 1);

        Button b = new Button("A Button");
        add(b, 2, 2);
    }
}