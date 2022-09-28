package by.step.test.service;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ServiceException;

import java.util.List;

public interface IVaucherService {

    List<VaucherDto> findAllVauchers();
    VaucherDto findById(Long id) throws ServiceException;
    VaucherDto saveNewVaucher(Vaucher vaucher);
    void deleteById (Long id);
    List<VaucherDto> findAllVauchersByHuman_Id(Long humanId);

    List<VaucherDto> attachVauchers_toHuman(Long humanId, Long vaucherId);
//     void save(Vaucher vaucher);





//    List<Vaucher> findVauchersByParam(VaucherType type, Double fromPrice, Double toPrice
//            , Integer fromDays, Integer toDays);


//    void vaucherSortPrice();
//    void vaucherSortDays();
//    void vaucherSortType();


//    VaucherType saveNewVaucherType(VaucherType vaucherType);
//    Object findAllByVaucherType(VaucherType vaucherType) throws ServiceException;

//    Vaucher getAllVauchers(List<Vaucher> vaucher);
//    List<VaucherType> findAllVaucherTypes();


}
