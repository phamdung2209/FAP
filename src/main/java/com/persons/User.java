package com.persons;

import com.Date.DateOfBirth;
import com.persons.persionType.PersonType;

enum genderType {
    MALE, FEMALE, OTHER
}

public abstract class User {
    private String id;
    private String fullName;
    private DateOfBirth dateOfBirth;
    private genderType gender;
    private String address;
    private String phoneNumber;
    private String email;

    public User() {

    }

    public User(String id, String fullName, DateOfBirth dateOfBirth, genderType gender, String address,
            String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Factory method - Creational Pattern
    public static User getUser(PersonType personType) {
        switch (personType) {
            case ADMINISTRATOR:
                // Singleton pattern - Creational Pattern
                return Administrator.getAdministrator();
            case STUDENT:
                return new Student();
            case LECTURER:
                return new Lecturer();

            // if have more person type, add here:
            // case STAFF:
            // return new Staff();
            // case PARENT:
            // return new Parent();
            default:
                throw new IllegalArgumentException("No such person type");
        }
    } 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public genderType getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("male")) {
            this.gender = genderType.MALE;
        } else if (gender.equals("female")) {
            this.gender = genderType.FEMALE;
        } else {
            this.gender = genderType.OTHER;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // login and logout
    public boolean login(String username, String password) {
        if (username.equals("phamdung2209")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean logout() {
        return true;
    }

}
