package ch.makery.address.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ch.makery.address.model.Person;



/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    ObservableList<String> promoList = FXCollections.observableArrayList("L3", "M1", "M2");
    ObservableList<String> optionList = FXCollections.observableArrayList("Imagerie", "Biotechnologie", "Physiologie");

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthdayField;

    @FXML
    private ChoiceBox<String> promoBox, optionBox;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;



    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        promoBox.setValue("");
        promoBox.getItems().addAll(promoList);
        promoBox.setOnAction(this::getPromotion);

        optionBox.setValue("");
        optionBox.getItems().addAll(optionList);
        optionBox.setOnAction(this::getSpecialite);


    }



    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        birthdayField.setText(person.getBirthday());

        promoBox.setValue(person.getPromo());
        if (person.getPromo().equals("M1") || person.getPromo().equals("M2")) {
            optionBox.setValue(person.getOption());
        }
        else {
            optionBox.setDisable(true);
            optionBox.setValue(null);
        }

    }


    /**
     * Get Promo on action.
     *
     *
     */

    private String getPromotion (javafx.event.ActionEvent e) {
        String promotion = promoBox.getValue();
        if (promotion.equals("L3")) {
            optionBox.setDisable(true);
        }
        else {
            optionBox.setDisable(false);
        }
        return promoBox.getValue();
    }

    /**
     * Get Option on action.
     *
     *
     */
    public String getSpecialite (javafx.event.ActionEvent e) {
        if (getPromotion(e).equals("M1") || getPromotion(e).equals("M2")) {
            return optionBox.getValue();
        }
        else {
            return null;
        }
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setBirthday(birthdayField.getText());
            person.setPromo(promoBox.getValue());
            person.setOption(optionBox.getValue());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0 || birthdayField.getText().length() > 4) {
                errorMessage += "No valid year of birth you must enter 4 integer !\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}