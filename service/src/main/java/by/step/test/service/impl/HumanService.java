package by.step.test.service.impl;

import by.step.test.converterdto.HumanConverter;
import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.EntityNotFoundException;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IHumanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HumanService implements IHumanService {
    @Autowired
    private HumanConverter humanConverter;
    @Autowired
    private IHumanRepository humanRepository;
    @Autowired
    private IVaucherRepository vaucherRepository;
    @Autowired
    private HumanMapper humanMapper;
    @Autowired
    private VaucherMapper vaucherMapper;

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
       return humanConverter.fromHumanToHumanDto(human);

//        HumanDto humanDto = new HumanDto(human.getId(), human.getName(), human.getSurname()
//                , human.getAge());
//        return humanDto;
    }

    //    @Override
//    public HumanDto attachVauchers_toHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.attachVauchers_toHuman(humanId, vaucherId);
//        HumanDto humanDto = humanConverter.fromHumanToHumanDto(human);
//        return humanDto;
//    }
//    @Override
//    public Human attachVauchers_toHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.findById(humanId)
//                .orElseThrow(EntityNotFoundException::new);
//        HumanDto humanDto = humanConverter.fromHumanToHumanDto(human);
//
//        Vaucher vaucher = vaucherRepository.findById(vaucherId)
//                .orElseThrow(EntityNotFoundException::new);
//        VaucherDto vaucherDto = vaucherMapper.vaucherToVaucherDto(vaucher);
//
//        vaucher.setHuman(humanDto.getId());
//
//        List<Vaucher> vaucherList = human.setVaucherList(vaucherDto);
//        vaucherList.add(vaucherDto);
//        human.setVaucherList(vaucherDto);
//        return humanRepository.saveAndFlush(human);
//
//    }
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
