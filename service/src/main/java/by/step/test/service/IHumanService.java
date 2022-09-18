package by.step.test.service;

import by.step.test.dao.entity.Human;
import by.step.test.dto.HumanDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IHumanService {

    List<Human> findAll();
    Human save(Human human);
    void delete(Long id);

    HumanDto findById(Long id);



//    List<Human> findAllByName(String name);
//
//    List<Human> findAllBySurnameAndAge(String surname, Integer age);




//    Human attachVaucherToHuman(Long humanId, Long vaucherId);

    Human attachVauchers_ToHuman(Long humanId, Long vaucherId);



}
