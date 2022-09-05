package by.step.test.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneBook {

//    private String phoneBook;
    private String phoneNumber;
    private String name;
    private String sureName;

    public PhoneBook() {
    }

    public PhoneBook(String phoneNumber, String name, String sureName) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.sureName = sureName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
}
