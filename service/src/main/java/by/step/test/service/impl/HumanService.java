package by.step.test.service.impl;

import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;


@Service
public class HumanService implements IHumanService {
    @Autowired
    private IHumanRepository humanRepository;
    @Autowired
    private IVaucherRepository vaucherRepository;

    @Override
    public List<Human> findAll() {
        return humanRepository.findAll();
    }

    @Override
    public Human save(Human human) {
        return humanRepository.save(human);
    }

    @Override
    public void delete(Long id) {
        humanRepository.deleteById(id);
    }

    @Override
    public HumanDto findById(Long id) {
        Human human = humanRepository.findById(id).get();
        HumanDto humanDto = new HumanDto(human.getId(), human.getName(), human.getSurname()
                , human.getAge());
        return humanDto;
    }

    @Override
    public Human attachVauchers_ToHuman(Long humanId, Long vaucherId) {
        Human human = humanRepository.findById(humanId)
                .orElseThrow(EntityNotFoundException::new);
        Vaucher vaucher = vaucherRepository.findById(vaucherId)
                .orElseThrow(EntityNotFoundException::new);
        List<Vaucher> vaucherList = human.getVaucherList();
        vaucherList.add(vaucher);
        human.setVaucherList(vaucherList);
        return human;
    }

    //    @Override
//    public Human attachVaucherToHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.findById(humanId)
//                .orElseThrow(EntityNotFoundException::new);
//        Vaucher vaucher = vaucherRepository.findById(vaucherId)
//                .orElseThrow(EntityNotFoundException::new);
//        human.setVaucher(vaucher);
//        return human;
//    }


//    public List<Human> findAllByName(String name) {
//        List<Human> allHumansByName = humanRepository.findAllByName(name);
//        return allHumansByName;
//    }

//    @Override
//    public List<Human> findAllBySurnameAndAge(String surname, Integer age) {
//        return humanRepository.findAllBySurnameAndAge(surname, age);
//    }


}
