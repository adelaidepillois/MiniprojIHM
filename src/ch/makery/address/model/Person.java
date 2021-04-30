package ch.makery.address.model;

import javafx.beans.property.*;


/**
 * Model class for a Person.
 *
 * @author Pillois Adélaïde Perrine Marcou
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty birthday;
    private final StringProperty promo;
    private final StringProperty option;


    /**
     * Default constructor.
     */
    public Person() {
        this("", "", "", "", "");
    }

    /**
     * Constructor with some initial data.
     *  @param firstName
     * @param lastName
     *
     *
     */
    public Person(String firstName, String lastName, String birthday, String promo, String option) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.promo = new SimpleStringProperty(promo);
        this.option = new SimpleStringProperty(option);
        this.birthday = new SimpleStringProperty(birthday);

    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }



    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }



    public StringProperty promoProperty() {
        return promo;
    }
    public String getPromo() {
        return promo.get();
    }
    public void setPromo(String promo) {
        this.promo.set(promo);
    }



    public StringProperty optionProperty() {
        return option;
    }
    public void setOption(String option) {
        this.option.set(option);
    }
    public String getOption() {
        return option.get();
    }



    public String getBirthday() {
        return birthday.get();
    }
    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }
    public StringProperty birthdayProperty() {
        return birthday;
    }

}
