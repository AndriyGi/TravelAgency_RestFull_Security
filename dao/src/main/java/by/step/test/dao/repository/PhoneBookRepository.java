package by.step.test.dao.repository;

import by.step.test.dao.entity.PhoneBook;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PhoneBookRepository implements AbstructPhoneBookRepository {

    private List<PhoneBook> phoneBookList;

    public PhoneBookRepository(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
        phoneBookList.add(new PhoneBook("+375", "Vova"
                , "Petrov"));
        phoneBookList.add(new PhoneBook("+232", "Ivan"
                , "Ivanov"));
    }

    @Override
    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }


    @Override
    public List<PhoneBook> createPhoneBook() {
        return  (phoneBookList.add();
    }


    @Override
    public List<PhoneBook> getNumber() {
        return null;
    }


}
