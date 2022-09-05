package by.step.test.service;
import by.step.test.dao.entity.PhoneBook;

public interface AbstructPhoneBookService {

    String getPhoneBook();
    PhoneBook getPhoneBookObject();
    PhoneBook createPhoneBook(String phoneNumber, String name, String sureName);
    PhoneBook delitePhoneBookObject();

}
