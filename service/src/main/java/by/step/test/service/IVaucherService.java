package by.step.test.service;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.entity.VaucherType;
import by.step.test.exception.ServiceException;

import java.util.List;

public interface IVaucherService {

    List<Vaucher> findAllVauchers();
    Vaucher findById(Long id) throws ServiceException;
    Vaucher saveNewVaucher(Vaucher vaucher);
    Vaucher deleteVaucher(Vaucher vaucher);
    Vaucher buildVaucher(VaucherType type, int price, int days);

    public double calculateVaucherPrice(Vaucher vaucher);

    void vaucherSortPrice();
    void vaucherSortDays();
    void vaucherSortType();

    List<VaucherType> findAllVaucherTypes();
    VaucherType saveNewVaucherType(VaucherType vaucherType);

//    Vaucher getAllVauchers(List<Vaucher> vaucher);





}
