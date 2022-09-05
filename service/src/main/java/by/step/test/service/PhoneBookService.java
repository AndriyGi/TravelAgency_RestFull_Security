package by.step.test.service;

import by.step.test.dao.entity.PhoneBook;
import by.step.test.dao.repository.AbstructPhoneBookRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService implements AbstructPhoneBookService {


    private AbstructPhoneBookRepository phoneBookRepository;

    public PhoneBookService(AbstructPhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @Override
    public String getPhoneBook() {
        return phoneBookRepository.getPhoneBookList().stream()
                .filter(phoneBook -> phoneBookRepository.getPhoneBookList().)
    }

    @Override
    public PhoneBook getPhoneBookObject() {
        return phoneBookRepository.getPhoneBookList()
                .stream().findAny().get();
    }

    @Override
    public PhoneBook createPhoneBook(String phoneNumber, String name, String sureName) {
        return new PhoneBook(phoneNumber, name, sureName);
    }

    @Override
    public PhoneBook delitePhoneBookObject() {
        return null;
    }
}
