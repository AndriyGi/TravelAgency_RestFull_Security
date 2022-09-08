package by.step.test.service;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;

import java.util.List;

public interface IVaucherService {

    List<Vaucher> findAllVauchers();

    Vaucher saveNewVaucher(Vaucher vaucher);

    Vaucher deleteVaucher(Vaucher vaucher);

//    Vaucher getAllVauchers(List<Vaucher> vaucher);

    List<VaucherType> findAllVaucherTypes();

    VaucherType saveNewVaucherType(VaucherType vaucherType);



    Vaucher buildVaucher(VaucherType type, int price, int days);

    void vaucherSortPrice();

    void vaucherSortDays();

    void vaucherSortType();

}
