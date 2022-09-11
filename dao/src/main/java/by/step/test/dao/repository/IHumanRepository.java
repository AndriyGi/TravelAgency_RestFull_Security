package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHumanRepository extends JpaRepository<Human, Long> {

//    List<Human> findAll();
//    Human save(Human human);
//    Human delete(Human human);

}
