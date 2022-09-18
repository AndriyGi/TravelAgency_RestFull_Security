package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHumanRepository extends JpaRepository<Human, Long> {


    //    List<Human> findAll();
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Query(value = "SELECT * FROM Human", nativeQuery = true)
    List<Human> findAll();

        Human save(Human human);
//    @Query(value = "INSERT INTO human (name, surname, age), VALUES('VASYA', 'Vasiliev', 22)")
//    Human save(Human human);

//@Query(value = "DELETE FROM Human where Human.id=5")
    void deleteById( Long id);


    Optional<Human> findById(Long id);


//    List<Human> findAllByName(String name);
//
//    List<Human> findAllBySurnameAndAge(String surname, Integer age);
}
