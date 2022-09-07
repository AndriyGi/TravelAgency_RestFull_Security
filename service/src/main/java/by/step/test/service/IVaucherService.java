package by.step.test.service;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;

import java.util.List;

public interface IVaucherService {

    List <Vaucher > findAllVauchers();
    Vaucher saveNewVaucher(Vaucher vaucher);

    List<VaucherType> findAllVaucherTypes();
    VaucherType saveNewVaucherType(VaucherType vaucherType);

}
