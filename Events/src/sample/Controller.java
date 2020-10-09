package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label labelThatDisplaysIfBackgroundThreadIsReady;

    @FXML
    public void initialize(){
        disableButtons(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
        printMessageCorrespondingToButtonPressed(e);
        new Thread(keepBusyAndDisplayWhenReady()).start();
        clearFieldIfButtonIsSelected();
    }

    private Runnable keepBusyAndDisplayWhenReady(){
        return new Runnable() {
            @Override
            public void run() {
                String s = Platform.isFxApplicationThread() ? "UI Thread" : "thread" + Thread.currentThread().toString();
                System.out.println(s);
                keepThreadBusyForTenSeconds();
                Platform.runLater(displayReadyMessage());
            }
        };
    }

    private Runnable displayReadyMessage(){
        return new Runnable() {
            @Override
            public void run() {
                labelThatDisplaysIfBackgroundThreadIsReady.setText("The task is completed.");
                String s = Platform.isFxApplicationThread() ? "UI Thread" : "thread" + Thread.currentThread().toString();
                System.out.println(s);
            }
        };
    }

    private void keepThreadBusyForTenSeconds(){
        String s = Platform.isFxApplicationThread() ? "UI Thread" : "thread" + Thread.currentThread().toString();
        System.out.println(s);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    private void printMessageCorrespondingToButtonPressed(ActionEvent e){
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello, " + nameField.getText());
        } else if(e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());
        }
    }

    private void clearFieldIfButtonIsSelected(){
        if(ourCheckBox.isSelected()){
            nameField.clear();
            disableButtons(true);
        }
    }

    private void disableButtons(boolean disable){
        helloButton.setDisable(disable);
        byeButton.setDisable(disable);
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        disableButtonsIfTextFieldIsEmpty(text);
    }

    private void disableButtonsIfTextFieldIsEmpty(String text){
        boolean disable = text.isEmpty() || text.trim().isEmpty();
        disableButtons(disable);
    }

    @FXML
    public void handleChange(){
        System.out.println("The CheckBox is " + (ourCheckBox.isSelected()? "selected" : "not selected"));
    }
}
