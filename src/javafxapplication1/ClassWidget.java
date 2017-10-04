package javafxapplication1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.binding.*;

public class ClassWidget extends GridPane {
    public ClassWidget() {
        CheckBox cb = new CheckBox("Check Me!");
        add(cb, 0, 0);
        cb.selectedProperty().set(true);
        
        Button b = new Button("Print");
        add(b, 0, 50);
        b.setOnAction(
            (event) -> System.out.println(cb.selectedProperty().get())
        );
        
//        b.disableProperty().set(true);
//        // disableProperty is read and write
//        // disabledProperty is read ONLY
//        // the disabledProperty is inherited from its parent up the tree
//        
//        cb.setOnAction(
//            (event) -> {
//                if(cb.selectedProperty().get()) {
//                    b.disableProperty().set(false);
//                } else {
//                    b.disableProperty().set(true);
//                }
//            }
//        );

        b.disableProperty().bind(Bindings.not(cb.selectedProperty()));
        
        ToggleGroup tga = new ToggleGroup();
        
        RadioButton ra1 = new RadioButton("ra1");
        add(ra1, 0, 1);
        ra1.setToggleGroup(tga);
        
        RadioButton ra2 = new RadioButton("ra2");
        add(ra2, 0, 2);
        ra2.setToggleGroup(tga);
        
        RadioButton rb1 = new RadioButton("rb1");
        add(rb1, 1, 1);
        
        tga.selectedToggleProperty().addListener(
            (observable, void_val, new_val) -> {
                if (new_val == ra1) {
                    System.out.println("RA1");
                } else if (new_val == ra2) {
                    System.out.println("RA2");
                }
            }
        );
        
        ComboBox<String> combo = new ComboBox<String>();
        combo.getItems().addAll("One", "Two", "Three");
        add(combo, 0, 3);
        
        combo.valueProperty().addListener(
            (observable, old_val, new_val) -> {
                System.out.println(new_val);
            }
        );
        // The Combo Box, if not set to an initial value, can still be assigned
        // to a null value on start-up despite there not being a null value added to the 
        // list of items of the combo box
        b.setOnAction(
                (event) -> System.out.println(combo.getValue())
        );
        // The setOnAction method for a button can only be set to ONE event
        // action at a time
        
    }
}