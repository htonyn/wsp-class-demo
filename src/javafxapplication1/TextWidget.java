package javafxapplication1;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.scene.layout.Priority;
import javafx.beans.value.*;
import javafx.beans.binding.*;
import javafx.event.*;

public class TextWidget extends GridPane {
    public TextWidget() {
        TextField field = new TextField();
        add(field, 0, 0);
        field.setOnAction(
            (event) -> System.out.println("Text: " + field.getText())
        );
        
        field.setPromptText("put words");
        // A field that is not editable can still be enabled.
        // Not editable fields work well as a display
        
        Button b = new Button("Print");
        add(b, 0, 1);
        b.setOnAction(
            event -> System.out.println(field.getText())
        );
        b.setDefaultButton(true);
        // This print is not shown due to the field consuming the event, thus
        // the default is no longer activated
        
        TextArea area = new TextArea();
        add(area, 0, 2);
        // The default text area is larger than the default text field
        // And due to the fact that the text area and the text field are in
        // the same column, the text field now matches the text area width
        
        setHgrow(area, Priority.ALWAYS);
        setVgrow(area, Priority.ALWAYS);
        
        HTMLEditor editor = new HTMLEditor();
        add(editor, 0, 3);
        // The editor contains an HTML inside. So disabling non editable
        // would make it READ ONLY
    }
}
