package ch.makery.address.view;

import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> birthdayColumn;
    @FXML
    private TableColumn<Person, String> promoColumn;
    @FXML
    private TableColumn<Person, String> optionColumn;


    // Reference to the main application.
    private MainApp mainApp;


    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the columns.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
        birthdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().birthdayProperty());
        promoColumn.setCellValueFactory(
                cellData -> cellData.getValue().promoProperty());
        optionColumn.setCellValueFactory(
                cellData -> cellData.getValue().optionProperty());

        // Clear person details.
        /*showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));*/
    }


        /**
         * Fills all text fields to show details about the person.
         * If the specified person is null, all text fields are cleared.
         *
         * @param person the person or null
         */
    /*private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameColumn.setText(person.getFirstName());
            lastNameColumn.setText(person.getLastName());
            //birthdayColumn.setText(person.getBirthday());//utilise fonction convertion date to string
            promoColumn.setText(person.getPromo());
            optionColumn.setText(person.getOption());

        } else {
            // Person is null, remove all the text.
            firstNameColumn.setText("");
            lastNameColumn.setText("");
            birthdayColumn.setText("");
            promoColumn.setText("");
            optionColumn.setText("");
        }
    }*/


        /**
         * Called when the user clicks on the delete button.
         */
   /* @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }*/

        /**
         * Called when the user clicks the new button. Opens a dialog to edit
         * details for a new person.
         */
    /*@FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }*/

        /**
         * Called when the user clicks the edit button. Opens a dialog to edit
         * details for the selected person.
         */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            mainApp.showPersonEditDialog(selectedPerson);

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

        /**
         * Is called by the main application to give a reference back to itself.
         *
         * @param mainApp
         */


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());

    }

}