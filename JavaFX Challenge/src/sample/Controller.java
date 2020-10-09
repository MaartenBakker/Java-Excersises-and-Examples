package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.util.Optional;

public class Controller {
    @FXML
    private GridPane mainGridPane;
    @FXML
    private TableView<Contact> tableView;
    @FXML
    private TableColumn<Contact, String> firstName;
    @FXML
    private TableColumn<Contact, String> lastName;
    @FXML
    private TableColumn<Contact, String> phoneNumber;
    @FXML
    private TableColumn<Contact, String> notes;



    public void initialize(){
//        Contact contact = new Contact();
//        contact.setFirstName("Maarten");
//        contact.setLastName("Bakker");
//        contact.setPhoneNumber("1234567");
//        contact.setNotes("Hoi hoi");
//        ContactData.getInstance().addContact(contact);

//        contact = new Contact();
//        contact.setFirstName("Anna");
//        contact.setLastName("Zeijlemaker");
//        contact.setPhoneNumber("0987654321");
//        contact.setNotes("Ja ja");
//        ContactData.getInstance().addContact(contact);


        tableView.setItems(ContactData.getInstance().getContacts());
        firstName.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));
        notes.setCellValueFactory(new PropertyValueFactory<Contact, String>("notes"));
    }

    @FXML
    public void handleDeleteAction(){
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            Contact contactToDelete = tableView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + contactToDelete.getFirstName()
                    + " " + contactToDelete.getLastName() + "?",
                    ButtonType.OK, ButtonType.CANCEL);

            Button okButton = (Button) alert.getDialogPane().lookupButton((ButtonType.OK));
            okButton.setDefaultButton(false);
            Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setDefaultButton(true);

            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                ContactData.getInstance().removeContact(contactToDelete);
            }
        }
    }

    @FXML
    public void handleAddNewAction(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("New Contact");
        dialog.setHeaderText("Add Contact Information");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField firstName = new TextField();
        firstName.setPromptText("First Name");

        TextField lastName = new TextField();
        lastName.setPromptText("Last Name");

        TextField phoneNumber = new TextField();
        phoneNumber.setPromptText("Phone Number");

        TextField notes = new TextField();
        notes.setPromptText("Notes");

        gridPane.add(new Label("First Name"),0,0);
        gridPane.add(firstName, 0, 1);

        gridPane.add(new Label("Last Name"), 1, 0);
        gridPane.add(lastName, 1,1);

        gridPane.add(new Label("Phone Number"), 2, 0);
        gridPane.add(phoneNumber, 2,1);

        gridPane.add(new Label("Notes"), 3, 0);
        gridPane.add(notes, 3, 1);

        dialog.getDialogPane().setContent(gridPane);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Contact newContact = new Contact(firstName.getText(), lastName.getText(), phoneNumber.getText(),
                    notes.getText());
            ContactData.getInstance().addContact(newContact);
        }
    }

    @FXML
    public void handleEditAction(){
        Contact contactToEdit = tableView.getSelectionModel().getSelectedItem();


        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Edit Contact Information");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField firstName = new TextField();
        firstName.setText(contactToEdit.getFirstName());

        TextField lastName = new TextField();
        lastName.setText(contactToEdit.getLastName());

        TextField phoneNumber = new TextField();
        phoneNumber.setText(contactToEdit.getPhoneNumber());

        TextField notes = new TextField();
        notes.setText(contactToEdit.getNotes());

        gridPane.add(new Label("First Name"),0,0);
        gridPane.add(firstName, 0, 1);

        gridPane.add(new Label("Last Name"), 1, 0);
        gridPane.add(lastName, 1,1);

        gridPane.add(new Label("Phone Number"), 2, 0);
        gridPane.add(phoneNumber, 2,1);

        gridPane.add(new Label("Notes"), 3, 0);
        gridPane.add(notes, 3, 1);

        Button okButton = (Button) dialog.getDialogPane().lookupButton((ButtonType.OK));
        okButton.setDefaultButton(false);
        Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setDefaultButton(true);


        dialog.getDialogPane().setContent(gridPane);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Contact newContact = new Contact(firstName.getText(), lastName.getText(), phoneNumber.getText(),
                    notes.getText());
            ContactData.getInstance().replaceContact(contactToEdit, newContact);
        }

    }

    @FXML
    public void handleKeyPressed(KeyEvent e){
        if (e.getCode() == KeyCode.ENTER) {
            handleEditAction();
        }
        if (e.getCode() == KeyCode.DELETE) {
            handleDeleteAction();
        }
    }
}
