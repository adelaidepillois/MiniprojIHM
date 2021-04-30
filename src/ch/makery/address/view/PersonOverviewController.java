package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
     * @author Pillois Adélaïde Perrine Marcou
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

    }


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

    @FXML
    private void retourButton() {
            mainApp.showButtonMenuView();
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