package javafxapplication1;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.layout.Priority;

import javafx.beans.value.*;
import javafx.beans.binding.*;

public class BarWidget extends GridPane {
    public BarWidget() {
        ProgressBar bar = new ProgressBar();
        add(bar, 0, 0);
        
        GridPane.setHgrow(bar, Priority.ALWAYS);
        
        ProgressIndicator ind = new ProgressIndicator();
        add(ind, 1, 0);
        
        Slider slider = new Slider(-0.3, 1.0, 0.0);
        add(slider, 0, 1, 2, 1);
        
        bar.progressProperty().bind(slider.valueProperty());
        ind.progressProperty().bind(slider.valueProperty());
        
        Image img = new Image("file:737385.jpg");
        ImageView iview = new ImageView(img);
        
        //PanelWidget panel = new PanelWidget();
        
        ScrollPane scroller = new ScrollPane();
        add(scroller, 0, 2, 2, 1);
        scroller.setContent(iview);
        //        add(iview, 0, 2, 2, 1);
        //        scroller.setContent(panel);
        
        TabPane pane = new TabPane();
        add(pane, 0, 3, 2, 1);
        
        Button b = new Button("Add Tab");
        add(b, 1, 4);
        
        b.setOnAction(
            (event) -> {
                Tab t = new Tab();
                t.setText("New Tab");
                t.setContent(new ImageView(img)); // single component
                pane.getTabs().add(t);
            }
        );
    }
}
