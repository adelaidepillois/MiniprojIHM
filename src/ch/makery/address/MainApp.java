package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.ButtonMenuViewController;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main of Application
 * @author Pillois Adélaïde Perrine Marcou
 */
public class MainApp extends Application {

    private Stage primaryStage;


    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster","1995", "M2", "Imagerie"));
        personData.add(new Person("Ruth", "Mueller","1997", "M1", "Biotechnologie"));
        personData.add(new Person("Heinz", "Kurz","1996", "M2", "Physiologie"));
        personData.add(new Person("Cornelia", "Meier","1999", "L3", ""));
        personData.add(new Person("Werner", "Meyer","1995", "M2", "Imagerie"));
        personData.add(new Person("Lydia", "Kunz","1997","M1", "Physiologie"));
        personData.add(new Person("Anna", "Best","1998", "M2", "Imagerie"));
        personData.add(new Person("Stefan", "Meier","1998", "M1", "Imagerie"));
        personData.add(new Person("Martin", "Mueller","1999", "M1", "Biotechnologie"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }





    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion des étudiants GPHY");

        showButtonMenuView();
    }


    /**
     * Shows the person overview inside the root layout.
     */
    public boolean showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            //Show the scene containing.
            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);
            primaryStage.show();


            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showButtonMenuView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ButtonMenuView.fxml"));
            AnchorPane buttonMenuView = (AnchorPane) loader.load();
            //Show the scene containing.
            Scene scene = new Scene(buttonMenuView);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Give the controller access to the main app.
            ButtonMenuViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}