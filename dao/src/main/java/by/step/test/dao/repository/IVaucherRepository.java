package by.step.test.dao.repository;

import by.step.test.dao.entity.Vaucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IVaucherRepository extends JpaRepository<Vaucher, Long> {

//    @Query(value = "UPDATE Vaucher v set v.human.id=:humanId where v.id = :vaucherId")
//    void attachVaucherss_toHuman(@Param("humanId") Long humanId, @Param("vaucherId") Long vaucherId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vaucher v set v.human.id=:humanId where v.id = :vaucherId")
    Integer attachVaucherss_toHuman(@Param("humanId") Long humanId, @Param("vaucherId") Long vaucherId);



//    List<Vaucher> findAllVauchers();
//    Vaucher findById(Long id);
//    Vaucher saveNewVaucher(Vaucher vaucher);
//    Vaucher deleteVaucher(Vaucher vaucher);


//    Optional<VaucherType> findAllByVaucherType(VaucherType vaucherType);
//    VaucherType saveNewVaucherType(VaucherType vaucherType);

}
