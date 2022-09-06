package by.step.test.dao.repository;
import by.step.test.dao.entity.PhoneBook;
import java.util.List;

public interface AbstructPhoneBookRepository {

    List<PhoneBook> getPhoneBookList();
    PhoneBook createPhoneBook();
    List<PhoneBook> getNumber();


}
