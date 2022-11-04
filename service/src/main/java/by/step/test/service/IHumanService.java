package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.exception.ExcEmptyHumansList;
import by.step.test.exception.ExcHumanIsPresent;
import by.step.test.exception.ExcVaucherNotFound;
import by.step.test.exception.ExcHumanNotFound;
import java.util.List;

public interface IHumanService {

    List<HumanDto> findAll() throws ExcEmptyHumansList;

    HumanDto save(Human human) throws ExcHumanIsPresent;

    Long delete(Long id);

    HumanDto findById(Long id) throws ExcHumanNotFound;

    List<HumanDto> findAllHumansByVaucher_Id(Long vaucherId) throws ExcVaucherNotFound;

    boolean existByEmail (String mail);

}
