package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;

public class ButtonMenuViewController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Called when the user clicks the new button on the menu. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }
    /**
     * Called when the user clicks the second button of the menu. Opens a dialog to show
     * all person.
     */
    @FXML
    private void handleShowPerson() {
        boolean okClicked = mainApp.showPersonOverview();
        if (okClicked) {
            mainApp.getPersonData();
        }
    }


}


