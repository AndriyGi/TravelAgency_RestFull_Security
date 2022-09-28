package by.step.test.service.impl;

import by.step.test.converterdto.HumanConverter;
import by.step.test.dao.entity.Human;
import by.step.test.dao.entity.Vaucher;
import by.step.test.dao.repository.IHumanRepository;
import by.step.test.dao.repository.IVaucherRepository;
import by.step.test.dto.HumanDto;
import by.step.test.dto.VaucherDto;
import by.step.test.exception.EntityNotFoundException;
import by.step.test.exception.ServiceException;
import by.step.test.mapper.HumanMapper;
import by.step.test.mapper.VaucherMapper;
import by.step.test.service.IHumanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HumanServiceImpl implements IHumanService {
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
    public HumanDto save(Human human) {
        HumanDto humanDto = humanMapper.humanToHumanDto(humanRepository.save(human));
        return humanDto;
    }

    @Override
    public void delete(Long id) {
        humanRepository.deleteById(id);
    }

    @Override
    public List<HumanDto> findAll() {
        List<HumanDto> humanDtoList = new ArrayList<>();
        List<Human> humanListAll = humanRepository.findAll();
        for (Human human1 : humanListAll) {
            HumanDto humanDto = humanMapper.humanToHumanDto(human1);
            humanDtoList.add(humanDto);
        }
        return humanDtoList;
    }

    @Override
    public HumanDto findById(Long id) throws ServiceException {
        Optional<Human> humanOpt = humanRepository.findById(id);
        if (humanOpt.isPresent()) {
            return humanMapper.humanToHumanDto(humanOpt.get());
        } else {
            throw new ServiceException("объект по ID не найден");
        }
    }

    @Override
    public List<HumanDto> findAllHumansByVaucher_Id(Long vaucherId) {
        Optional<Vaucher> vaucherOptional = vaucherRepository.findById(vaucherId);
        if (vaucherOptional.isPresent()) {
            Vaucher vaucher = vaucherOptional.get();
            List<Human> humanList = vaucher.getHumanList();
            List<HumanDto> humanDtoList = humanList.stream().map(
                    human -> humanMapper.humanToHumanDto(human)).collect(Collectors.toList());
            return humanDtoList;
        } else {
            throw new EntityNotFoundException("Vaucher not found by ID");
        }
    }
}

//    @Override
//    public HumanDto findHumanByVaucherId(Long id) {
//        Vaucher vaucher = vaucherRepository.findById(id)
//                .orElseThrow(EntityNotFoundException::new);
//        return humanMapper.humanToHumanDto(vaucher.getHuman());
//    }


        //    @Override
//    public HumanDto attachVauchers_toHuman(Long humanId, Long vaucherId) {
//        Human human = humanRepository.attachVauchers_toHuman(humanId, vaucherId);
//        HumanDto humanDto = humanConverter.fromHumanToHumanDto(human);
//        return humanDto;
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

