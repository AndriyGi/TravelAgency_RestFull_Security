package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHumanRepository extends JpaRepository<Human, Long> {

    List<Human> findAllByName(String name);

    List<Human> findAllBySurnameAndAge(String surname, Integer age);




//    List<Human> findAll();
//    Human save(Human human);
//    Human delete(Human human);

}
