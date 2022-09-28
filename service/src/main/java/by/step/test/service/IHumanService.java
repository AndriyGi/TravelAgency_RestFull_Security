package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IHumanService {

    List<HumanDto> findAll();

    HumanDto save(Human human);

    void delete(Long id);

    HumanDto findById(Long id) throws ServiceException;

    List<HumanDto> findAllHumansByVaucher_Id(Long vaucherId);


//    HumanDto findHumanByVaucherId(Long id);

//    HumanDto attachVauchers_toHuman(Long humanId,Long vaucherId);

//    List<Human> findAllByName(String name);

//    List<Human> findAllBySurnameAndAge(String surname, Integer age);
//    @Query(value = "UPDATE human_vaucher_list set human_id = 1 where vaucher_list_id = 1",nativeQuery = true)


//    Human attachVaucherToHuman(Long humanId, Long vaucherId);

//    Human attachVauchers_toHuman(Long humanId, Long vaucherId);


}
