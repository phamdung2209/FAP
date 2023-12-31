package com.persons;

import com.date.DateOfBirth;
import com.func.View;
import com.persons.personType.PersonType;

enum genderType {
    MALE, FEMALE, OTHER
}

public abstract class User implements View {
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

    // Builder pattern - Creational Pattern
    public User(UserBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
    }

    public static class UserBuilder {
        private String id;
        private String fullName;

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public User build() {
            return new User(this) {
                @Override
                public void viewCourse() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'viewCourse'");
                }

                @Override
                public void viewGrade() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'viewGrade'");
                }

                @Override
                public void viewTimetable() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'viewTimetable'");
                }

                @Override
                public void viewClass() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'viewClass'");
                }
            };
        }
    }

    // Factory method - Creational Pattern
    public static View getUser(PersonType personType) {
        switch (personType) {
            case ADMINISTRATOR:
                // Singleton pattern - Creational Pattern
                return Administrator.getAdministrator();
            case STUDENT:
                return Student.getStudent();
            case LECTURER:
                return Lecturer.getLecturer();

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
