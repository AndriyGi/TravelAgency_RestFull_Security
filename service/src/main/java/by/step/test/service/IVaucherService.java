package by.step.test.service;

import by.step.test.dao.entity.Vaucher;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ExcVaucherNotFound;

import java.util.List;

public interface IVaucherService {

    List<VaucherDto> findAllVauchers();
    VaucherDto findById(Long id) throws ExcVaucherNotFound;
    VaucherDto saveNewVaucher(Vaucher vaucher);
    void deleteById (Long id);
    List<VaucherDto> findAllVauchersByHuman_Id(Long humanId);

    List<VaucherDto> attachVauchers_toHuman(Long humanId, Long vaucherId)
            throws   ExcVaucherNotFound;

}
