package by.step.test.dao.repository;

import by.step.test.dao.entity.Vaucher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IVaucherRepository extends JpaRepository<Vaucher, Long> {



//    List<Vaucher> findAllVauchers();
//    Vaucher findById(Long id);
//    Vaucher saveNewVaucher(Vaucher vaucher);
//    Vaucher deleteVaucher(Vaucher vaucher);


//    Optional<VaucherType> findAllByVaucherType(VaucherType vaucherType);
//    VaucherType saveNewVaucherType(VaucherType vaucherType);

}
