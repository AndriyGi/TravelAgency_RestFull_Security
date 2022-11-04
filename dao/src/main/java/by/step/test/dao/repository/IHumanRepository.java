package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHumanRepository extends JpaRepository<Human, Long> {


   // @Query(value = "SELECT '*' FROM human", nativeQuery = true)
    List<Human> findAll();

    Human save(Human human);

    //@Query(value = "DELETE FROM Human where Human.id=5")
    void deleteById(Long id);

    Optional<Human> findById(Long id);

    Optional<Human> findByMail(String mail);

}
