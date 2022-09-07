package by.step.test.dao.repository;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;

import java.util.List;

public interface IVaucherRepository {

    List<Vaucher> findAllVauchers();

    Vaucher saveNewVaucher(Vaucher vaucher);

    List<VaucherType> findAllVauchersByTupe();

    VaucherType saveNewVaucherType(VaucherType vaucherType);

}
