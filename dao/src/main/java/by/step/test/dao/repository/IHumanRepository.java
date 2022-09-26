package by.step.test.dao.repository;

import by.step.test.dao.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHumanRepository extends JpaRepository<Human, Long> {


//    @Query(value = "SELECT '*' FROM human", nativeQuery = true)
    List<Human> findAll();

    Human save(Human human);

    //@Query(value = "DELETE FROM Human where Human.id=5")
    void deleteById(Long id);

    Optional<Human> findById(Long id);

//    Optional<Human> findById(Long id);


//    @Query(value = "UPDATE vaucher " +
//            "set human_id=:humanId " +
//            "where id = :vaucherId"
//            , nativeQuery = true)
//    Human attachVauchers_toHuman(@Param("humanId") Long humanId
//            , @Param("vaucherId") Long vaucherId);


//    List<Human> findAllByName(String name);
//    List<Human> findAllBySurnameAndAge(String surname, Integer age);
}
