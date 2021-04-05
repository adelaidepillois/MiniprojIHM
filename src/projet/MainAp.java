package projet;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projet.model.Etudiant;

public class MainAp extends Application {

    private Stage primaryStage;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Etudiant> etudiantData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainAp() {
        // Add some sample data
        etudiantData.add(new Etudiant("Hans", "Muster"));
        etudiantData.add(new Etudiant("Ruth", "Mueller"));
        etudiantData.add(new Etudiant("Heinz", "Kurz"));
        etudiantData.add(new Etudiant("Cornelia", "Meier"));
        etudiantData.add(new Etudiant("Werner", "Meyer"));
        etudiantData.add(new Etudiant("Lydia", "Kunz"));
        etudiantData.add(new Etudiant("Anna", "Best"));
        etudiantData.add(new Etudiant("Stefan", "Meier"));
        etudiantData.add(new Etudiant("Martin", "Mueller"));
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Projet");

        showButtonMenuView();
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showButtonMenuView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAp.class.getResource("view/ButtonMenuView.fxml"));
            AnchorPane buttonMenuView = (AnchorPane) loader.load();
            // Show the scene containing.
            Scene scene = new Scene(buttonMenuView);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Etudiant> getEtudiantData() {
        return etudiantData;
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}