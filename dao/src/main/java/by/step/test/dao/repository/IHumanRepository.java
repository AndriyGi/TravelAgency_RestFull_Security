package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IHumanRepository extends JpaRepository<Human, Long> {

    List<Human> findAllByName(String name);

    List<Human> findAllBySurnameAndAge(String surname, Integer age);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM Human",nativeQuery = true)
    List<Human> findAllHumans();



//    List<Human> findAll();
//    Human save(Human human);
//    Human delete(Human human);

}
