package projet.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Etudiant {

    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty promo;
    private final StringProperty option;
    private final ObjectProperty<LocalDate> birthday;

    /**
     * Default constructor.
     */
    public Etudiant() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param nom
     * @param prenom
     */
    public Etudiant(String nom, String prenom) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);

        // Some initial dummy data, just for convenient testing.
        this.promo = new SimpleStringProperty("L3/M1/M2");
        this.option = new SimpleStringProperty("imagerie/physiologie/biotechnologie");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getPromo() {
        return promo.get();
    }

    public void setPromo(String promo) {
        this.promo.set(promo);
    }

    public StringProperty promoProperty() {
        return promo;
    }

    public String getOption() {
        return option.get();
    }

    public void setOption(String option) {
        this.option.set(option);
    }

    public StringProperty optionProperty() {
        return option;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}