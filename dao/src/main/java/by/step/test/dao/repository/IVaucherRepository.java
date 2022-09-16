package by.step.test.dao.repository;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVaucherRepository extends JpaRepository<Vaucher, Long> {

//    List<Vaucher> findAllVauchers();
//    Vaucher findById(Long id);
//    Vaucher saveNewVaucher(Vaucher vaucher);
//    Vaucher deleteVaucher(Vaucher vaucher);

//
//    Optional<VaucherType> findAllByVaucherType(VaucherType vaucherType);
//    VaucherType saveNewVaucherType(VaucherType vaucherType);

}
