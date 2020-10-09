package com.maartenbakker.todolist;

import com.maartenbakker.todolist.datamodel.ToDoData;
import com.maartenbakker.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadLinePicker;

    public ToDoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLineValue= deadLinePicker.getValue();

        ToDoItem toDoItem = new ToDoItem(shortDescription,details, deadLineValue);
        ToDoData.getInstance().addToDoItem(toDoItem);
        return toDoItem;
    }


}
